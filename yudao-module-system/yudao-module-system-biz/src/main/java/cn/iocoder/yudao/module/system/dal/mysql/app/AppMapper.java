package cn.iocoder.yudao.module.system.dal.mysql.app;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.system.controller.admin.app.vo.AppPageReqVO;
import cn.iocoder.yudao.module.system.dal.dataobject.app.AppDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * 应用 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface AppMapper extends BaseMapperX<AppDO> {

    default PageResult<AppDO> selectPage(AppPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<AppDO>()
                .likeIfPresent(AppDO::getName, reqVO.getName())
                .eqIfPresent(AppDO::getAvatar, reqVO.getAvatar())
                .likeIfPresent(AppDO::getNickname, reqVO.getNickname())
                .eqIfPresent(AppDO::getDescription, reqVO.getDescription())
                .eqIfPresent(AppDO::getPrologue, reqVO.getPrologue())
                .eqIfPresent(AppDO::getSimilarity, reqVO.getSimilarity())
                .eqIfPresent(AppDO::getRetrievedEntries, reqVO.getRetrievedEntries())
                .eqIfPresent(AppDO::getMissedPolicies, reqVO.getMissedPolicies())
                .eqIfPresent(AppDO::getFixedCopy, reqVO.getFixedCopy())
                .eqIfPresent(AppDO::getKnowledgeBaseType, reqVO.getKnowledgeBaseType())
                .eqIfPresent(AppDO::getMemory, reqVO.getMemory())
                .eqIfPresent(AppDO::getTemperature, reqVO.getTemperature())
                .eqIfPresent(AppDO::getAppSetting, reqVO.getAppSetting())
                .eqIfPresent(AppDO::getLink, reqVO.getLink())
                .betweenIfPresent(AppDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(AppDO::getId));
    }

}