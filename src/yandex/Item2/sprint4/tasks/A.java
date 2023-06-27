package yandex.Item2.sprint4.tasks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A {

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            long q = Integer.parseInt(reader.readLine());
            long r = Integer.parseInt(reader.readLine());
            char[] chars = reader.readLine().toCharArray();

            System.out.println(getResult(chars, q, r));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static long getResult(char[] chars, long q, long r) {
        if (chars.length == 0) {
            return 0;
        }
        if (chars.length == 1) {
            return Math.floorMod(chars[0], r);
        }
        long result = 0;
        int c = 1;

        for (int i = 0; i < chars.length - 2; i++) {
            long t = (long) Math.pow(q, chars.length - c++);
            System.out.println("CCCC" +t);
            result = Math.floorMod(chars[i] * t, r) + result;
            System.out.println(result);
        }
        result = Math.floorMod(chars[chars.length - 2] * q, r) + result;
        System.out.println(result);
        return Math.floorMod(chars[chars.length - 1], r) + result;
    }
}
