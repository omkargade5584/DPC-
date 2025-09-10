import java.util.*;

public class Day27 {

    public static int shortestPath(int V, List<int[]> edges, int start, int end) {
        // Build adjacency list
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u); // undirected
        }

        // Distance array
        int[] dist = new int[V];
        Arrays.fill(dist, -1);
        dist[start] = 0;

        // BFS queue
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);

        while (!queue.isEmpty()) {
            int node = queue.poll();

            for (int neighbor : adj.get(node)) {
                if (dist[neighbor] == -1) { // not visited
                    dist[neighbor] = dist[node] + 1;
                    queue.add(neighbor);
                }
            }
        }

        return dist[end]; // -1 if unreachable
    }

    // ✅ Driver code
    public static void main(String[] args) {
        List<int[]> edges1 = Arrays.asList(
                new int[]{0, 1}, new int[]{0, 2}, new int[]{1, 3}, new int[]{2, 3}, new int[]{3, 4}
        );
        System.out.println(shortestPath(5, edges1, 0, 4)); // 3

        List<int[]> edges2 = Arrays.asList(
                new int[]{0, 1}, new int[]{1, 2}
        );
        System.out.println(shortestPath(3, edges2, 0, 2)); // 2

        List<int[]> edges3 = Arrays.asList(
                new int[]{0, 1}, new int[]{1, 2}
        );
        System.out.println(shortestPath(4, edges3, 2, 3)); // -1

        // Edge case: start = end
        List<int[]> edges4 = new ArrayList<>();
        System.out.println(shortestPath(1, edges4, 0, 0)); // 0
    }
}
