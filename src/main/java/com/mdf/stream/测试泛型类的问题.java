package com.mdf.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Collectors;

import org.junit.rules.ExpectedException;
import org.springframework.util.Assert;

import com.alibaba.fastjson.JSONObject;

public class 测试泛型类的问题 {

	public static final ExpectedException exception = ExpectedException.none();

	public static String[] fan = {"宫保鸡丁","二哥酸汤菌菇","二哥西红柿鸡蛋","二哥双椒鸡丁面","凉皮","酸菜鱼","干锅","羊汤","尖椒鸡蛋","金针菇小面","牛肉小面"};
	
	public static void main(String[] args) {
		
		int v = new Long(System.nanoTime()).intValue();
		System.out.println(fan[(v<0?-1*v:v)%fan.length]);
		
		
		JSONObject jo = JSONObject.parseObject("{\"key\":[1,2,3,4,5]}");
		List<Integer> arrList = new ArrayList<Integer>();

		/**
		 * 1.7之后增加了 < ? extends T >和< ? super T > (Collection<? extends Integer>)
		 */
//		arrList.addAll(jo.getJSONArray("key"));

		String a = "a,b,c,,,";
		String[] ars = a.split(",");
		Assert.isTrue(3 == ars.length, "3==" + ars.length);

		String[] str1 = new String[] { "chen", "yang", "hao" };

//		
		exception.expect(UnsupportedOperationException.class);
		List list = Arrays.asList(str1);

		Lock lock = new ReentrantLock();
		// ...
		boolean isLocked = lock.tryLock();
		if (isLocked) {
			try {
//		doSomething();
//		doOthers();
				System.out.println("91919");
			} finally {
				lock.unlock();
			}
		}

		String[] departments = new String[] { "iERP", "iERP", "EIBU" };
		// 抛出 IllegalStateException 异常
		Map<Integer, String> map = Arrays.stream(departments).collect(Collectors.toMap(String::hashCode, str -> str));

		/*
		 * List<Pair<String, Double>> pairArrayList = new ArrayList<>(2);
		 * pairArrayList.add(new Pair<>("version1", 8.3)); pairArrayList.add(new
		 * Pair<>("version2", null)); Map<String, Double> map =
		 * pairArrayList.stream().collect( // 抛出 NullPointerException 异常
		 * Collectors.toMap(Pair::getKey, Pair::getValue, (v1, v2) -> v2));
		 */
	}

}
