package yandex.Item2.sprint7.tasks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class F {

    private static int[] dp;
    private static final int mod = (int) (Math.pow(10, 9) + 7);

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String[] input = reader.readLine().split(" ");
            int n = Integer.parseInt(input[0]);
            int k = Integer.parseInt(input[1]);

            dp = new int[n];
            calculateAndPrintResult(n, k);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void calculateAndPrintResult(int n, int k) {
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < Math.min(k + 1, i + 1); j++) {
                if (i - j >= 0) {
                    dp[i] = (dp[i] + dp[i - j]) % mod;
                }
            }
        }
        System.out.println(dp[n - 1]);
    }
}
