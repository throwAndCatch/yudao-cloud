package cn.iocoder.yudao.module.ai.controller.admin.knowledgebase;

import cn.iocoder.yudao.module.ai.controller.admin.knowledgebase.vo.KnowledgeBasePageReqVO;
import cn.iocoder.yudao.module.ai.controller.admin.knowledgebase.vo.KnowledgeBaseRespVO;
import cn.iocoder.yudao.module.ai.controller.admin.knowledgebase.vo.KnowledgeBaseSaveReqVO;
import cn.iocoder.yudao.module.ai.dal.dataobject.knowledgebase.KnowledgeBaseDO;
import cn.iocoder.yudao.module.ai.service.knowledgebase.KnowledgeBaseService;
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


@Tag(name = "管理后台 - 知识库")
@RestController
@RequestMapping("/ai/knowledge-base")
@Validated
public class KnowledgeBaseController {

    @Resource
    private KnowledgeBaseService knowledgeBaseService;

    @PostMapping("/create")
    @Operation(summary = "创建知识库")
    @PreAuthorize("@ss.hasPermission('ai:knowledge-base:create')")
    public CommonResult<Long> createKnowledgeBase(@Valid @RequestBody KnowledgeBaseSaveReqVO createReqVO) {
        return success(knowledgeBaseService.createKnowledgeBase(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新知识库")
    @PreAuthorize("@ss.hasPermission('ai:knowledge-base:update')")
    public CommonResult<Boolean> updateKnowledgeBase(@Valid @RequestBody KnowledgeBaseSaveReqVO updateReqVO) {
        knowledgeBaseService.updateKnowledgeBase(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除知识库")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('ai:knowledge-base:delete')")
    public CommonResult<Boolean> deleteKnowledgeBase(@RequestParam("id") Long id) {
        knowledgeBaseService.deleteKnowledgeBase(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得知识库")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('ai:knowledge-base:query')")
    public CommonResult<KnowledgeBaseRespVO> getKnowledgeBase(@RequestParam("id") Long id) {
        KnowledgeBaseDO knowledgeBase = knowledgeBaseService.getKnowledgeBase(id);
        return success(BeanUtils.toBean(knowledgeBase, KnowledgeBaseRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得知识库分页")
    @PreAuthorize("@ss.hasPermission('ai:knowledge-base:query')")
    public CommonResult<PageResult<KnowledgeBaseRespVO>> getKnowledgeBasePage(@Valid KnowledgeBasePageReqVO pageReqVO) {
        PageResult<KnowledgeBaseDO> pageResult = knowledgeBaseService.getKnowledgeBasePage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, KnowledgeBaseRespVO.class));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出知识库 Excel")
    @PreAuthorize("@ss.hasPermission('ai:knowledge-base:export')")
    @OperateLog(type = EXPORT)
    public void exportKnowledgeBaseExcel(@Valid KnowledgeBasePageReqVO pageReqVO,
              HttpServletResponse response) throws IOException {
        pageReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        List<KnowledgeBaseDO> list = knowledgeBaseService.getKnowledgeBasePage(pageReqVO).getList();
        // 导出 Excel
        ExcelUtils.write(response, "知识库.xls", "数据", KnowledgeBaseRespVO.class,
                        BeanUtils.toBean(list, KnowledgeBaseRespVO.class));
    }

}