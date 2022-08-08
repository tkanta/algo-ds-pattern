package com.realworld.netflix.topmovies;



class LinkedListNode{
	public int key;
	public int data;
	public LinkedListNode next;
	
	public LinkedListNode(int data) {
		this.data = data;
		this.next = null;
	}
}

public class LinkedList {

	public static LinkedListNode createLinkedList(int[] arr) {
		LinkedListNode head = null;
		LinkedListNode tail = null;
		
		for(int i: arr ) {
			LinkedListNode node = new LinkedListNode(i);
			if(head == null) {
				head = node;
			}else {
				tail.next = node;
			}
			tail = node;
		}
		
		return head;
	}
	
	public static void display(LinkedListNode node) {
		LinkedListNode temp = node;
		
		while(temp != null) {
			System.out.printf("%d", temp.data);
			temp = temp.next;
			if(temp != null) {
				System.out.printf(",");
			}
		}
		System.out.println();
	}
}
