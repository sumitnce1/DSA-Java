package org.dsajava.sumit;

public class AdjacencyMatrix {
	private int [][] adjacenMatrix;
	private int numVertices;
	
	public AdjacencyMatrix(int [][] adjacenMatrix, int numVertices) {
		this.adjacenMatrix = new int[numVertices][numVertices];
		this.numVertices = numVertices;
	}
	
	public void addEdge(int src, int dest) {
		adjacenMatrix[src][dest] =1;
		adjacenMatrix[dest][src]= 1;
	}
}