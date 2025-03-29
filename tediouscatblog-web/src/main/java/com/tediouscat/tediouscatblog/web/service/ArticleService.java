package com.tediouscat.tediouscatblog.web.service;

import com.tediouscat.tediouscatblog.common.utils.Response;
import com.tediouscat.tediouscatblog.web.model.vo.article.FindIndexArticlePageListReqVO;

public interface ArticleService {
    /**
     * 获取首页文章分页数据
     * @param findIndexArticlePageListReqVO
     * @return
     */
    Response findArticlePageList(FindIndexArticlePageListReqVO findIndexArticlePageListReqVO);
}
