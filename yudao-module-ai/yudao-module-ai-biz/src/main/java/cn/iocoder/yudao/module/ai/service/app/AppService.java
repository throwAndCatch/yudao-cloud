package cn.iocoder.yudao.module.ai.service.app;

import javax.validation.*;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.module.ai.controller.admin.app.vo.AppPageReqVO;
import cn.iocoder.yudao.module.ai.controller.admin.app.vo.AppSaveReqVO;
import cn.iocoder.yudao.module.ai.dal.dataobject.app.AppDO;

/**
 * 应用 Service 接口
 *
 * @author 芋道源码
 */
public interface AppService {

    /**
     * 创建应用
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createApp(@Valid AppSaveReqVO createReqVO);

    /**
     * 更新应用
     *
     * @param updateReqVO 更新信息
     */
    void updateApp(@Valid AppSaveReqVO updateReqVO);

    /**
     * 删除应用
     *
     * @param id 编号
     */
    void deleteApp(Long id);

    /**
     * 获得应用
     *
     * @param id 编号
     * @return 应用
     */
    AppDO getApp(Long id);

    /**
     * 获得应用分页
     *
     * @param pageReqVO 分页查询
     * @return 应用分页
     */
    PageResult<AppDO> getAppPage(AppPageReqVO pageReqVO);




}