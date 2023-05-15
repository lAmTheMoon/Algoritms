package yandex.Item1;

import java.util.Scanner;

public class A {

    private static int getSum(int a, int b) {
        return a + b;
    }

    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int a = scanner.nextInt();
//        int b = scanner.nextInt();
//        System.out.println(getSum(a, b));
//        scanner.close();
//        int[] values = new int[] {1,2,3,4,5,6};
//        int N = values.length;
//        for (int i = 0; i < N; i++) {
//            System.out.println(values[i]);
//        }
        long a = 30 * 24 * 60 * 60;
        long b = 60 * 60;
        long min30 = a*b;

        long b2 = 30 * 60;
        long minWhat = a*b2;

        long a1 = 90 * 24 * 60 * 60;

        System.out.println(a1*b/min30);
    }
}
