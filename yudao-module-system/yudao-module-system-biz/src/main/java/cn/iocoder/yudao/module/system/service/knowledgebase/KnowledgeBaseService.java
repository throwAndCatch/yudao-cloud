package cn.iocoder.yudao.module.system.service.knowledgebase;

import java.util.*;
import javax.validation.*;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.module.system.controller.admin.knowledgebase.vo.KnowledgeBasePageReqVO;
import cn.iocoder.yudao.module.system.controller.admin.knowledgebase.vo.KnowledgeBaseSaveReqVO;
import cn.iocoder.yudao.module.system.dal.dataobject.knowledgebase.KnowledgeBaseDO;

/**
 * 知识库 Service 接口
 *
 * @author 芋道源码
 */
public interface KnowledgeBaseService {

    /**
     * 创建知识库
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createKnowledgeBase(@Valid KnowledgeBaseSaveReqVO createReqVO);

    /**
     * 更新知识库
     *
     * @param updateReqVO 更新信息
     */
    void updateKnowledgeBase(@Valid KnowledgeBaseSaveReqVO updateReqVO);

    /**
     * 删除知识库
     *
     * @param id 编号
     */
    void deleteKnowledgeBase(Long id);

    /**
     * 获得知识库
     *
     * @param id 编号
     * @return 知识库
     */
    KnowledgeBaseDO getKnowledgeBase(Long id);

    /**
     * 获得知识库分页
     *
     * @param pageReqVO 分页查询
     * @return 知识库分页
     */
    PageResult<KnowledgeBaseDO> getKnowledgeBasePage(KnowledgeBasePageReqVO pageReqVO);

}