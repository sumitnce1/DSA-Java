package org.dsajava.sumit;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BFS {

	private int[][]adjacencyMatrix;
	private int numVertices;
	
	
	public BFS(int numVertices) {
		this.adjacencyMatrix = new int[numVertices][numVertices];
		this.numVertices = numVertices;
	}

	public void addEdge(int src,  int dest) {
		adjacencyMatrix[src][dest]=1;
		adjacencyMatrix[src][dest]=1;
		//adjacencyMatrix[dest][src]=1;
	}

	public void BFS(int startVertex) {
		boolean visited[]=new boolean[numVertices];
		Queue<Integer>queue=new LinkedList<>();
		
		queue.offer(startVertex);		//enqueue from rear
		visited[startVertex]=true;
		
		while(!queue.isEmpty()) {
			int currentVertex = queue.poll(); //dequeue from front
			System.out.println("Current Vertex: " + currentVertex);
			
			for(int i=0; i<numVertices; i++) {
				if(adjacencyMatrix[currentVertex][i]==1&&!visited[i]) {
					queue.offer(i);
					visited[i]=true;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		int numVertices = 8;
		BFS am = new BFS(numVertices);
		am.addEdge(0, 4);
		am.addEdge(0, 7);
		am.addEdge(0, 5);
		am.addEdge(1, 3);
		am.addEdge(1, 7);
		am.addEdge(1, 5);
		am.addEdge(2, 4);
		am.addEdge(2, 7);
		am.addEdge(3, 4);
		am.addEdge(3, 7);
		am.addEdge(4, 1);
		am.addEdge(4, 6);
		am.addEdge(5, 2);
		am.addEdge(5, 3);
		am.addEdge(5, 7);

		while (true) {
			System.out.println("Enter the starting vertex between 0 to "+(numVertices-1)+":");
			Scanner sc = new Scanner(System.in);
			int ver = sc.nextInt();
			System.out.println("DFS from starting vertex " + ver + " : ");
			am.BFS(ver);

			System.out.println("Do you want to exit: Y/N");
			String choice = sc.next();
			if (choice.toLowerCase().equals("y")) {
				break;
				
			}
		}

	}

	
}