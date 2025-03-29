package com.tediouscat.tediouscatblog.common.domain.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.tediouscat.tediouscatblog.common.domain.dos.ArticleContentDO;

public interface ArticleContentMapper extends BaseMapper<ArticleContentDO> {

    /**
     * 根据文章 ID 删除记录
     * @param articleId
     * @return
     */
    default int deleteByArticleId(Long articleId) {
        return delete(Wrappers.<ArticleContentDO>lambdaQuery()
                .eq(ArticleContentDO::getArticleId, articleId));
    }
}
