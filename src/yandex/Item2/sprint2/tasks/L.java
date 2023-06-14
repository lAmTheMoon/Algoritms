package yandex.Item2.sprint2.tasks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class L {

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String[] internCount = reader.readLine().split(" ");
            BigInteger commitCount = BigInteger.valueOf(1L);

            getCommitCount(Integer.parseInt(internCount[0]),
                           Integer.parseInt(internCount[1]),
                           commitCount, BigInteger.valueOf(0L));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void getCommitCount(int internCount, int numCount,
                                       BigInteger commitCount,
                                       BigInteger commitCountBefore) {
        if (internCount == 0) {
            BigInteger value = BigInteger.valueOf((int) Math.pow(10, numCount));
            System.out.println(commitCount.remainder(value));
        } else {
            getCommitCount(internCount - 1, numCount, commitCount.add(commitCountBefore), commitCount);
        }
    }
}
