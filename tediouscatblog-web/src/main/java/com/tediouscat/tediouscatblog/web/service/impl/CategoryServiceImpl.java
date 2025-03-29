package com.tediouscat.tediouscatblog.web.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.tediouscat.tediouscatblog.common.domain.dos.CategoryDO;
import com.tediouscat.tediouscatblog.common.domain.mapper.CategoryMapper;
import com.tediouscat.tediouscatblog.common.utils.Response;
import com.tediouscat.tediouscatblog.web.model.vo.category.FindCategoryListRspVO;
import com.tediouscat.tediouscatblog.web.service.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    /**
     * 获取分类列表
     *
     * @return
     */
    @Override
    public Response findCategoryList() {
        // 查询所有分类
        List<CategoryDO> categoryDOS = categoryMapper.selectList(Wrappers.emptyWrapper());

        // DO 转 VO
        List<FindCategoryListRspVO> vos = null;
        if (!CollectionUtils.isEmpty(categoryDOS)) {
            vos = categoryDOS.stream()
                    .map(categoryDO -> FindCategoryListRspVO.builder()
                            .id(categoryDO.getId())
                            .name(categoryDO.getName())
                            .build())
                    .collect(Collectors.toList());
        }

        return Response.success(vos);
    }
}
