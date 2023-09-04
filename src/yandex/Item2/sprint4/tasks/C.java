package yandex.Item2.sprint4.tasks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class C {

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            long base = Long.parseLong(reader.readLine());
            long mod = Long.parseLong(reader.readLine());
            String string = reader.readLine();
            int length = Integer.parseInt(reader.readLine());

            long[] prefixHashes = getPrefixHashes(string, mod, base);
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < length; i++) {
                String[] str = reader.readLine().split(" ");
                sb.append(getResult(prefixHashes, str, mod, base)).append("\n");
            }

            System.out.println(sb);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static long[] getPrefixHashes(String string, long mod, long base) {
        long[] hashes = new long[string.length() + 1];
        hashes[1] = string.charAt(0);

        for (int i = 2; i <= string.length(); i++) {
            hashes[i] = (hashes[i - 1] * base + string.charAt(i - 1)) % mod;
        }
        return hashes;
    }

    private static BigInteger getResult(long[] hashes, String[] chars, long mod, long base) {
        int l = Integer.parseInt(chars[0]);
        int r = Integer.parseInt(chars[1]);

        return (BigInteger.valueOf(hashes[r] % mod).subtract(BigInteger.valueOf(hashes[l - 1])
                .multiply(BigInteger.valueOf(modulo(base, r - l + 1, mod)))))
                .mod(BigInteger.valueOf(mod));
    }

    private static long modulo(long base, long p, long mod) {
        long m = base % mod;
        long t = 1;
        while (p > 0) {
            if (p % 2 == 1) {
                t = (t * m) % mod;
            }
            m = (m * m) % mod;
            p /= 2;
        }
        return t % mod;
    }
}