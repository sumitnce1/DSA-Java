package com.dsajava.sumit0016;

import java.util.*;

/*B. Maps with Delhi, Mumbai, Chennai, Kolkata connection and finding 
the shortest and fastest path from Delhi to all the other places.*/
class ShortestAndFastestPath {
	private static class Edge {
		String destination;
		int distance;
		int time;

		public Edge(String destination, int distance, int time) {
			this.destination = destination;
			this.distance = distance;
			this.time = time;
		}
	}

	private static Map<String, Map<String, Edge>> graph = new HashMap<>();

	public static void main(String[] args) {
		// Step 1: Create the Graph
		createGraph();

		// Step 2: Dijkstra's Algorithm for Shortest Path
		Map<String, Integer> shortestDistances = dijkstraShortest("Delhi");

		// Step 3: Modified Dijkstra's Algorithm for Fastest Path
		Map<String, Integer> fastestTimes = dijkstraFastest("Delhi");

		// Step 4: Display the Results
		displayResults(shortestDistances, fastestTimes);
	}

	private static void createGraph() {
		addEdge("Delhi", "Mumbai", 2170, 40);
		addEdge("Delhi", "Chennai", 1400, 25);
		addEdge("Delhi", "Kolkata", 1650, 30);
		addEdge("Mumbai", "Chennai", 1660, 27);
		addEdge("Chennai", "Kolkata", 1340, 24);
		addEdge("Kolkata", "Mumbai", 1400, 22);
	}

	private static void addEdge(String source, String destination, int distance, int time) {
		graph.computeIfAbsent(source, k -> new HashMap<>()).put(destination, new Edge(destination, distance, time));
		graph.computeIfAbsent(destination, k -> new HashMap<>()).put(source, new Edge(source, distance, time));
	}

	private static Map<String, Integer> dijkstraShortest(String source) {
		Map<String, Integer> distances = new HashMap<>();
		PriorityQueue<Edge> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(e -> e.distance));
		Set<String> visited = new HashSet<>();

		for (String city : graph.keySet()) {
			distances.put(city, Integer.MAX_VALUE);
		}

		distances.put(source, 0);
		priorityQueue.add(new Edge(source, 0, 0));

		while (!priorityQueue.isEmpty()) {
			Edge current = priorityQueue.poll();

			if (visited.contains(current.destination)) {
				continue;
			}

			visited.add(current.destination);

			for (Edge neighbor : graph.get(current.destination).values()) {
				int totalDistance = distances.get(current.destination) + neighbor.distance;
				if (totalDistance < distances.get(neighbor.destination)) {
					distances.put(neighbor.destination, totalDistance);
					priorityQueue.add(new Edge(neighbor.destination, totalDistance, 0));
				}
			}
		}

		return distances;
	}

	private static Map<String, Integer> dijkstraFastest(String source) {
		Map<String, Integer> times = new HashMap<>();
		PriorityQueue<Edge> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(e -> e.time));
		Set<String> visited = new HashSet<>();

		for (String city : graph.keySet()) {
			times.put(city, Integer.MAX_VALUE);
		}

		times.put(source, 0);
		priorityQueue.add(new Edge(source, 0, 0));

		while (!priorityQueue.isEmpty()) {
			Edge current = priorityQueue.poll();

			if (visited.contains(current.destination)) {
				continue;
			}

			visited.add(current.destination);

			for (Edge neighbor : graph.get(current.destination).values()) {
				int totalTime = times.get(current.destination) + neighbor.time;
				if (totalTime < times.get(neighbor.destination)) {
					times.put(neighbor.destination, totalTime);
					priorityQueue.add(new Edge(neighbor.destination, 0, totalTime));
				}
			}
		}

		return times;
	}

	private static void displayResults(Map<String, Integer> distances, Map<String, Integer> times) {
		System.out.println("Shortest Paths from Delhi:");
		for (String city : distances.keySet()) {
			System.out.println("To " + city + ": Distance = " + distances.get(city) + " km");
		}

		System.out.println("\nFastest Paths from Delhi:");
		for (String city : times.keySet()) {
			System.out.println("To " + city + ": Time = " + times.get(city) + " hours");
		}
	}
}
