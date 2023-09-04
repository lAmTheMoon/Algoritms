package yandex.Item2.sprint4.tasks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class H {

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String first = getStringDictionary(reader.readLine());
            String second = getStringDictionary(reader.readLine());

            System.out.println(first.compareTo(second) == 0 ? "YES" : "NO");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String getStringDictionary(String chars) throws IOException {
        Map<Character, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < chars.length(); i++) {
            map.merge(chars.charAt(i), i, Integer::sum);
        }
        return map.values().toString();
    }
}
