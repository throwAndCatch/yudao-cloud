package cn.iocoder.yudao.module.ai.remote.parser;

import cn.iocoder.yudao.module.ai.remote.http.RemoteResult;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;

/**
 * 默认转换器：json
 *
 * @author superzp
 */
public class DefaultParser implements RemoteResultParser {

    @Override
    public <T> RemoteResult<T> parse(String json, Class<T> type) {
        return JSON.parseObject(json,
                new TypeReference<RemoteResult<T>>(type) {
                }
        );
    }
}
