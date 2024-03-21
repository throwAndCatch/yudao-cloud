package cn.iocoder.yudao.module.ai.controller.admin.app;

import cn.iocoder.yudao.module.ai.controller.admin.app.vo.AppPageReqVO;
import cn.iocoder.yudao.module.ai.controller.admin.app.vo.AppRespVO;
import cn.iocoder.yudao.module.ai.controller.admin.app.vo.AppSaveReqVO;
import cn.iocoder.yudao.module.ai.dal.dataobject.app.AppDO;
import cn.iocoder.yudao.module.ai.service.app.AppService;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;
import org.springframework.security.access.prepost.PreAuthorize;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Operation;

import javax.validation.*;
import javax.servlet.http.*;
import java.util.*;
import java.io.IOException;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;

import cn.iocoder.yudao.framework.excel.core.util.ExcelUtils;

import cn.iocoder.yudao.framework.operatelog.core.annotations.OperateLog;
import static cn.iocoder.yudao.framework.operatelog.core.enums.OperateTypeEnum.*;


@Tag(name = "管理后台 - 应用")
@RestController
@RequestMapping("/ai/app")
@Validated
public class AppController {

    @Resource
    private AppService appService;

    @PostMapping("/create")
    @Operation(summary = "创建应用")
    @PreAuthorize("@ss.hasPermission('ai:app:create')")
    public CommonResult<Long> createApp(@Valid @RequestBody AppSaveReqVO createReqVO) {
        return success(appService.createApp(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新应用")
    @PreAuthorize("@ss.hasPermission('ai:app:update')")
    public CommonResult<Boolean> updateApp(@Valid @RequestBody AppSaveReqVO updateReqVO) {
        appService.updateApp(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除应用")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('ai:app:delete')")
    public CommonResult<Boolean> deleteApp(@RequestParam("id") Long id) {
        appService.deleteApp(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得应用")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('ai:app:query')")
    public CommonResult<AppRespVO> getApp(@RequestParam("id") Long id) {
        AppDO app = appService.getApp(id);
        return success(BeanUtils.toBean(app, AppRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得应用分页")
    @PreAuthorize("@ss.hasPermission('ai:app:query')")
    public CommonResult<PageResult<AppRespVO>> getAppPage(@Valid AppPageReqVO pageReqVO) {
        PageResult<AppDO> pageResult = appService.getAppPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, AppRespVO.class));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出应用 Excel")
    @PreAuthorize("@ss.hasPermission('ai:app:export')")
    @OperateLog(type = EXPORT)
    public void exportAppExcel(@Valid AppPageReqVO pageReqVO,
              HttpServletResponse response) throws IOException {
        pageReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        List<AppDO> list = appService.getAppPage(pageReqVO).getList();
        // 导出 Excel
        ExcelUtils.write(response, "应用.xls", "数据", AppRespVO.class,
                        BeanUtils.toBean(list, AppRespVO.class));
    }

}