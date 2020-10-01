package com.mdf.stream;

import java.math.BigDecimal;
import java.util.function.Predicate;

import org.springframework.util.Assert;

public class 货币金额规范浮点数 {

	public static void main(String[] args) {
		float a = 1.0f - 0.9f;
		float b = 0.9f - 0.8f;
		
		
		
		System.out.println(a);
		System.out.println(b);
		Assert.isTrue(a != b,  "a != b");
		Float x = Float.valueOf(a);
		Float y = Float.valueOf(b);
		System.out.println(x);
		System.out.println(y);
		Assert.isTrue(!x.equals(y), "a not equals b");
		if (x.equals(y)) {
		 // 预期进入此代码快，执行其它业务逻辑
		 // 但事实上 equals 的结果为 false
		}
		
		
		BigDecimal m10 = new BigDecimal(1.0f);
		BigDecimal m9 = new BigDecimal(0.9f);
		BigDecimal m8 = new BigDecimal(0.8f);
		
		BigDecimal x1 = m10.subtract(m9);
		BigDecimal x2 = m9.subtract(m8);
		System.out.println(x1);
		System.out.println(x2);
		/**
		 * 如上所示 BigDecimal 的等值比较应使用 compareTo()方法，而不是 equals()方法
		 * 说明：equals()方法会比较值和精度 （1.0 与 1.00 返回结果为 false） 
		 * 而 compareTo()则会忽略精度
		 */
		Assert.isTrue(x1.compareTo(x2)== 0, "true");
		Assert.isTrue(!x1.equals(x2),"false");
	}

}
