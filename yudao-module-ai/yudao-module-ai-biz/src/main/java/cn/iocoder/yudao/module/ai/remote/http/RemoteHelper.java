package cn.iocoder.yudao.module.ai.remote.http;

import cn.iocoder.yudao.module.ai.remote.model.param.common.BodyParam;
import cn.iocoder.yudao.module.ai.remote.model.param.common.HeadParam;
import cn.iocoder.yudao.module.ai.remote.model.param.common.QueryParam;
import cn.iocoder.yudao.module.ai.remote.parser.DefaultParser;
import cn.iocoder.yudao.module.ai.remote.parser.RemoteResultParser;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ArrayUtils;

/**
 * @author superzp
 */
@Slf4j
public class RemoteHelper {


    private static final RemoteResultParser DEFAULT_PARSER = new DefaultParser();


    public static <T> RemoteResult<T> callPost(
            String url,
            HeadParam headParam,
            QueryParam queryParam,
            BodyParam bodyParam,
            Class<T> type, RemoteResultParser... parsers) {
        RemoteResult<T> remoteResult;
        try {

            String json = OkHttpUtils.getInstance().postWithJson(url, headParam, bodyParam, queryParam);
            log.info("返回结果：{}",json);
            RemoteResultParser parser = DEFAULT_PARSER;
            if (parsers != null && !ArrayUtils.isEmpty(parsers)) {
                parser = parsers[0];
            }
            remoteResult = build(json, type, parser);
        } catch (Exception e) {
            log.error("remote call error, url={}, remoteParam={}", url, bodyParam, e);
            remoteResult = RemoteResult.fail("", "", "", null);
        }
        return remoteResult;
    }


    public static <T> RemoteResult<T> callGet(
            String url,
            HeadParam headParam,
            QueryParam param,
            Class<T> type, RemoteResultParser... parsers) {
        RemoteResult<T> remoteResult;
        try {

            String json = OkHttpUtils.getInstance().get(url, headParam, param);
            log.info("返回结果：{}",json);
            RemoteResultParser parser = DEFAULT_PARSER;
            if (parsers != null && !ArrayUtils.isEmpty(parsers)) {
                parser = parsers[0];
            }
            remoteResult = build(json, type, parser);
        } catch (Exception e) {
            log.error("remote call error, url={}, remoteParam={}", url, param, e);
            remoteResult = RemoteResult.fail("", "", "", null);
        }
        return remoteResult;
    }


    private static <T> RemoteResult<T> build(String json, Class<T> type, RemoteResultParser parser) {

        RemoteResult<T> remoteResult;
        try {
            remoteResult = parser.parse(json, type);
        } catch (Exception e) {
            log.error("Exception error, ", e);
            remoteResult = RemoteResult.fail("", "", "", null);
        }
        return remoteResult;
    }


    private static String sign(){



//        第一步：拼接符串（注意结果转成小写，接口名字不带@符号）
//        (接口名字 + paramsData + apiSt + apiSecret).toLowerCase()
//        示例：
//        listentinfo{"ucoordx":"120.107487","ucoordy":"30.272657","provinceid":"33","cityid":"3301","districtid":"330105","pageindex":"0","ordertype":"1","serviceid":200006000}20191011100553b55c936cd48048499ffb5d71227711f8
//        第二步：将拼接好的字符串，进行MD5加密（注意结果转成小写）
//        MD5(拼接好的字符串).toLowerCase()
        return "";
    }



}
