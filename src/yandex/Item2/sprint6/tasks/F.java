package yandex.Item2.sprint6.tasks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class F {

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String[] input = reader.readLine().split(" ");
            int n = Integer.parseInt(input[0]);
            int m = Integer.parseInt(input[1]);

            int size = n + 1;
            List<List<Integer>> edges = new ArrayList<>(size);
            int[] distance = new int[size];

            for (int i = 0; i < size; i++) {
                edges.add(new ArrayList<>());
            }

            for (int i = 0; i < m; i++) {
                input = reader.readLine().split(" ");
                int u = Integer.parseInt(input[0]);
                int v = Integer.parseInt(input[1]);
                edges.get(u).add(v);
                edges.get(v).add(u);
            }

            input = reader.readLine().split(" ");
            int startN = Integer.parseInt(input[0]);
            int lastN = Integer.parseInt(input[1]);

            if (startN != lastN) {

                List<Integer> planned = new ArrayList<>(size * 3);
                distance[startN] = 1;
                planned.add(startN);

                OUT:
                for (int i = 0; i < planned.size(); i++) {
                    int u = planned.get(i);
                    int dis = distance[u] + 1;
                    List<Integer> outgoingEdges = edges.get(u);
                    for (int v : outgoingEdges) {
                        if (distance[v] == 0) {
                            distance[v] = dis;
                            if (v == lastN) {
                                break OUT;
                            }
                            planned.add(v);
                        }
                    }
                }

                System.out.println(distance[lastN] - 1);
            } else {
                System.out.println(0);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}