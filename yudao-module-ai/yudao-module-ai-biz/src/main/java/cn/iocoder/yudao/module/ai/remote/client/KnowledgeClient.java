package cn.iocoder.yudao.module.ai.remote.client;

import cn.iocoder.yudao.module.ai.remote.http.RemoteResult;
import cn.iocoder.yudao.module.ai.remote.model.param.common.BodyParam;
import cn.iocoder.yudao.module.ai.remote.model.result.KnowledgeCreateResult;

/**
 * 知识库相关
 * @author superzp
 */
public interface KnowledgeClient {

    RemoteResult<KnowledgeCreateResult> create(BodyParam bodyParam);

}
