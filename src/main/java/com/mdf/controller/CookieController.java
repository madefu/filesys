package com.mdf.controller;

import java.time.LocalDateTime;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

/**
 * 测试samesite携带cookie
 * @author madefu
 *
 */

@Controller
@RequestMapping("/cookie")
@Slf4j
public class CookieController {

	private static final String COOKIE_NAME="cock";
	
	@GetMapping("/set")
	public Mono<String> mono(HttpServletRequest req, HttpServletResponse  rep) {
		
		return Mono.just("hello mono");
	}
	
	@GetMapping("/page/m1")
    public String index(Model model,HttpServletRequest req, HttpServletResponse  rep) {
        model.addAttribute("now", LocalDateTime.now());
        setCookie(req, rep);
        return "m1";
    }
	
	@RequestMapping("/get")
	@ResponseBody
	public String getCookie(HttpServletRequest req, HttpServletResponse  rep) {
		Cookie[] cocks = req.getCookies();
		for(Cookie cock : cocks) {
			if(cock.getName().indexOf(COOKIE_NAME)>-1) {
				return cock.getValue();
			}
		}
		return "";
	}
	
	private boolean setCookie(HttpServletRequest req, HttpServletResponse  rep) {
		String serverName = req.getServerName();
		log.info("当前域名：{}",serverName);
		
		Cookie cookie = new Cookie(COOKIE_NAME,"111");
		cookie.setHttpOnly(true);
		cookie.setMaxAge(7 * 24 * 60 * 60);//7days
		/**
			问题就是tomcat版本问题，因为在tomcat8.5以后对cookie的处理变了！！！！
			在tomcat8.5之前，domain定义时是 需要 在域名之前加一个“.”（加一个点，就像如上代码）
			而在8.5之后，是不能加点的，就是将".xxxx.com" 换成"xxx.com"（此为设置一级域名）
		 */
		if(serverName.indexOf(".m1.com")>-1) {
			cookie.setDomain("m1.com");//setDomain(“.xxx.xx”),这个方法必须以“.”开头。
		}else if(serverName.indexOf(".m2.com")>-1) {
			cookie.setDomain("m2.com");
		}else {
			return false;
		}
		cookie.setPath("/");
		rep.addCookie(cookie);
		return true;
	}

}
