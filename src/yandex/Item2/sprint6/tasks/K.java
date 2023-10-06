package yandex.Item2.sprint6.tasks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class K {

    private static final StringBuilder sb = new StringBuilder();

    private static boolean[] visited;
    private static int[] previous;
    private static int[] dist;

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String[] input = reader.readLine().split(" ");
            int n = Integer.parseInt(input[0]);
            int m = Integer.parseInt(input[1]);
            Graph graph = new Graph(n);
            for (int i = 1; i <= m; i++) {
                input = reader.readLine().split(" ");
                int left = Integer.parseInt(input[0]);
                int right = Integer.parseInt(input[1]);
                int v = Integer.parseInt(input[2]);
                graph.addEdge(left, right, v);
            }
            for (int i = 1; i <= n; i++) {
                initializeArrays(n);
                dijkstra(graph, i);
                fillInfo();
            }
            System.out.println(sb);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void fillInfo() {
        for (int i = 1; i < dist.length; i++) {
            int n = dist[i];
            if (n == Integer.MAX_VALUE) {
                n = -1;
            }
            sb.append(n).append(" ");
        }
        sb.append("\n");
    }

    private static void initializeArrays(int numVertices) {
        int size = numVertices + 1;
        visited = new boolean[size];
        previous = new int[size];
        dist = new int[size];
    }

    private static void dijkstra(Graph graph, int s) {
        for (int i = 1; i < graph.V; i++) {
            dist[i] = Integer.MAX_VALUE;
        }

        dist[s] = 0;

        while (true) {
            Integer u = getMinDistNotVisitedVertex(graph);

            if (u == null || dist[u] == Integer.MAX_VALUE) {

                break;
            }

            visited[u] = true;

            List<Graph.Pair> neighbours = graph.adj.get(u);

            for (Graph.Pair pair : neighbours) {
                int v = pair.right;
                relax(u, v, graph);
            }
        }
    }

    private static void relax(int u, int v, Graph graph) {
        if (dist[v] > dist[u] + weight(u, v, graph)) {
            dist[v] = dist[u] + weight(u, v, graph);
            previous[v] = u;
        }
    }

    private static int weight(int u, int v, Graph graph) {
        List<Graph.Pair> pairs = graph.adj.get(u);
        for (Graph.Pair p : pairs) {
            if (p.right == v) {
                return p.value;
            }
        }
        return 0;
    }

    private static Integer getMinDistNotVisitedVertex(Graph graph) {

        int currentMinimum = Integer.MAX_VALUE;
        Integer currentMinimumVertex = null;

        for (int v : graph.vertices) {
            if (!visited[v] && dist[v] < currentMinimum) {
                currentMinimum = dist[v];
                currentMinimumVertex = v;
            }
        }
        return currentMinimumVertex;
    }

    static class Graph {
        private final int V;
        private final Set<Integer> vertices;
        private final List<List<Pair>> adj;

        Graph(int V) {
            int size = V + 1;
            this.V = size;
            adj = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                adj.add(new ArrayList<>());
            }
            vertices = new HashSet<>();
        }

        void addEdge(int l, int r, int v) {
            vertices.add(l);
            vertices.add(r);
            adj.get(r).add(new Pair(l, v));
            adj.get(l).add(new Pair(r, v));
        }

        static class Pair {
            int right;
            int value;

            public Pair(int right, int value) {
                this.right = right;
                this.value = value;
            }
        }
    }
}
