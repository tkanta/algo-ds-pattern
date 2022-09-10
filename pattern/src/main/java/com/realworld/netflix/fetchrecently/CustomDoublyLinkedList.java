package com.realworld.netflix.fetchrecently;

public class CustomDoublyLinkedList {
	
	public LinkedListNode head;
	public LinkedListNode tail;
	public int size;
	
	//constructor
	public CustomDoublyLinkedList() {
		this.size = 0;
	}
	
	
	//insert at head
	public void insertAtHead(int key, int data) {
		LinkedListNode newNode = new LinkedListNode(key, data);
		
		if(this.head == null) {
			this.head = newNode;
			this.tail = newNode;
		}else {
			newNode.next = this.head;
			this.head.prev = newNode;
			this.head = newNode;
		}
		this.size++;
	}
	
	//insert at tail
	public void insertAtTail(int key, int data) {
		LinkedListNode newNode = new LinkedListNode(key, data);
		
		if(this.tail == null) {
			this.tail = newNode;
			this.head = newNode;
		}else {
			this.tail.next = newNode;
			newNode.prev = this.tail;
			this.tail = newNode;
		}
		this.size++;
	}
	
	//remove node
	public LinkedListNode removeNode(LinkedListNode node) {
		if(node == null) {
			return null;
		}
		
		if(node.next != null) {
			node.next.prev = node.prev;
		}
		
		if(node.prev != null) {
			node.prev.next = node.next;
		}
		
		if(node == this.head) {
			this.head = this.head.next;
		}
		
		if(node == this.tail) {
			this.tail = this.tail.prev;
		}
		this.size--;
		return node;
	}
	
	//remove head
	public LinkedListNode removeHead() {
		return this.removeNode(this.head);
	}
	
	//get tail
	public LinkedListNode getTail() {
		return this.tail;
	}
	//get head
	public LinkedListNode getHead() {
		return this.head;
	}
}
