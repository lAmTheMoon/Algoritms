package yandex.Item2.sprint5.tasks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class I {

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            BigInteger n = new BigInteger(reader.readLine());
            System.out.println(getCountBST(n));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static BigInteger getCountBST(BigInteger number) {
        return getFactorial(number.multiply(BigInteger.TWO))
                .divide(getFactorial(number).multiply(getFactorial(number.add(BigInteger.ONE))));
    }

    private static BigInteger getFactorial(BigInteger number) {
        if (number.signum() == 0) {
            return BigInteger.ONE;
        }
        return getFactorial(number.subtract(BigInteger.ONE)).multiply(number);
    }
}
