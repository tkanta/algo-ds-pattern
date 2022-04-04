package com.algods.graph;

public class DoublyLinkedList<T> {

	public class Node{
		public T data;
		public Node nextNode;
		public Node PrevNode;
		public T getData() {
			return data;
		}
	}
	
	public Node headNode;
	public Node tailNode;
	public int size;
	
	public DoublyLinkedList() {
		this.headNode = null;
		this.tailNode = null;
	}
	
	public Node getHeadNode() {
		return headNode;
	}
	
	public Node getTailNode() {
		return tailNode;
	}
	
	public int getSize() {
		return size;
	}
	
	public boolean isEmpty() {
		if(headNode == null && tailNode == null) {
			return true;
		}
		return false;
	}
	
	public void insertAtHead(T data) {
		Node newNode = new Node();
		newNode.data = data;
		newNode.nextNode = this.headNode;
		if(headNode != null) {
			headNode.PrevNode = newNode;
		}else {
			tailNode = newNode;
		}
		headNode = newNode;
		size++;
	}
	
	public void insertAtTail(T data) {
		if(isEmpty()) {
			insertAtHead(data);
			return;
		}
		Node newNode = new Node();
		newNode.data = data;
		newNode.nextNode = null;
		newNode.PrevNode = this.tailNode;
		this.tailNode.nextNode = newNode;
		this.tailNode = newNode;
		size++;
	}
	
	public void printList() {
		if(isEmpty()) {
			System.out.println("List is empty");
			return;
		}
		System.out.println();
		Node temp = headNode;
		System.out.print("List: null <- ");
		
		while(temp.nextNode != null) {
			System.out.print(temp.data.toString() + " <-> ");
			temp = temp.nextNode;
		}
		System.out.print(temp.data.toString() + " -> null");
	}
	
	public void printListReverse() {
		if(isEmpty()) {
			System.out.println("List is empty");
			return;
		}
		System.out.println();
		Node temp = tailNode;
		System.out.print("List: null <- ");
		
		while(temp.PrevNode != null) {
			System.out.print(temp.data.toString() + " <-> ");
			temp = temp.PrevNode;
		}
		
		System.out.print(temp.data.toString() + " -> null");
	}
	
	public void deleteAtHead() {
		if(isEmpty()) {
			return;
		}
		
		headNode = headNode.nextNode;
		if(headNode == null) {
			tailNode = null;
		}else {
			headNode.PrevNode = null;
		}
		size--;
	}
	
	public void deleteAtTail() {
		if(isEmpty()) {
			return;
		}
		
		tailNode = tailNode.PrevNode;
		if(tailNode == null) {
			headNode = null;
		}else {
			tailNode.nextNode = null;
		}
		
		size--;
	}
	
	public static void main(String[] args) {
		DoublyLinkedList<Integer> dLL = new DoublyLinkedList<>();
		dLL.insertAtHead(2);
		dLL.insertAtHead(3);
		dLL.insertAtHead(5);
		dLL.insertAtTail(7);
		dLL.printList();
		dLL.printListReverse();
	}
}
