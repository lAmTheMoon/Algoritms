package yandex.Item2.sprint1.tasks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class L {

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            List<Character> firstString = parseStringToCharacters(reader.readLine());
            List<Character> secondString = parseStringToCharacters(reader.readLine());
            Collections.sort(firstString);
            System.out.println(getExcessLetter(firstString, secondString));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static char getExcessLetter(List<Character> firstString, List<Character> secondString) {
        char needToFind = 0;
        int left = 0;
        for (char c : secondString) {
            int right = firstString.size() - 1;
            needToFind = c;
            if (firstString.isEmpty() || getCharIndex(firstString, needToFind, left, right) == -1) break;
        }
        return needToFind;
    }

    private static int getCharIndex(List<Character> firstString, char needToFind, int left, int right) {
        int mediana;
        while (left <= right) {
            mediana = left + ((right - left) / 2);
            if (firstString.get(mediana) == needToFind) {
                firstString.remove(mediana);
                return mediana;
            }
            if (firstString.get(mediana) < needToFind) {
                left = mediana + 1;
            } else {
                right = mediana - 1;
            }
        }

        return -1;
    }

    static List<Character> parseStringToCharacters(String string) {
        List<Character> characters = new ArrayList<>();
        for (int i = 0; i < string.length(); i++) {
            characters.add(string.charAt(i));
        }
        return characters;
    }
}
