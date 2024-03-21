package cn.iocoder.yudao.module.ai.remote.http;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 通用返回
 *
 * @author superzp
 */
@Data
@AllArgsConstructor
public class RemoteResult<T> {

    private Boolean success;

    /**
     * 接口调用结果状态：
     * -1 异常、0 失败、1 成功,2 重复调用
     */
    @JSONField(name = "code")
    private String code;

    @JSONField(name = "msg")
    private String message;

    /**
     * 本系统生成，用于追查日志
     */
    private String requestId;

    @JSONField(name = "data")
    private T data;


    public static <T> RemoteResult<T> fail(String code, String message, String requestId, T t) {
        return new RemoteResult<>(Boolean.FALSE, code, message, requestId, t);
    }

    public static <T> RemoteResult<T> success(String code, String message, String requestId, T t) {
        return new RemoteResult<>(Boolean.TRUE, code, message, requestId, t);
    }


    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

}



