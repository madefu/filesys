package com.mdf.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.springframework.core.annotation.Order;

import lombok.extern.slf4j.Slf4j;

/**
 * Servlet Filter implementation class LoginFilter
 */
@WebFilter(urlPatterns = "/*")
@Order(value = 1)
@Slf4j
public class LoginFilter implements Filter {



	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest) request;
		Cookie c = null;
		for(Cookie ck: req.getCookies()) {
			if("CC".equals(ck.getName())) {
				c=ck;
				break;
			}
		}
		log.info("find cookie CC: {}",c==null?"COOKIE-NULL":c.getValue());
		chain.doFilter(request, response);
	}


}
