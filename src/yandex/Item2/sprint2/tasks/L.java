package yandex.Item2.sprint2.tasks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class L {

    private static int module;

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String[] internCount = reader.readLine().split(" ");
            module = (int) Math.pow(10, Integer.parseInt(internCount[1]));

            getCommitCount(Integer.parseInt(internCount[0]), 1, 0);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void getCommitCount(int internCount,
                                       int commitCount,
                                       int commitCountBefore) {
        if (internCount == 0) {
            System.out.println(commitCount);
        } else {
            getCommitCount(internCount - 1, (commitCount + commitCountBefore) % module, commitCount);
        }
    }
}
