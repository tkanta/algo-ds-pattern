package com.algods.graph;

public class Test {

	public static void main(String[] args) {
		Queue<Integer> que = new Queue<>(2);
		que.enqueue(23);
		que.enqueue(34);
		que.enqueue(64);
		
		System.out.println(que.dequeue());
		System.out.println(que.dequeue());
		
	}
}
