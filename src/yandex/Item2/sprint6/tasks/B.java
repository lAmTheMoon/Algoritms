package yandex.Item2.sprint6.tasks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B {

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String[] input = reader.readLine().split(" ");
            int n = Integer.parseInt(input[0]);
            int m = Integer.parseInt(input[1]);
            int[][] matrix = new int[n][n];
            for (int i = 0; i < m; i++) {
                input = reader.readLine().split(" ");
                int x = Integer.parseInt(input[0]);
                int y = Integer.parseInt(input[1]);
                matrix[x - 1][y - 1] = 1;
            }
            System.out.println(getEdges(matrix));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static StringBuilder getEdges(int[][] matrix){
        StringBuilder sb = new StringBuilder();
        for (int[] ints : matrix) {
            for (int j = 0; j < matrix.length; j++) {
                sb.append(ints[j]).append(" ");
            }
            sb.append("\n");
        }
        return sb;
    }
}
