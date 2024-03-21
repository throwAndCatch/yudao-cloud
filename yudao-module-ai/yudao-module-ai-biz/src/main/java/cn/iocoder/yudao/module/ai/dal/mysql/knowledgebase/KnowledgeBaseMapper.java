package cn.iocoder.yudao.module.ai.dal.mysql.knowledgebase;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.ai.controller.admin.knowledgebase.vo.KnowledgeBasePageReqVO;
import cn.iocoder.yudao.module.ai.dal.dataobject.knowledgebase.KnowledgeBaseDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * 知识库 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface KnowledgeBaseMapper extends BaseMapperX<KnowledgeBaseDO> {

    default PageResult<KnowledgeBaseDO> selectPage(KnowledgeBasePageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<KnowledgeBaseDO>()
                .likeIfPresent(KnowledgeBaseDO::getName, reqVO.getName())
                .eqIfPresent(KnowledgeBaseDO::getDescription, reqVO.getDescription())
                .eqIfPresent(KnowledgeBaseDO::getBackendKnowledgeId, reqVO.getBackendKnowledgeId())
                .betweenIfPresent(KnowledgeBaseDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(KnowledgeBaseDO::getId));
    }

}