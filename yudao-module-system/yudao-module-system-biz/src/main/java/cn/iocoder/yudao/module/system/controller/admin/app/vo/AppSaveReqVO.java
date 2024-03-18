package cn.iocoder.yudao.module.system.controller.admin.app.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import javax.validation.constraints.*;

@Schema(description = "管理后台 - 应用新增/修改 Request VO")
@Data
public class AppSaveReqVO {

    @Schema(description = "自增主键", requiredMode = Schema.RequiredMode.REQUIRED, example = "30871")
    private Long id;

    @Schema(description = "应用名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "赵六")
    @NotEmpty(message = "应用名称不能为空")
    private String name;

    @Schema(description = "头像地址", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotEmpty(message = "头像地址不能为空")
    private String avatar;

    @Schema(description = "用户昵称", requiredMode = Schema.RequiredMode.REQUIRED, example = "王五")
    @NotEmpty(message = "用户昵称不能为空")
    private String nickname;

    @Schema(description = "描述", example = "随便")
    private String description;

    @Schema(description = "开场介绍")
    private String prologue;

    @Schema(description = "相似度")
    private String similarity;

    @Schema(description = "单词检索条数", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "单词检索条数不能为空")
    private Integer retrievedEntries;

    @Schema(description = "未命中策略 0--默认知识库  1--固定文案", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotEmpty(message = "未命中策略 0--默认知识库  1--固定文案不能为空")
    private String missedPolicies;

    @Schema(description = "固定文案")
    private String fixedCopy;

    @Schema(description = "知识库类型，字典值", example = "2")
    private String knowledgeBaseType;

    @Schema(description = "记忆")
    private String memory;

    @Schema(description = "温度")
    private String temperature;

    @Schema(description = "应用设定")
    private String appSetting;

    @Schema(description = "链接")
    private String link;

}