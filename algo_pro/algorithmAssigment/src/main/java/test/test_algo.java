package test;

import main.Algorithms_sort;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.*;

public class test_algo {

    @Test
    public void testBFS() {
        // Prepare test data
        Map<Integer, List<Integer>> graph = new HashMap<>();
        graph.put(1, Arrays.asList(2, 3));
        graph.put(2, Arrays.asList(1, 4));
        graph.put(3, Arrays.asList(1, 4, 5));
        graph.put(4, Arrays.asList(2, 3, 6));
        graph.put(5, Arrays.asList(3));
        graph.put(6, Arrays.asList(4));

        Algorithms_sort algorithms = new Algorithms_sort();

        // Capture output
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        // Run BFS
        Algorithms_sort.bfs(graph, 1);

        // Parse output to check visited order
        String[] visitedNodes = outContent.toString().split("\n");
        List<String> actualVisited = new ArrayList<>();
        for (String line : visitedNodes) {
            if (line.startsWith("Visited: ")) {
                actualVisited.add(line.replace("Visited: ", "").trim());
            }
        }

        // Expected order of visited nodes
        List<String> expectedVisited = Arrays.asList("1", "2", "3", "4", "5", "6");
        assertEquals(expectedVisited, actualVisited);
        System.setOut(System.out);
    }

    @Test
    public void testDFS() {
        // Prepare test data
        Map<Integer, List<Integer>> graph = new HashMap<>();
        graph.put(1, Arrays.asList(2, 3));
        graph.put(2, Arrays.asList(1, 4));
        graph.put(3, Arrays.asList(1, 4, 5));
        graph.put(4, Arrays.asList(2, 3, 6));
        graph.put(5, List.of(3));
        graph.put(6, List.of(4));

        Algorithms_sort algorithms = new Algorithms_sort();

        // Capture output
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        // Run DFS
        Algorithms_sort.dfs(graph, 1);

        // Parse output to check visited order
        String[] visitedNodes = outContent.toString().split("\n");
        List<String> actualVisited = new ArrayList<>();
        for (String line : visitedNodes) {
            if (line.startsWith("Visited: ")) {
                actualVisited.add(line.replace("Visited: ", "").trim());
            }
        }

        // Expected order of visited nodes (update based on stack implementation)
        List<String> expectedVisited = Arrays.asList("1", "3", "5", "4", "6", "2");

        // Assert visited order matches expected
        assertEquals(expectedVisited, actualVisited);

        // Reset output stream
        System.setOut(System.out);
    }

}
