package cn.iocoder.yudao.module.ai.controller.admin.knowledgebase.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.time.LocalDateTime;
import com.alibaba.excel.annotation.*;

@Schema(description = "管理后台 - 知识库 Response VO")
@Data
@ExcelIgnoreUnannotated
public class KnowledgeBaseRespVO {

    @Schema(description = "自增主键", requiredMode = Schema.RequiredMode.REQUIRED, example = "822")
    @ExcelProperty("自增主键")
    private Long id;

    @Schema(description = "知识库标题", requiredMode = Schema.RequiredMode.REQUIRED, example = "张三")
    @ExcelProperty("知识库标题")
    private String name;

    @Schema(description = "描述", example = "你说的对")
    @ExcelProperty("描述")
    private String description;

    @Schema(description = "模型端知识库id", example = "14446")
    @ExcelProperty("模型端知识库id")
    private String backendKnowledgeId;

    @Schema(description = "创建时间", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("创建时间")
    private LocalDateTime createTime;

}