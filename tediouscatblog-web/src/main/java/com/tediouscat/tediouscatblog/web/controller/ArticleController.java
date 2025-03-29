package com.tediouscat.tediouscatblog.web.controller;

import com.tediouscat.tediouscatblog.common.aspect.ApiOperationLog;
import com.tediouscat.tediouscatblog.common.utils.Response;
import com.tediouscat.tediouscatblog.web.model.vo.article.FindIndexArticlePageListReqVO;
import com.tediouscat.tediouscatblog.web.service.ArticleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags = "文章")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @PostMapping("/article/list")
    @ApiOperation(value = "获取首页文章分页数据")
    @ApiOperationLog(description = "获取首页文章分页数据")
    public Response findArticlePageList(@RequestBody FindIndexArticlePageListReqVO findIndexArticlePageListReqVO) {
        return articleService.findArticlePageList(findIndexArticlePageListReqVO);
    }

}
