package com.tediouscat.tediouscatblog.admin.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tediouscat.tediouscatblog.admin.model.vo.tag.AddTagReqVO;
import com.tediouscat.tediouscatblog.admin.model.vo.tag.DeleteTagReqVO;
import com.tediouscat.tediouscatblog.admin.model.vo.tag.FindTagPageListReqVO;
import com.tediouscat.tediouscatblog.admin.model.vo.tag.FindTagPageListRspVO;
import com.tediouscat.tediouscatblog.admin.service.AdminTagService;
import com.tediouscat.tediouscatblog.common.domain.dos.TagDO;
import com.tediouscat.tediouscatblog.common.domain.mapper.TagMapper;
import com.tediouscat.tediouscatblog.common.enums.ResponseCodeEnum;
import com.tediouscat.tediouscatblog.common.utils.PageResponse;
import com.tediouscat.tediouscatblog.common.utils.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class AdminTagServiceImpl extends ServiceImpl<TagMapper, TagDO> implements AdminTagService {

    @Autowired
    private TagMapper tagMapper;

    /**
     * 添加标签集合
     *
     * @param addTagReqVO
     * @return
     */
    @Override
    public Response addTags(AddTagReqVO addTagReqVO) {
        // vo 转 do
        List<TagDO> tagDOS = addTagReqVO.getTags().stream()
                .map(tagName -> TagDO.builder()
                        .name(tagName.trim()) // 去掉前后空格
                        .createTime(LocalDateTime.now())
                        .updateTime(LocalDateTime.now())
                        .build())
                .collect(Collectors.toList());

        // 批量插入
        try {
            saveBatch(tagDOS);
        } catch (Exception e) {
            log.warn("该标签已存在", e);
        }

        return Response.success();
    }

    /**
     * 查询标签分页
     *
     * @param findTagPageListReqVO
     * @return
     */
    @Override
    public PageResponse findTagPageList(FindTagPageListReqVO findTagPageListReqVO) {
        // 分页参数、条件参数
        Long current = findTagPageListReqVO.getCurrent();
        Long size = findTagPageListReqVO.getSize();
        String name = findTagPageListReqVO.getName();
        LocalDate startDate = findTagPageListReqVO.getStartDate();
        LocalDate endDate = findTagPageListReqVO.getEndDate();

        // 分页查询
        Page<TagDO> page = tagMapper.selectPageList(current, size, name, startDate, endDate);

        List<TagDO> records = page.getRecords();

        // do 转 vo
        List<FindTagPageListRspVO> vos = null;
        if (!CollectionUtils.isEmpty(records)) {
            vos = records.stream().map(tagDO -> FindTagPageListRspVO.builder()
                    .id(tagDO.getId())
                    .name(tagDO.getName())
                    .createTime(tagDO.getCreateTime())
                    .build()).collect(Collectors.toList());
        }

        return PageResponse.success(page, vos);
    }

    public Response deleteTag(DeleteTagReqVO deleteTagReqVO) {
        // 标签 ID
        Long tagId = deleteTagReqVO.getId();

        // 根据标签 ID 删除
        int count = tagMapper.deleteById(tagId);

        return count == 1 ? Response.success() : Response.fail(ResponseCodeEnum.TAG_NOT_EXISTED);
    }
}
