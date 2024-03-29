package cn.iocoder.yudao.module.ai.service.knowledgebase;

import cn.iocoder.yudao.framework.common.exception.ServiceException;
import cn.iocoder.yudao.module.ai.controller.admin.knowledgebase.vo.KnowledgeBasePageReqVO;
import cn.iocoder.yudao.module.ai.controller.admin.knowledgebase.vo.KnowledgeBaseSaveReqVO;
import cn.iocoder.yudao.module.ai.dal.dataobject.knowledgebase.KnowledgeBaseDO;
import cn.iocoder.yudao.module.ai.dal.mysql.knowledgebase.KnowledgeBaseMapper;
import cn.iocoder.yudao.module.ai.remote.client.KnowledgeClient;
import cn.iocoder.yudao.module.ai.remote.http.RemoteResult;
import cn.iocoder.yudao.module.ai.remote.model.param.KnowledgeCreateBodyParam;
import cn.iocoder.yudao.module.ai.remote.model.result.KnowledgeCreateResult;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import org.springframework.validation.annotation.Validated;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;


import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.ai.enums.ErrorCodeConstants.KNOWLEDGE_BASE_NOT_EXISTS;
import static cn.iocoder.yudao.module.ai.enums.ErrorCodeConstants.KNOWLEDGE_NAME_EXISTS;

/**
 * 知识库 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class KnowledgeBaseServiceImpl implements KnowledgeBaseService {

    @Resource
    private KnowledgeBaseMapper knowledgeBaseMapper;

    @Resource
    private KnowledgeClient knowledgeClient;

    @Override
    public Long createKnowledgeBase(KnowledgeBaseSaveReqVO createReqVO) {
        // 插入
        KnowledgeBaseDO knowledgeBase = BeanUtils.toBean(createReqVO, KnowledgeBaseDO.class);

        KnowledgeCreateBodyParam knowledgeCreateBodyParam = new KnowledgeCreateBodyParam();
        knowledgeCreateBodyParam.setKnowledgeBaseName(createReqVO.getBackendKnowledgeId());
//        knowledgeCreateBodyParam.setVectorStoreType();
//        knowledgeCreateBodyParam.setEmbedModel();
        RemoteResult<KnowledgeCreateResult> result = knowledgeClient.create(knowledgeCreateBodyParam);
        if (!result.getSuccess()) {
            throw exception(KNOWLEDGE_NAME_EXISTS);
        }
        knowledgeBaseMapper.insert(knowledgeBase);
        // 返回
        return knowledgeBase.getId();
    }

    @Override
    public void updateKnowledgeBase(KnowledgeBaseSaveReqVO updateReqVO) {
        // 校验存在
        validateKnowledgeBaseExists(updateReqVO.getId());
        // 更新
        KnowledgeBaseDO updateObj = BeanUtils.toBean(updateReqVO, KnowledgeBaseDO.class);
        knowledgeBaseMapper.updateById(updateObj);
    }

    @Override
    public void deleteKnowledgeBase(Long id) {
        // 校验存在
        validateKnowledgeBaseExists(id);
        // 删除
        knowledgeBaseMapper.deleteById(id);
    }

    private void validateKnowledgeBaseExists(Long id) {
        if (knowledgeBaseMapper.selectById(id) == null) {
            throw exception(KNOWLEDGE_BASE_NOT_EXISTS);
        }
    }

    @Override
    public KnowledgeBaseDO getKnowledgeBase(Long id) {
        return knowledgeBaseMapper.selectById(id);
    }

    @Override
    public PageResult<KnowledgeBaseDO> getKnowledgeBasePage(KnowledgeBasePageReqVO pageReqVO) {
        return knowledgeBaseMapper.selectPage(pageReqVO);
    }




}