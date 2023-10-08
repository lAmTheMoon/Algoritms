package yandex.Item2.sprint7.tasks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class H {

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String[] input = reader.readLine().split(" ");
            int n = Integer.parseInt(input[0]);
            int m = Integer.parseInt(input[1]);

            int[][] points = new int[n][m];
            for (int i = n - 1; i >= 0; i--) {
                input = reader.readLine().split("");
                for (int j = 0; j < m; j++) {
                    points[i][j] = Integer.parseInt(input[j]);
                }
            }
            System.out.println(getMaxFieldPoints(n, m, points));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int getMaxFieldPoints(int n, int m, int[][] points) {
        int[][] dp = new int[n + 1][m + 1];
        dp[0][0] = points[0][0];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + points[i - 1][j - 1];
            }
        }
        return dp[n][m];
    }
}
