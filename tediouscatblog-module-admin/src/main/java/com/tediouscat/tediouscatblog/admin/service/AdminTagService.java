package com.tediouscat.tediouscatblog.admin.service;

import com.tediouscat.tediouscatblog.admin.model.vo.tag.AddTagReqVO;
import com.tediouscat.tediouscatblog.admin.model.vo.tag.DeleteTagReqVO;
import com.tediouscat.tediouscatblog.admin.model.vo.tag.FindTagPageListReqVO;
import com.tediouscat.tediouscatblog.common.utils.PageResponse;
import com.tediouscat.tediouscatblog.common.utils.Response;

public interface AdminTagService {

    /**
     * 添加标签集合
     * @param addTagReqVO
     * @return
     */
    Response addTags(AddTagReqVO addTagReqVO);

    /**
     * 查询标签分页
     * @param findTagPageListReqVO
     * @return
     */
    PageResponse findTagPageList(FindTagPageListReqVO findTagPageListReqVO);

    /**
     * 删除标签
     * @param deleteTagReqVO
     * @return
     */
    Response deleteTag(DeleteTagReqVO deleteTagReqVO);
}
