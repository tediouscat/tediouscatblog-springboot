package com.tediouscat.tediouscatblog.web.service;

import com.tediouscat.tediouscatblog.common.utils.Response;

public interface BlogSettingsService {
    /**
     * 获取博客设置信息
     * @return
     */
    Response findDetail();
}
