package com.mdf.stream;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class StreamList {

	@Data
	static class User{
		public User(long id, String name, int age, String love) {
			this.id = id;
			this.name= name;
			this.age= age;
			this.love= love;
		}
		long id;
		String name;
		int age;
		String love;
	}
	
	public static void main(String[] args) {
		User user = new User(1L, "by", 18, "音乐");
        User user1 = new User(2L, "gz", 26, "音乐");
        User user2 = new User(3L, "aby", 19, "旅行");
	}

}
