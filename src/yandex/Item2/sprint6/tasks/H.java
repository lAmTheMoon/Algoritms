package yandex.Item2.sprint6.tasks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class H {

    private static List<Color> color;
    private static List<Integer> enter;
    private static List<Integer> out;
    private static int time;

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
                List<Integer> list = map.get(key);
                list.add(value);
            }
            initializeLists(n);
            DFS(1, map);
            fillInfoAndPrint(n);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void fillInfoAndPrint(int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(enter.get(i)).append(" ");
            sb.append(out.get(i)).append("\n");
        }
        System.out.println(sb);
    }

    private static void initializeLists(int numVertices) {
        int size = numVertices + 1;

        enter = new ArrayList<>(size);
        out = new ArrayList<>(size);
        color = new ArrayList<>(size);

        for (int i = 0; i < size; i++) {
            color.add(Color.WHITE);
            enter.add(null);
            out.add(null);
        }
    }

    private static void DFS(int v, Map<Integer, List<Integer>> map) {
        enter.set(v, time);
        time += 1;
        color.set(v, Color.GRAY);
        List<Integer> outgoingEdges = map.get(v);
        Collections.sort(outgoingEdges);

        for (int w : outgoingEdges) {
            if (Color.WHITE == color.get(w)) {
                DFS(w, map);
            }
        }

        out.set(v, time);
        time+=1;
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

