package com.tediouscat.tediouscatblog.web.service;

import com.tediouscat.tediouscatblog.common.utils.Response;

public interface TagService {
    /**
     * 获取标签列表
     * @return
     */
    Response findTagList();
}
