package com.mdf.limiter;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class AvgTokenLimiter {

	private static Map<String,AvgTokenLimiter> mp = new ConcurrentHashMap<>();
	
	private int MAX;
	
	private AvgTokenLimiter get(final int limiter,final String key) {
		AvgTokenLimiter a;
		if(mp.containsKey(key)) {
			a = mp.get(key);
			a.setMAX(limiter);
			
		}else {
			a = new AvgTokenLimiter();
			a.setMAX(limiter);
			mp.put(key, a);
			
		}
		return a;
	}
	
//	private AvgTokenLimiter(final int limiter) {
//		
//	}
	
	public AvgTokenLimiter getInstance(final int limiter,final String key) {
		return get(limiter,key);
	}
	
	public void aquire() {
		
	}
	
	private void feedToken(){
		
	}
}
