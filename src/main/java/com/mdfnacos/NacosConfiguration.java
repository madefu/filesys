package com.mdfnacos;

import org.springframework.context.annotation.Configuration;

import com.alibaba.nacos.api.annotation.NacosProperties;
import com.alibaba.nacos.spring.context.annotation.config.EnableNacosConfig;
import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySource;

@Configuration
@EnableNacosConfig(globalProperties=@NacosProperties(serverAddr="127.0.0.1:8848"))
@NacosPropertySource(dataId="test1",autoRefreshed=true)
public class NacosConfiguration {

}
