package com.mdf.controller;

import java.util.Calendar;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mdf.annos.Aops;
import com.mdf.limiter.AvgTokenLimiter;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/")
@Slf4j
public class HelloController {

	@GetMapping("mono")
	public Mono<String> mono() {
		return Mono.just("hello mono");
	}

	@GetMapping("mono2")
	public Mono<Object> mono2() {
		return Mono.create(callback -> {
			log.info("create mono");
			callback.success("heloo mono2");
		}).doOnSubscribe(subscription -> {
			log.info("{}", subscription);
		}).doOnNext(onSubscriberReceive -> {
			log.info("{}", onSubscriberReceive);
		});
	}

	@GetMapping("flux")
	public Flux<Object> flux(){
		return Flux.just("hallo","1","2","3");
	}
	
	private static AtomicLong count = new AtomicLong(0l);
	@Autowired
	private AvgTokenLimiter lmt ;
//	private static  
	@GetMapping("call")
	@Aops(name="API",limit=1000)
	public String call() {
		//限流器
		
		Calendar c = Calendar.getInstance();
		return count.incrementAndGet()+"---"+c.get(Calendar.SECOND);
	}
	
	@Autowired
	@GetMapping("setcookie")
	public String setCookie() {
		
		return "200";
	}
	
}
