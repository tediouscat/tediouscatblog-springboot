package com.tediouscat.tediouscatblog.admin.controller;

import com.tediouscat.tediouscatblog.admin.model.vo.category.DeleteCategoryReqVO;
import com.tediouscat.tediouscatblog.admin.model.vo.tag.AddTagReqVO;
import com.tediouscat.tediouscatblog.admin.model.vo.tag.DeleteTagReqVO;
import com.tediouscat.tediouscatblog.admin.model.vo.tag.FindTagPageListReqVO;
import com.tediouscat.tediouscatblog.admin.model.vo.tag.SearchTagsReqVO;
import com.tediouscat.tediouscatblog.admin.service.AdminTagService;
import com.tediouscat.tediouscatblog.common.aspect.ApiOperationLog;
import com.tediouscat.tediouscatblog.common.utils.PageResponse;
import com.tediouscat.tediouscatblog.common.utils.Response;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin/tag")
@Api(tags = "Admin 标签模块")
public class AdminTagController {

    @Autowired
    private AdminTagService tagService;

    @PostMapping("/add")
    @ApiOperation(value = "添加标签")
    @ApiOperationLog(description = "添加标签")
    public Response addTags(@RequestBody @Validated AddTagReqVO addTagReqVO) {
        return tagService.addTags(addTagReqVO);
    }

    @PostMapping("/list")
    @ApiOperation(value = "标签分页数据获取")
    @ApiOperationLog(description = "标签分页数据获取")
    public PageResponse findTagPageList(@RequestBody @Validated FindTagPageListReqVO findTagPageListReqVO) {
        return tagService.findTagPageList(findTagPageListReqVO);
    }

     @PostMapping("/delete")
     @ApiOperation(value = "删除标签")
     @ApiOperationLog(description = "删除标签")
     @PreAuthorize("hasRole('ROLE_ADMIN')")
     public Response deleteCategory(@RequestBody @Validated DeleteTagReqVO deleteTagReqVO) {
         return tagService.deleteTag(deleteTagReqVO);
     }

    @PostMapping("/search")
    @ApiOperation(value = "标签模糊查询")
    @ApiOperationLog(description = "标签模糊查询")
    public Response searchTags(@RequestBody @Validated SearchTagsReqVO searchTagsReqVO) {
        return tagService.searchTags(searchTagsReqVO);
    }

    @PostMapping("/select/list")
    @ApiOperation(value = "查询标签 Select 列表数据")
    @ApiOperationLog(description = "查询标签 Select 列表数据")
    public Response findTagSelectList() {
        return tagService.findTagSelectList();
    }

}
