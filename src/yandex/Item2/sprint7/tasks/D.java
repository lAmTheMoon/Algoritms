package yandex.Item2.sprint7.tasks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class D {

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(reader.readLine());
            int[] dp = new int[n + 2];
            dp[0] = 0;
            dp[1] = 1;
            for (int i = 2; i < dp.length ; i++) {
                dp[i] = (dp[i - 2] + dp[i - 1]) % (int) (Math.pow(10, 9) + 7);
            }
            System.out.println(dp[n + 1]);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
