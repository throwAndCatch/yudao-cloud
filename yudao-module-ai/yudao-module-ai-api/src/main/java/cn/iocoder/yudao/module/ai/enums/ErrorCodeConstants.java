package cn.iocoder.yudao.module.ai.enums;

import cn.iocoder.yudao.framework.common.exception.ErrorCode;

/**
 * ai 错误码枚举类
 *
 * system 系统，使用 1-002-000-000 段
 */
public interface ErrorCodeConstants {


    ErrorCode APP_NOT_EXISTS = new ErrorCode(1_002_028_001, "应用不存在");
    ErrorCode KNOWLEDGE_BASE_NOT_EXISTS = new ErrorCode(1_002_028_002, "知识库不存在");

    ErrorCode KNOWLEDGE_NAME_EXISTS = new ErrorCode(1_002_028_003, "知识库名称已经存在");

}
