package com.wcy.springcloud.controller;

import com.wcy.springcloud.entity.Result;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/configClient")
@RefreshScope
public class ConfigClientController {

    @Value("${server.port}")
    private String serverPort;


    @Value("${config.info}")
    private String configInfo;



    @GetMapping("/configInfo")
    public Result<?> configInfo(){
        return Result.ok("serverPort:"+serverPort+"\t\n\n configInfo:"+configInfo);
    }
}
