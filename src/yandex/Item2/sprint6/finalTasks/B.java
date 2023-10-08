package yandex.Item2.sprint6.finalTasks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * ID посылки 92801687
 * Чтобы понять является ли карта оптимальной нужно сперва построить список смежности графа.
 * Тк у нас два типа дороги, мы будем считать, что граф ориентированный.
 * Если дорога принадлежит к типу В, то ребро = (i, j), если к типу R, то ребро имеет обратное направление, где
 * i - номер строки при вводе, а j - индекс типа дороги связующий города.
 * Далее применяем алгоритм обхода в ширину с поиском цикла тк от одного города до другого
 * можно проехать только по маршруту, состоящему исключительно из дорог типа R или только из дорог типа B.
 * Временная сложность - O(V+E), где E - количество рёбер в графе, а V - количество вершин
 * Пространственная сложность - O(V*E)
 */

public class B {

    private static final String B_ROAD = "B";
    private static final String R_ROAD = "R";
    private static final int WHITE = 0;
    private static final int GRAY = 1;
    private static final int BLACK = 2;
    public static final int SHIFT = 1;
    private static int[] color;

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(reader.readLine());
            color = new int[n];

            List<List<Integer>> edges = new ArrayList<>(n);
            for (int i = 0; i < n; i++) {
                edges.add(new ArrayList<>());
            }
            for (int i = 0; i < n - 1; i++) {
                String[] input = reader.readLine().split("");
                for (int j = 0; j < input.length; j++) {
                    String roadType = input[j];
                    if (R_ROAD.equals(roadType)) {
                        edges.get(i + j + SHIFT).add(i);
                    } else if (B_ROAD.equals(roadType)) {
                        edges.get(i).add(i + j + SHIFT);
                    } else {
                        throw new IllegalArgumentException("A non-existent road type");
                    }
                }
            }

            System.out.println(isOptimalGraph(n, edges) ? "NO" : "YES");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean isOptimalGraph(int n, List<List<Integer>> edges) {
        boolean isOptimalRoad = false;
        for (int i = 0; i < n; i++) {
            isOptimalRoad = BFS(i, edges);
            if (isOptimalRoad) {
                break;
            }
        }
        return isOptimalRoad;
    }

    private static boolean BFS(int s, List<List<Integer>> edges) {
        Deque<Integer> planned = new ArrayDeque<>(edges.size());
        planned.push(s);

        while (!planned.isEmpty()) {
            int u = planned.pop();
            if (color[u] == WHITE) {
                color[u] = GRAY;
                planned.push(u);
                List<Integer> outgoingEdges = edges.get(u);
                for (int v : outgoingEdges) {
                    if (color[v] == WHITE) {
                        planned.push(v);
                    } else if (color[v] == GRAY) {
                        return true;
                    }
                }
            } else if (color[u] == GRAY) {
                color[u] = BLACK;
            }
        }
        return false;
    }
}