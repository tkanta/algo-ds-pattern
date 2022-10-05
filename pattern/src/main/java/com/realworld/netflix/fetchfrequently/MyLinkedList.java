package com.realworld.netflix.fetchfrequently;

public class MyLinkedList{

    public LinkedListNode head;
    public LinkedListNode tail;
    public MyLinkedList(){
        this.head = null;
        this.tail = null;
    }

    public void append(LinkedListNode node){
        node.next = null;
        node.prev = null;
        if(this.head == null){
            this.head = node;
        }
        else{
            this.tail.next = node;
            node.prev = this.tail;
        }
        this.tail = node;
    }

    public void deleteNode(LinkedListNode node){
        if(node.prev != null){
            node.prev.next = node.next;
        }
        else{
            this.head = node.next;
        }
        if(node.next != null){
            node.next.prev = node.prev;
        }
        else{
            this.tail = node.prev;
        }
        node.next = null;
        node.prev = null;
    }
}
