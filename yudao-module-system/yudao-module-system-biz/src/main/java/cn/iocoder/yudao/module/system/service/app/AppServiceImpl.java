package cn.iocoder.yudao.module.system.service.app;

import cn.iocoder.yudao.module.system.controller.admin.app.vo.AppPageReqVO;
import cn.iocoder.yudao.module.system.controller.admin.app.vo.AppSaveReqVO;
import cn.iocoder.yudao.module.system.dal.dataobject.app.AppDO;
import cn.iocoder.yudao.module.system.dal.mysql.app.AppMapper;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;


import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.system.enums.ErrorCodeConstants.APP_NOT_EXISTS;

/**
 * 应用 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class AppServiceImpl implements AppService {

    @Resource
    private AppMapper appMapper;

    @Override
    public Long createApp(AppSaveReqVO createReqVO) {
        // 插入
        AppDO app = BeanUtils.toBean(createReqVO, AppDO.class);
        appMapper.insert(app);
        // 返回
        return app.getId();
    }

    @Override
    public void updateApp(AppSaveReqVO updateReqVO) {
        // 校验存在
        validateAppExists(updateReqVO.getId());
        // 更新
        AppDO updateObj = BeanUtils.toBean(updateReqVO, AppDO.class);
        appMapper.updateById(updateObj);
    }

    @Override
    public void deleteApp(Long id) {
        // 校验存在
        validateAppExists(id);
        // 删除
        appMapper.deleteById(id);
    }

    private void validateAppExists(Long id) {
        if (appMapper.selectById(id) == null) {
            throw exception(APP_NOT_EXISTS);
        }
    }

    @Override
    public AppDO getApp(Long id) {
        return appMapper.selectById(id);
    }

    @Override
    public PageResult<AppDO> getAppPage(AppPageReqVO pageReqVO) {
        return appMapper.selectPage(pageReqVO);
    }

}