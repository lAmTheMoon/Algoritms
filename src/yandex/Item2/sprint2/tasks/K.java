package yandex.Item2.sprint2.tasks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class K {

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int internCount = Integer.parseInt(reader.readLine());
            int commitCount = 1;
            getCommitCount(internCount, commitCount, 0);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void getCommitCount(int internCount, int commitCount, int commitCountBefore) {
        if (internCount == 0) {
            System.out.println(commitCount);
        } else {
            getCommitCount(internCount - 1, commitCount + commitCountBefore, commitCount);
        }
    }
}
