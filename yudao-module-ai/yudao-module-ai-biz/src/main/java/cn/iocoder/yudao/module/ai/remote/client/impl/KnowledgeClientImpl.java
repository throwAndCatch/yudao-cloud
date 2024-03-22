package cn.iocoder.yudao.module.ai.remote.client.impl;

import cn.iocoder.yudao.module.ai.remote.client.KnowledgeClient;
import cn.iocoder.yudao.module.ai.remote.config.LangchainPropertiesConfig;
import cn.iocoder.yudao.module.ai.remote.http.RemoteHelper;
import cn.iocoder.yudao.module.ai.remote.http.RemoteResult;
import cn.iocoder.yudao.module.ai.remote.model.param.common.BodyParam;
import cn.iocoder.yudao.module.ai.remote.model.param.common.HeadParam;
import cn.iocoder.yudao.module.ai.remote.model.param.common.QueryParam;
import cn.iocoder.yudao.module.ai.remote.model.result.KnowledgeCreateResult;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author superzp
 * @date 2024/03/21 17:51
 */
@Component
public class KnowledgeClientImpl implements KnowledgeClient {


    @Resource
    private LangchainPropertiesConfig langchainPropertiesConfig;

    @Override
    public RemoteResult<KnowledgeCreateResult> create(BodyParam bodyParam) {

        RemoteResult<KnowledgeCreateResult> result = RemoteHelper.callPost(
                langchainPropertiesConfig.getHost() + langchainPropertiesConfig.getKnowledgeCreate(),
                new HeadParam(""),
                new QueryParam(),
                bodyParam,
                KnowledgeCreateResult.class
        );
        return result;
    }





}
