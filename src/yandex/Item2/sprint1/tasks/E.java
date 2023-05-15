package yandex.Item2.sprint1.tasks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class E {

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int lengthArray = Integer.parseInt(reader.readLine());
            String[] words = reader.readLine().trim().split(" ");
            String longestWord = getLongestWordIndex(words);
            System.out.println(longestWord + "\n" + longestWord.length());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String getLongestWordIndex(String[] words) {
        int indexLongestWord = 0;
        for (int i = 1; i < words.length; i++) {
            if (words[i].length() > words[indexLongestWord].length()) {
                indexLongestWord = i;
            }
        }
        return words[indexLongestWord];
    }
}
