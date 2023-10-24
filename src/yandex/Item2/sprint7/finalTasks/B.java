package yandex.Item2.sprint7.finalTasks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * ID посылки 94484785
 *
 * Чтобы проверить можно ли разделить множество на равную сумму частей сначала мы проверяем кратность их суммы,
 * находим частное суммы эл-ов на количество частей - partSum, если partSum не делится без остатка - выводим False
 * Если делится, то создаем массив размером partSum и далее в цикле проходимся по каждому элементу,
 * а во внутреннем цикле проходимся от partSum до значения внешнего цикла
 * Если в последнем элементе массива уже записано true, значит, существует необходимая сумма, равная partSum.
 * Заканчиваем итерацию и выводим True
 * При этом, если partSum равна текущему эл-ту выводим True, значит, значения множества равны, и их количество равно
 * количеству частей
 * Если partSum меньше текущего эл-та выводим False, значит, нельзя разделить множество на равные части
 *
 * Временная сложность - O(N*M), где N - количество эл-ов, а M - частное суммы эл-ов на кол-во частей
 * Пространственная сложность - O(M) - размер используемого массива
 */

public class B {

    private static final String TRUE = "True";
    private static final String FALSE = "False";
    private static final int PART_COUNT = 2;

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            int count = Integer.parseInt(reader.readLine());
            List<Integer> points = getListFromStrings(reader.readLine());

            System.out.println(isCanDividedIntoEqualParts(points) ? TRUE : FALSE);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean isCanDividedIntoEqualParts(List<Integer> points) {
        int sum = getSum(points);
        if (sum % PART_COUNT != 0) {
            return false;
        }

        int partSum = sum / PART_COUNT;
        boolean[] dp = new boolean[partSum + 1];
        dp[0] = true;
        for (Integer point : points) {
            if (partSum == point) {
                return true;
            }
            if (partSum < point) {
                return false;
            }

            for (int j = partSum; j >= point; j--) {
                dp[j] = dp[j - point] || dp[j];
                if (dp[partSum]) {
                    return true;
                }
            }
        }
        return false;
    }

    private static int getSum(List<Integer> points) {
        return points.stream()
                .reduce(0, Integer::sum);
    }

    private static List<Integer> getListFromStrings(String input) throws IOException {
        return Arrays.stream(input.split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
