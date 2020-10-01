package com.mdf.current;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;

public class SynchronousQueueQuiz {

	public static void main(String[] args) throws InterruptedException {
		BlockingQueue<Integer> queue = new SynchronousQueue<>();
		System.out.println(queue.offer(1));
		System.out.println(queue.offer(2));
		System.out.println(queue.offer(3));
		System.out.println(queue.take()+"");
		System.out.println(queue.size());
	}

}
