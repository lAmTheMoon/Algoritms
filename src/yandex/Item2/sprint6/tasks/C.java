package yandex.Item2.sprint6.tasks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class C {

    private static final StringBuilder sb = new StringBuilder();
    private static final List<Color> color = new ArrayList<>();

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
                List<Integer> listk = map.get(key);
                listk.add(value);
                List<Integer> listv = map.get(value);
                listv.add(key);
            }
            int startN = Integer.parseInt(reader.readLine());
            initializeColor(n);
            DFS(startN, map);
            System.out.println(sb);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void initializeColor(int numVertices) {
        for (int i = 0; i <= numVertices; i++) {
            color.add(Color.WHITE);
        }
    }

    private static void DFS(int v, Map<Integer, List<Integer>> map) {
        color.set(v, Color.GRAY);
        sb.append(v).append(" ");
        List<Integer> outgoingEdges = map.get(v);
        Collections.sort(outgoingEdges);

        for (int w : outgoingEdges) {
            if (Color.WHITE == color.get(w)) {
                DFS(w, map);
            }
        }

        color.set(v, Color.BLACK);
    }

    enum Color {
        WHITE("WHITE"),
        GRAY("GRAY"),
        BLACK("BLACK");

        Color(String title) {
        }
    }
}
