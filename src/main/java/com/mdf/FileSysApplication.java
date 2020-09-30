package com.mdf;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.IntPredicate;
import java.util.function.Predicate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FileSysApplication {

	public static void main(String[] args) {
		
	
		
		SpringApplication.run(FileSysApplication.class, args);
	}

	private static void doExec() {
		List<Integer> list = Arrays.asList(1,2,3,4,5);
		System.out.println(
				exec(list,new IntPredicate() {
					public boolean test(int i) {
						return i % 2 == 0;
					}
				})
				);
	}

	private static List<Integer> exec(List<Integer> list, IntPredicate predicate) {
		List<Integer> list2 = new ArrayList<>();
		for(Integer i : list) {
			if(predicate.test(i)) {
				list2.add(i);
			}
		}
		return list2;
	}
}
