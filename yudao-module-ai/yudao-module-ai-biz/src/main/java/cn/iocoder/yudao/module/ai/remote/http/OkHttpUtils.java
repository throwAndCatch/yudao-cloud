package cn.iocoder.yudao.module.ai.remote.http;


import cn.iocoder.yudao.module.ai.remote.model.param.common.BodyParam;
import cn.iocoder.yudao.module.ai.remote.model.param.common.HeadParam;
import cn.iocoder.yudao.module.ai.remote.model.param.common.QueryParam;
import lombok.extern.slf4j.Slf4j;
import okhttp3.*;
import org.springframework.http.HttpHeaders;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 * okhttp工具类
 *
 * @author superzp
 */
@Slf4j
public class OkHttpUtils {


    public static final MediaType TYPE_JSON = MediaType.parse("application/json; charset=utf-8");


    private static final long READ_TIMEOUT = 60;
    private static final long CONNECT_TIMEOUT = 20;
    private static final long WRITE_TIMEOUT = 60;
    private final OkHttpClient mOkHttpClient;

    private OkHttpUtils() {
        OkHttpClient.Builder clientBuilder = new OkHttpClient.Builder();
        //读取超时
        clientBuilder.readTimeout(READ_TIMEOUT, TimeUnit.SECONDS);
        //连接超时
        clientBuilder.connectTimeout(CONNECT_TIMEOUT, TimeUnit.SECONDS);
        //写入超时
        clientBuilder.writeTimeout(WRITE_TIMEOUT, TimeUnit.SECONDS);
        mOkHttpClient = clientBuilder.build();
    }

    private static class SingletonHelper {
        private static final OkHttpUtils INSTANCE = new OkHttpUtils();
    }

    public static OkHttpUtils getInstance() {
        return SingletonHelper.INSTANCE;
    }

    public String postWithJson(String url, HeadParam headParam, BodyParam bodyParam, QueryParam param) throws IOException, IllegalAccessException {
        HttpUrl.Builder hb = formUrl(url, param);
        Request request = new Request.Builder()
                .url(hb.build())
                .header(HttpHeaders.AUTHORIZATION, headParam.getAuthorization())
//                .post(RequestBody.create(TYPE_JSON, toJSONString(bodyParam)))
                .post(RequestBody.create(null, ""))
                .build();
        log.info("headers:{}", request.headers().toString());
        log.info("url:{}", request.url().toString());
        log.info("body:{}", request.body().toString());

        return getResponseString(request);


    }

    private String getResponseString(Request request) throws IOException {
        try (Response response = mOkHttpClient.newCall(request).execute()) {
            log.info(response.toString());
            log.info(response.message());
            if (response.isSuccessful()) {
                log.info("Link Establishment Successful!!!");
                return response.body().string();
            }
            throw new IOException("convert OkHttpClient error!!!");
        } catch (Exception e) {
            throw new IOException("convert OkHttpClient error!!!", e);
        }
    }

    public String get(String url, HeadParam headParam, QueryParam param) throws IOException, IllegalAccessException {
        HttpUrl.Builder hb = formUrl(url, param);
        Request request = new Request.Builder()
                .url(hb.build())
                .header(HttpHeaders.AUTHORIZATION, headParam.getAuthorization())
                .get()
                .build();
        return getResponseString(request);
    }


    public static Map<String, String> getObjectToMap(Object obj) throws IllegalAccessException {
        if (ObjectUtils.isEmpty(obj)) {
            return null;
        }
        Map<String, String> map = new HashMap<>(16);
        Class<?> cla = obj.getClass();
        Field[] fields = cla.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            String keyName = field.getName();
            Object value = field.get(obj);
            if (value == null) {
                value = "";
            }
            map.put(keyName, String.valueOf(value));
        }
        return map;
    }

    public HttpUrl.Builder formUrl(String url, BodyParam param) throws IllegalAccessException {
        HttpUrl.Builder hb = Objects.requireNonNull(HttpUrl.parse(url)).newBuilder();

        Map<String, String> objectToMap = getObjectToMap(param);
        if (!CollectionUtils.isEmpty(objectToMap)) {
            objectToMap.forEach(hb::addQueryParameter);
        }
        return hb;
    }

    public HttpUrl.Builder formUrl(String url, QueryParam param) throws IllegalAccessException {
        HttpUrl.Builder hb = Objects.requireNonNull(HttpUrl.parse(url)).newBuilder();

        Map<String, String> objectToMap = getObjectToMap(param);
        if (!CollectionUtils.isEmpty(objectToMap)) {
            objectToMap.forEach(hb::addQueryParameter);
        }
        return hb;
    }


}
