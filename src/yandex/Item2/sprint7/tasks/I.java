package yandex.Item2.sprint7.tasks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class I {

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

            System.out.println(getMaxFieldPointsWithRoad(n, m, points));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String getMaxFieldPointsWithRoad(int n, int m, int[][] points) {
        int[][] dp = new int[n + 1][m + 1];
        int[][] prev = new int[n + 1][m + 1];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 && j == 0) {
                    prev[0][0] = -1;
                    dp[0][0] = points[0][0];
                } else if (i == 0) {
                    dp[0][j] = dp[0][j - 1] + points[0][j];
                    prev[0][j] = 0;
                } else if (j == 0) {
                    dp[i][0] = dp[i - 1][0] + points[i][0];
                    prev[i][0] = 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + points[i][j];
                    if (dp[i - 1][j] > dp[i][j - 1]) {
                        prev[i][j] = 1;
                    } else {
                        prev[i][j] = 0;
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        n--;
        m--;
        int point = dp[n][m];
        while (n > 0 || m > 0) {
            if (prev[n][m] == 1) {
                sb.append("U");
                n--;
            } else {
                sb.append("R");
                m--;
            }
        }

        return "" + point + "\n" + sb.reverse();
    }
}
