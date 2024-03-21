package cn.iocoder.yudao.module.ai.remote.parser;


import cn.iocoder.yudao.module.ai.remote.http.RemoteResult;

/**
 * @author superzp
 */
public interface RemoteResultParser {


    <T> RemoteResult<T> parse(String json, Class<T> type);

}
