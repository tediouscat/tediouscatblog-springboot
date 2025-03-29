package com.tediouscat.tediouscatblog.web.service;

import com.tediouscat.tediouscatblog.common.utils.Response;

public interface CategoryService {
    /**
     * 获取分类列表
     * @return
     */
    Response findCategoryList();
}
