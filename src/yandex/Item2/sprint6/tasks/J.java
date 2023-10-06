package yandex.Item2.sprint6.tasks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class J {

    private static List<Color> color;
    private static final Stack<Integer> stack = new Stack<>();

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String[] input = reader.readLine().split(" ");
            int n = Integer.parseInt(input[0]);
            int m = Integer.parseInt(input[1]);

            Map<Integer, List<Integer>> map = new HashMap<>(n);
            for (int i = 0; i <= n; i++) {
                map.put(i, new ArrayList<>());
            }
            for (int i = 1; i <= m; i++) {
                input = reader.readLine().split(" ");
                int key = Integer.parseInt(input[0]);
                int value = Integer.parseInt(input[1]);
                List<Integer> list = map.get(value);
                list.add(key);
            }
            initializeAll(n);
            for (int i = 1; i <= n; i++) {
                if (Color.WHITE == color.get(i)) {
                    DFS(i, map);
                }
            }
            fillInfoAndPrint();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void fillInfoAndPrint() {
        StringBuilder sb = new StringBuilder();
        stack.forEach(v -> sb.append(v).append(" "));
        System.out.println(sb);
    }

    private static void initializeAll(int numVertices) {
        int size = numVertices + 1;
        color = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            color.add(Color.WHITE);
        }
    }

    private static void DFS(int v, Map<Integer, List<Integer>> map) {
        color.set(v, Color.GRAY);
        List<Integer> outgoingEdges = map.get(v);
        Collections.sort(outgoingEdges);

        for (int w : outgoingEdges) {
            if (Color.WHITE == color.get(w)) {
                DFS(w, map);
            }
        }

        color.set(v, Color.BLACK);
        stack.push(v);
    }

    enum Color {
        WHITE("WHITE"),
        GRAY("GRAY"),
        BLACK("BLACK");

        Color(String title) {
        }
    }
}

