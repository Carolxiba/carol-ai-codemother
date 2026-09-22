package com.carol.carolaicodemother.controller;

import com.carol.carolaicodemother.common.BaseResponse;
import com.carol.carolaicodemother.common.ResultUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/health")
public class HealthController {
    @GetMapping("/")
    public BaseResponse<String> healthCheck(){
        return ResultUtils.success("ok");
    }
}
