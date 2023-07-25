package org.dsajava.sumit;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class PrimsST {
    private int numVertices;
    private List<List<Edge>> adjacencyList;

    public PrimsST(int numVertices) {
        this.numVertices = numVertices;
        adjacencyList = new ArrayList<>(numVertices);
        for (int i = 0; i < numVertices; i++) {
            adjacencyList.add(new ArrayList<>());
        }
    }
    public static class Edge {
        int src;
        int dest;
        int weight;

        public Edge(int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }
    }

    public void addEdge(int src, int dest, int weight) {
        Edge edge = new Edge(src, dest, weight);
        adjacencyList.get(src).add(edge);
        adjacencyList.get(dest).add(edge); // If your graph is undirected, you need to add this line.
    }

    public void primMST() {
        boolean visited[] = new boolean[numVertices];
        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(e -> e.weight));
        int startVertex = 0;
        visited[startVertex] = true;
        addEdgesToPriorityQueue(startVertex, priorityQueue);

        while (!priorityQueue.isEmpty()) {
            Edge minEdge = priorityQueue.remove();
            if (!visited[minEdge.dest]) {
                visited[minEdge.dest] = true;
                System.out.println("Edge: " + minEdge.src + " " + minEdge.dest + ", Weight: " + minEdge.weight);
                addEdgesToPriorityQueue(minEdge.dest, priorityQueue);
            }
        }
    }

    private void addEdgesToPriorityQueue(int startVertex, PriorityQueue<Edge> priorityQueue) {
        for (Edge e : adjacencyList.get(startVertex)) {
            if (!priorityQueue.contains(e)) {
                priorityQueue.offer(e);
            }
        }
    }

    public static void main(String[] args) {
        int numVertices = 7;
        PrimsST graph = new PrimsST(numVertices);
        graph.addEdge(0, 1, 7);
        graph.addEdge(0, 4, 18);
        graph.addEdge(1, 3, 10);
        graph.addEdge(1, 2, 2);
        graph.addEdge(2, 5, 9);
        graph.addEdge(2, 4, 4);
        graph.addEdge(3, 6, 10);
        graph.addEdge(5, 3, 1);

        System.out.println("\nPrim's Alogrithm for Minimum Spanning Tree: ");
        graph.primMST();
    }   
}

