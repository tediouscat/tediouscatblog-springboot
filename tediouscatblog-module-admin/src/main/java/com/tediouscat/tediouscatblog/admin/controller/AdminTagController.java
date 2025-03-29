package com.tediouscat.tediouscatblog.admin.controller;

import com.tediouscat.tediouscatblog.admin.model.vo.tag.AddTagReqVO;
import com.tediouscat.tediouscatblog.admin.service.AdminTagService;
import com.tediouscat.tediouscatblog.common.aspect.ApiOperationLog;
import com.tediouscat.tediouscatblog.common.utils.Response;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
@Api(tags = "Admin 标签模块")
public class AdminTagController {

    @Autowired
    private AdminTagService tagService;

    @PostMapping("/tag/add")
    @ApiOperation(value = "添加标签")
    @ApiOperationLog(description = "添加标签")
    public Response addTags(@RequestBody @Validated AddTagReqVO addTagReqVO) {
        return tagService.addTags(addTagReqVO);
    }

    // @PostMapping("/category/list")
    // @ApiOperation(value = "分类分页数据获取")
    // @ApiOperationLog(description = "分类分页数据获取")
    // public PageResponse findCategoryList(@RequestBody @Validated FindCategoryPageListReqVO findCategoryPageListReqVO) {
    //     return categoryService.findCategoryList(findCategoryPageListReqVO);
    // }
    //
    // @PostMapping("/category/delete")
    // @ApiOperation(value = "删除分类")
    // @ApiOperationLog(description = "删除分类")
    // @PreAuthorize("hasRole('ROLE_ADMIN')")
    // public Response deleteCategory(@RequestBody @Validated DeleteCategoryReqVO deleteCategoryReqVO) {
    //     return categoryService.deleteCategory(deleteCategoryReqVO);
    // }
    //
    // @PostMapping("/category/select/list")
    // @ApiOperation(value = "分类 Select 下拉列表数据获取")
    // @ApiOperationLog(description = "分类 Select 下拉列表数据获取")
    // public Response findCategorySelectList() {
    //     return categoryService.findCategorySelectList();
    // }


}
