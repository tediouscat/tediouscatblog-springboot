package com.tediouscat.tediouscatblog.admin.controller;

import com.tediouscat.tediouscatblog.admin.model.vo.UpdateAdminUserPasswordReqVO;
import com.tediouscat.tediouscatblog.admin.service.AdminUserService;
import com.tediouscat.tediouscatblog.common.aspect.ApiOperationLog;
import com.tediouscat.tediouscatblog.common.utils.Response;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
@Api(tags = "Admin 用户模块")
public class AdminUserController {

    @Autowired
    private AdminUserService userService;

    @PostMapping("/password/update")
    @ApiOperation(value = "修改用户密码")
    @ApiOperationLog(description = "修改用户密码")
    public Response updatePassword(@RequestBody @Validated UpdateAdminUserPasswordReqVO updateAdminUserPasswordReqVO) {
        return userService.updatePassword(updateAdminUserPasswordReqVO);
    }
}
