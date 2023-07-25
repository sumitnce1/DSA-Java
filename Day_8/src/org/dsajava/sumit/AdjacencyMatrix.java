package org.dsajava.sumit;

import java.util.Scanner;
import java.util.Stack;

public class AdjacencyMatrix {
    private int[][] adjacenMatrix;
    private int numVertices;

    public AdjacencyMatrix(int numVertices) {
        this.numVertices = numVertices;
        this.adjacenMatrix = new int[numVertices][numVertices];
    }

    public void addEdge(int src, int dest) {
        adjacenMatrix[src][dest] = 1;
        adjacenMatrix[dest][src] = 1;
    }

    public void DFS(int startVertex) {
        boolean[] visited = new boolean[numVertices];
        Stack<Integer> stack = new Stack<>();

        stack.push(startVertex);
        visited[startVertex] = true;

        while (!stack.isEmpty()) {
            int currentVertex = stack.pop();
            System.out.println("Current vertex: " + currentVertex);

            for (int i = 0; i < numVertices; i++) {
                if (adjacenMatrix[currentVertex][i] == 1 && !visited[i]) {
                    stack.push(i);
                    visited[i] = true;
                }
            }
        }
    }

    public static void main(String[] args) {
        int numVertices = 8;
        AdjacencyMatrix am = new AdjacencyMatrix(numVertices);
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
		am.addEdge(6, 1);
		am.addEdge(6, 5);
		am.addEdge(6, 7);

		while (true) {
			System.out.println("Enter the starting vertex between 0 to 7: ");
			Scanner sc = new Scanner(System.in);
			int ver = sc.nextInt();
			System.out.println("DFS from starting vertex " + ver + " : ");
			am.DFS(ver);

			System.out.println("Do you want to exit: Y/N");
			String choice = sc.next();
			if (choice.toLowerCase().equals("y")) {
				break;
				
			}
		}

	}

}