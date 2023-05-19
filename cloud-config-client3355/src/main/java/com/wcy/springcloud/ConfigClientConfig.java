package com.wcy.springcloud;

import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "configClient")
@RefreshScope
public class ConfigClientConfig {
}
