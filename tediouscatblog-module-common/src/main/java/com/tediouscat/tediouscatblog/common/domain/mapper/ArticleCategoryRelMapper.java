package com.tediouscat.tediouscatblog.common.domain.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.tediouscat.tediouscatblog.common.domain.dos.ArticleCategoryRelDO;

public interface ArticleCategoryRelMapper extends BaseMapper<ArticleCategoryRelDO> {
    /**
     * 根据文章 ID 删除关联记录
     * @param articleId
     * @return
     */
    default int deleteByArticleId(Long articleId) {
        return delete(Wrappers.<ArticleCategoryRelDO>lambdaQuery()
                .eq(ArticleCategoryRelDO::getArticleId, articleId));
    }
}
