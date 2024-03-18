package cn.iocoder.yudao.module.system.controller.admin.app.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import java.util.*;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;
import com.alibaba.excel.annotation.*;

@Schema(description = "管理后台 - 应用 Response VO")
@Data
@ExcelIgnoreUnannotated
public class AppRespVO {

    @Schema(description = "自增主键", requiredMode = Schema.RequiredMode.REQUIRED, example = "30871")
    @ExcelProperty("自增主键")
    private Long id;

    @Schema(description = "应用名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "赵六")
    @ExcelProperty("应用名称")
    private String name;

    @Schema(description = "头像地址", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("头像地址")
    private String avatar;

    @Schema(description = "用户昵称", requiredMode = Schema.RequiredMode.REQUIRED, example = "王五")
    @ExcelProperty("用户昵称")
    private String nickname;

    @Schema(description = "描述", example = "随便")
    @ExcelProperty("描述")
    private String description;

    @Schema(description = "开场介绍")
    @ExcelProperty("开场介绍")
    private String prologue;

    @Schema(description = "相似度")
    @ExcelProperty("相似度")
    private String similarity;

    @Schema(description = "单词检索条数", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("单词检索条数")
    private Integer retrievedEntries;

    @Schema(description = "未命中策略 0--默认知识库  1--固定文案", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("未命中策略 0--默认知识库  1--固定文案")
    private String missedPolicies;

    @Schema(description = "固定文案")
    @ExcelProperty("固定文案")
    private String fixedCopy;

    @Schema(description = "知识库类型，字典值", example = "2")
    @ExcelProperty("知识库类型，字典值")
    private String knowledgeBaseType;

    @Schema(description = "记忆")
    @ExcelProperty("记忆")
    private String memory;

    @Schema(description = "温度")
    @ExcelProperty("温度")
    private String temperature;

    @Schema(description = "应用设定")
    @ExcelProperty("应用设定")
    private String appSetting;

    @Schema(description = "链接")
    @ExcelProperty("链接")
    private String link;

    @Schema(description = "创建时间", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("创建时间")
    private LocalDateTime createTime;

}