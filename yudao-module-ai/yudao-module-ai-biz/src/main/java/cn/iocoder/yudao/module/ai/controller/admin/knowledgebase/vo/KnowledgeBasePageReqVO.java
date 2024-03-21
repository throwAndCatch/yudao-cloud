package cn.iocoder.yudao.module.ai.controller.admin.knowledgebase.vo;

import lombok.*;
import io.swagger.v3.oas.annotations.media.Schema;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "管理后台 - 知识库分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class KnowledgeBasePageReqVO extends PageParam {

    @Schema(description = "知识库标题", example = "张三")
    private String name;

    @Schema(description = "描述", example = "你说的对")
    private String description;

    @Schema(description = "模型端知识库id", example = "14446")
    private String backendKnowledgeId;

    @Schema(description = "创建时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

}