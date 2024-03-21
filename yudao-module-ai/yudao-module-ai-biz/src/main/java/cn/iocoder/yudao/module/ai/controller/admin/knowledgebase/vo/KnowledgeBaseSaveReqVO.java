package cn.iocoder.yudao.module.ai.controller.admin.knowledgebase.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import javax.validation.constraints.*;

@Schema(description = "管理后台 - 知识库新增/修改 Request VO")
@Data
public class KnowledgeBaseSaveReqVO {

    @Schema(description = "自增主键", requiredMode = Schema.RequiredMode.REQUIRED, example = "822")
    private Long id;

    @Schema(description = "知识库标题", requiredMode = Schema.RequiredMode.REQUIRED, example = "张三")
    @NotEmpty(message = "知识库标题不能为空")
    private String name;

    @Schema(description = "描述", example = "你说的对")
    private String description;

    @Schema(description = "模型端知识库id", example = "14446")
    private String backendKnowledgeId;

}