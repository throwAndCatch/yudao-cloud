package cn.iocoder.yudao.module.ai.remote.model.param;

import cn.iocoder.yudao.module.ai.remote.model.param.common.BodyParam;
import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author superzp
 * @date 2024/03/21 18:12
 */
@NoArgsConstructor
@Data
public class KnowledgeCreateBodyParam extends BodyParam {


    @JSONField(name = "knowledge_base_name")
    private String knowledgeBaseName;
    @JSONField(name = "vector_store_type")
    private String vectorStoreType;
    @JSONField(name = "embed_model")
    private String embedModel;
}
