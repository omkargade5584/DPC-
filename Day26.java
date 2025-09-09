import java.util.*;

public class Day26 {

    public static boolean hasCycle(int V, List<int[]> edges) {
        
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u); 
        }

        boolean[] visited = new boolean[V];

       
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (dfs(i, -1, visited, adj)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean dfs(int node, int parent, boolean[] visited, List<List<Integer>> adj) {
        visited[node] = true;

        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                if (dfs(neighbor, node, visited, adj)) return true;
            }
            
            else if (neighbor != parent) {
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        List<int[]> edges1 = Arrays.asList(
                new int[]{0, 1}, new int[]{1, 2}, new int[]{2, 3}, new int[]{3, 4}, new int[]{4, 0}
        );
        System.out.println(hasCycle(5, edges1)); // true

        List<int[]> edges2 = Arrays.asList(
                new int[]{0, 1}, new int[]{1, 2}
        );
        System.out.println(hasCycle(3, edges2)); // false

        List<int[]> edges3 = Arrays.asList(
                new int[]{0, 1}, new int[]{1, 2}, new int[]{2, 0}
        );
        System.out.println(hasCycle(4, edges3)); // true

        List<int[]> edges4 = new ArrayList<>();
        System.out.println(hasCycle(3, edges4)); // false (no edges)
    }
}
