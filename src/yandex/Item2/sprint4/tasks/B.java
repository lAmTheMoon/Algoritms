package yandex.Item2.sprint4.tasks;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class B {
    public static void main(String[] args) {
        int base = 1000;
        int mod = 123987123;
        Map<Long, String> map = new HashMap<>();

        while (true) {
            String array = getRandomString();
            long hash = getResult(array, base, mod);

            if (map.containsKey(hash)) {
                System.out.println(array);
                System.out.println(map.get(hash));
                break;
            }
            map.put(hash, array);
        }
    }

    private static String getRandomString() {
        int min = 97;
        int max = 122;
        int length = 20;
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            sb.append((char) (random.nextInt((max - min) + 1) + min));
        }
        return sb.toString();
    }

    private static long getResult(String array, long base, long mod) {
        long hash = 0L;

        for (int i = 0; i < array.length(); i++) {
            hash = (hash * base + array.charAt(i)) % mod;
        }
        return hash;
    }
}
