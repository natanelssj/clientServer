package main;
import org.testng.internal.collections.Pair;
import org.w3c.dom.Node;
import java.util.*;
public class Algorithms_sort {

    public static void bfs(Map<Integer, List<Integer>> graph, int start) {
        Set<Integer> visited = new HashSet<>(); // Track visited nodes
        Queue<Integer> queue = new LinkedList<>(); // Queue for BFS traversal

        visited.add(start); // Mark start as visited
        queue.add(start);   // Enqueue start node

        while (!queue.isEmpty()) {
            int current = queue.poll(); // Dequeue current node
            System.out.println("Visited: " + current); // Process node

            for (int neighbor : graph.getOrDefault(current, new ArrayList<>())) {
                if (!visited.contains(neighbor)) { // If neighbor is not visited
                    visited.add(neighbor); // Mark neighbor as visited
                    queue.add(neighbor);   // Enqueue neighbor
                    System.out.println("added: " + neighbor); // Process node

                }
            }
        }
    }

    public static void dfs(Map<Integer, List<Integer>> graph, int start)
    {
        Set<Integer> visited = new HashSet<>(); // Track visited nodes
        Stack<Integer> stack = new Stack<>(); // Queue for BFS traversal
        stack.push(start);
        visited.add(start);
        while (!stack.isEmpty())
        {
            int currentNode =stack.pop();
            System.out.println("Visited: " + currentNode); // Process node
            for(int nighbor:graph.getOrDefault(currentNode,new ArrayList<>()))
            {
                if (!visited.contains(nighbor))
                {
                    visited.add(nighbor);
                    stack.push(nighbor);
                }
            }

        }

    }
    /*public static void dijkstra(Map<Integer, List<int[]>> graph, int start) {
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        Map<Integer, Integer> distances = new HashMap<>();

        // Initialize distances
        for (Integer node : graph.keySet()) {
            distances.put(node, Integer.MAX_VALUE);
        }
        distances.put(start, 0);

        // Add the starting node to the queue
        queue.add(new int[]{start, 0});
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int currentNode = current[0];
            int currentDistance = current[1];
            // Process neighbors
            for (int[] neighbor : graph.getOrDefault(currentNode, Collections.emptyList())) {
                int neighborNode = neighbor[0];
                int edgeWeight = neighbor[1];
                int newDistance = currentDistance + edgeWeight;

                if (newDistance < distances.get(neighborNode)) {
                    distances.put(neighborNode, newDistance);
                    queue.add(new int[]{neighborNode, newDistance});
                }
            }
        }

        // Print the shortest distances
        for (Map.Entry<Integer, Integer> entry : distances.entrySet()) {
            System.out.println("Node " + entry.getKey() + " is at distance " + entry.getValue());
        }
    }*/

}
