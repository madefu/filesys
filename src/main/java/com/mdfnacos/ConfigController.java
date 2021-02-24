package com.mdfnacos;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.nacos.api.config.annotation.NacosValue;

@Controller
@RequestMapping("config")
public class ConfigController {

	@NacosValue(value = "${useLocalCache:false}", autoRefreshed = true)
	private boolean userLocalCache;
	
	@RequestMapping(value="/get",method= RequestMethod.GET)
	@ResponseBody
	public boolean get() {
		return userLocalCache;
	}
}
