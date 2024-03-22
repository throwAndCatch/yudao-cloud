package cn.iocoder.yudao.module.ai.controller.admin.app.vo;

import lombok.*;
import io.swagger.v3.oas.annotations.media.Schema;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "管理后台 - 应用分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class AppPageReqVO extends PageParam {

    @Schema(description = "应用名称", example = "赵六")
    private String name;

    @Schema(description = "头像地址")
    private String avatar;



    @Schema(description = "描述", example = "随便")
    private String description;

    @Schema(description = "开场介绍")
    private String prologue;

    @Schema(description = "相似度")
    private String similarity;

    @Schema(description = "单词检索条数")
    private Integer retrievedEntries;

    @Schema(description = "未命中策略 0--默认知识库  1--固定文案")
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

    @Schema(description = "创建时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

}