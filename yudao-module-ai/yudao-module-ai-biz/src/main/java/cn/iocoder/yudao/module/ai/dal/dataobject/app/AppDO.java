package cn.iocoder.yudao.module.ai.dal.dataobject.app;

import lombok.*;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 应用 DO
 *
 * @author 芋道源码
 */
@TableName("ai_app")
@KeySequence("ai_app_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AppDO extends BaseDO {

    /**
     * 自增主键
     */
    @TableId
    private Long id;
    /**
     * 应用名称
     */
    private String name;
    /**
     * 头像地址
     */
    private String avatar;
    /**
     * 用户昵称
     */
    private String nickname;
    /**
     * 描述
     */
    private String description;
    /**
     * 开场介绍
     */
    private String prologue;
    /**
     * 相似度
     */
    private String similarity;
    /**
     * 单词检索条数
     */
    private Integer retrievedEntries;
    /**
     * 未命中策略 0--默认知识库  1--固定文案
     */
    private String missedPolicies;
    /**
     * 固定文案
     */
    private String fixedCopy;
    /**
     * 知识库类型，字典值
     */
    private String knowledgeBaseType;
    /**
     * 记忆
     */
    private String memory;
    /**
     * 温度
     */
    private String temperature;
    /**
     * 应用设定
     */
    private String appSetting;
    /**
     * 链接
     */
    private String link;

}