package yandex.Item2.sprint4.tasks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A {

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            long base = Long.parseLong(reader.readLine());
            long mod = Long.parseLong(reader.readLine());
            String array = reader.readLine();

            System.out.println(getResult(array, base, mod));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static long getResult(String array, long base, long mod) {
        long hash = 0L;

        for (int i = 0; i < array.length(); i++) {
            hash = (hash * base + array.charAt(i)) % mod;
        }
        return hash;
    }
}
