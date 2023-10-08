package yandex.Item2.sprint6.finalTasks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

/**
 * ID посылки 92690689
 *
 * По условиям задачи нам нужно найти максимальное отставное дерево
 * Для этого мы создаем список размера n, куда будем складывать ребра отставного дерева
 * Далее нам потребуются два Сета размером n, один предназначен для еще не добавленных вершин, а второй
 * для добавленных вершин.
 * Также потребуется приоритетная очередь с обратным порядком, те на вершине будет максимальный эл-т.
 * В очередь мы будем добавлять ребра для анализа.
 * Далее мы берем первую вершину из графа, получаем список ее ребер и в цикле домтаем из очереди максимальный эл-т,
 * после добавляем его в список максимального отставного дерева, добавляем его вершину в сет добавленных
 * и удаляем его из сета недобавленных.Далее находим список ребер этой вершины, проверяем,
 * что они не обрабатывались и добавляем полученный список в очередь.
 * Если мы бработали все эл-ты, то выводим сумму ребер, если нет - "Oops! I did it again"
 *
 * Временная сложность - O(E*logV), где E - количество рёбер в графе, а V - количество вершин
 * Пространственная сложность - O(V*E)
 */

public class A {

    private static List<Pair> maxSpanningTree;
    private static Set<Integer> added;
    private static Set<Integer> notAdded;
    private static Queue<Pair> edges;

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String[] input = reader.readLine().split(" ");
            int n = Integer.parseInt(input[0]);
            int m = Integer.parseInt(input[1]);

            Graph graph = new Graph(n);
            for (int i = 0; i < m; i++) {
                input = reader.readLine().split(" ");
                int u = Integer.parseInt(input[0]);
                int v = Integer.parseInt(input[1]);
                int w = Integer.parseInt(input[2]);
                graph.addEdge(u, v, w);
            }

            initializeCollections(n);

            Set<Integer> vertices = graph.getVertices();
            if (vertices.iterator().hasNext()) {
                int v = vertices.iterator().next();
                findMST(graph, v);
            }

            printResult();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void initializeCollections(int n) {
        maxSpanningTree = new ArrayList<>(n);
        added = new HashSet<>(n);
        notAdded = new HashSet<>(n);
        edges = new PriorityQueue<>(Comparator.reverseOrder());
    }

    private static void printResult() {
        if (notAdded.isEmpty()) {
            System.out.println(getSpanningTreeEdgesSum());
        } else {
            System.out.println("Oops! I did it again");
        }
    }

    private static Integer getSpanningTreeEdgesSum() {
        return maxSpanningTree.stream()
                .map(edge -> edge.value)
                .reduce(0, Integer::sum);
    }

    private static void findMST(Graph graph, int v) {
        notAdded.addAll(graph.getVertices());
        addVertex(v, graph);

        while (!notAdded.isEmpty() && !edges.isEmpty()) {
            Pair edge = extractMax();
            if (notAdded.contains(edge.end)) {
                maxSpanningTree.add(edge);
                addVertex(edge.end, graph);
            }
        }
    }

    private static Pair extractMax() {
        return edges.poll();
    }

    private static void addVertex(int v, Graph graph) {
        added.add(v);
        notAdded.remove(v);
        edges.addAll(getNotAddedEdges(v, graph));
    }

    private static List<Pair> getNotAddedEdges(int v, Graph graph) {
        return graph.edges.get(v).stream()
                .filter(edge -> notAdded.contains(edge.end))
                .collect(Collectors.toList());
    }

    static class Graph {
        private final Map<Integer, List<Pair>> edges;

        Graph(int verticesSize) {
            edges = new HashMap<>(verticesSize);
            for (int i = 1; i <= verticesSize; i++) {
                edges.put(i, new ArrayList<>());
            }
        }

        void addEdge(int start, int end, int v) {
            edges.get(start).add(new Pair(end, v));
            edges.get(end).add(new Pair(start, v));
        }

        Set<Integer> getVertices() {
            return edges.keySet();
        }
    }

    static class Pair implements Comparable<Pair> {
        int end;
        int value;

        public Pair(int end, int value) {
            this.end = end;
            this.value = value;
        }

        @Override
        public int compareTo(Pair o) {
            return this.value - o.value;
        }
    }
}
