package yandex.Item2.sprint8.tasks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class D {

    public static final int NEXT_RELEVANT_CHAR = 2;

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int count = Integer.parseInt(reader.readLine());
            List<String> unpackedStrings = new ArrayList<>();
            for (int i = 0; i < count; i++) {
                unpackedStrings.add(getUnpackedString(reader.readLine()).substring);
            }

            System.out.println(getBiggestPrefix(unpackedStrings).length());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String getBiggestPrefix(List<String> strings) {
        if (strings.isEmpty()) {
            return "";
        }

        String prefix = strings.get(0);
        for (int i = 1; i < strings.size(); i++) {
            while (strings.get(i).indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
            }
        }

        return prefix;
    }

    public static Pair getUnpackedString(String packedString) {
        int i = 0;
        return decode(packedString, i);
    }

    private static Pair decode(String s, int i) {
        StringBuilder sb = new StringBuilder();
        int n = s.length();
        while (i < n && s.charAt(i) != ']') {
            if (Character.isDigit(s.charAt(i))) {
                int count = Integer.parseInt(String.valueOf(s.charAt(i)));
                i += NEXT_RELEVANT_CHAR;
                StringBuilder substring = new StringBuilder();
                while (i < n && s.charAt(i) != ']') {
                    if (Character.isDigit(s.charAt(i))) {
                        Pair pair = decode(s, i);
                        substring.append(pair.substring);
                        i = pair.index;
                    } else {
                        substring.append(s.charAt(i++));
                    }
                }

                sb.append(String.valueOf(substring).repeat(Math.max(0, count)));
                i++;
            } else {
                sb.append(s.charAt(i++));
            }
        }
        return new Pair(i, sb.toString());
    }

    static class Pair {

        int index;
        String substring;

        public Pair(int index, String substring) {
            this.index = index;
            this.substring = substring;
        }
    }
}
