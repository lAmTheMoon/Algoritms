package yandex.Item2.sprint8.tasks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B {

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String name = reader.readLine();
            String nameFromBase = reader.readLine();

            System.out.println(isCanPass(name, nameFromBase));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String isCanPass(String name, String nameFromBase) {
        if (Math.abs(name.length() - nameFromBase.length()) > 1) {
            return "FAIL";
        } else {
            int first = 0;
            int second = 0;
            int wrong = 0;
            while (first < name.length() && second < nameFromBase.length()) {
                if (name.charAt(first) == nameFromBase.charAt(second)) {
                    first++;
                    second++;
                    continue;
                } else {
                    wrong++;
                }
                if (wrong > 1) {
                    return "FAIL";
                }
                int subFirst = name.substring(first + 1).length();
                int subSecond = nameFromBase.substring(second + 1) .length();
                if (subFirst == subSecond) {
                    first++;
                    second++;
                } else if(subFirst < subSecond) {
                    second++;
                } else {
                    first++;
                }
            }
        }
        return "OK";
    }
}
