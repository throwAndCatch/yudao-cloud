package cn.iocoder.yudao.module.ai.dal.dataobject.knowledgebase;

import lombok.*;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 知识库 DO
 *
 * @author 芋道源码
 */
@TableName("ai_knowledge_base")
@KeySequence("ai_knowledge_base_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class KnowledgeBaseDO extends BaseDO {

    /**
     * 自增主键
     */
    @TableId
    private Long id;
    /**
     * 知识库标题
     */
    private String name;
    /**
     * 描述
     */
    private String description;
    /**
     * 模型端知识库id
     */
    private String backendKnowledgeId;

}