package com.algods.graph;

public class Graph {

	int vertices;
	DoublyLinkedList<Integer>[] adjacencyList;
	
	public Graph(int vertices) {
		this.vertices = vertices;
		this.adjacencyList = new DoublyLinkedList[vertices];
		
		for(int i=0; i<vertices; i++) {
			this.adjacencyList[i] = new DoublyLinkedList<>();
		}
	}
	
	public void addEdge(Integer source, Integer dest) {
		if(source < vertices && dest < vertices) {
			this.adjacencyList[source].insertAtTail(dest);
		}
	}
	
	public void printGraph() {
		System.out.println(">> Adjancency List of Directed Graph <<");
		for(int i=0; i<vertices; i++) {
			
			if(this.adjacencyList[i] != null) {
				System.out.print("|"+i+"| =>");
				
				DoublyLinkedList<Integer>.Node temp = this.adjacencyList[i].getHeadNode();
				
				while(temp != null) {
					System.out.print(" ["+temp.getData()+"] -> ");
					temp = temp.nextNode;
				}
				System.out.println(" null");
			}else {
				System.out.println("|"+i+"| => null");
			}
			
		}
	}
}
