package com.tediouscat.tediouscatblog.web.controller;

import com.tediouscat.tediouscatblog.common.aspect.ApiOperationLog;
import com.tediouscat.tediouscatblog.common.enums.ResponseCodeEnum;
import com.tediouscat.tediouscatblog.common.exception.BizException;
import com.tediouscat.tediouscatblog.common.utils.Response;
import com.tediouscat.tediouscatblog.web.model.User;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Collectors;


@RestController
@Slf4j
@Api(tags = "首页模块")
public class TestController {

    @PostMapping("/test")
    @ApiOperationLog(description = "测试接口")
    public Response test(@RequestBody @Validated User user) {
        return Response.success();
    }



}
