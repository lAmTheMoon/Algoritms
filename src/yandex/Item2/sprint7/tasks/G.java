package yandex.Item2.sprint7.tasks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class G {

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int maxSum = Integer.parseInt(reader.readLine());
            int count = Integer.parseInt(reader.readLine());
            int[] numbers = Arrays.stream(reader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            System.out.println(getCombinations(maxSum, count, numbers));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int getCombinations(int maxSum, int count, int[] numbers) {
        int[] dp = new int[maxSum + 1];
        dp[0] = 1;
        for (int number : numbers) {
            for (int j = 0; j < dp.length; j++) {
                if (j >= number) {
                    dp[j] += dp[j - number];
                }
            }
        }

        return dp[maxSum];
    }
}
