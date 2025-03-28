package com.tediouscat.tediouscatblog.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tediouscat.tediouscatblog.admin.convert.BlogSettingsConvert;
import com.tediouscat.tediouscatblog.admin.model.vo.blogsettings.FindBlogSettingsRspVO;
import com.tediouscat.tediouscatblog.admin.model.vo.blogsettings.UpdateBlogSettingsReqVO;
import com.tediouscat.tediouscatblog.admin.service.AdminBlogSettingsService;
import com.tediouscat.tediouscatblog.common.domain.dos.BlogSettingsDO;
import com.tediouscat.tediouscatblog.common.domain.mapper.BlogSettingsMapper;
import com.tediouscat.tediouscatblog.common.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminBlogSettingsServiceImpl extends ServiceImpl<BlogSettingsMapper, BlogSettingsDO> implements AdminBlogSettingsService {

    @Autowired
    private BlogSettingsMapper blogSettingsMapper;

    @Override
    public Response updateBlogSettings(UpdateBlogSettingsReqVO updateBlogSettingsReqVO) {
        // VO 转 DO
        BlogSettingsDO blogSettingsDO = BlogSettingsConvert.INSTANCE.convertVO2DO(updateBlogSettingsReqVO);
        blogSettingsDO.setId(1L);

        // 保存或更新（当数据库中存在 ID 为 1 的记录时，则执行更新操作，否则执行插入操作）
        saveOrUpdate(blogSettingsDO);
        return Response.success();
    }

    /**
     * 获取博客设置详情
     *
     * @return
     */
    @Override
    public Response findDetail() {
        // 查询 ID 为 1 的记录
        BlogSettingsDO blogSettingsDO = blogSettingsMapper.selectById(1L);

        // DO 转 VO
        FindBlogSettingsRspVO vo = BlogSettingsConvert.INSTANCE.convertDO2VO(blogSettingsDO);

        return Response.success(vo);
    }
}
