package yandex.Item1;

import java.util.Collections;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class E {

    // Если ответ существует, верните список из двух элементов
    // Если нет - то верните пустой список 
    private static List<Integer> twoSum(List<Integer> arr, int targetSum) {
        List<Integer> nums = new ArrayList<>();
        Collections.sort(arr);
        int sum = 0;
        int leftIndex = 0;
        int rightIndex = arr.size() - 1;
        while (leftIndex < rightIndex){
            sum = arr.get(leftIndex) + arr.get(rightIndex);
           // System.out.println(leftIndex + " " + rightIndex + " " + sum + " " + leftNum + " " + rightNum);
            if (sum == targetSum) {
                nums.add(arr.get(leftIndex));
                nums.add(arr.get(rightIndex));
                break;
            }

            if (sum > targetSum) {
                rightIndex -= 1;
            } else {
                leftIndex += 1;
            }
        }
        return nums;
    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = readInt(reader);
            List<Integer> arr = readList(reader);
            int targetSum = readInt(reader);
            List<Integer> result = twoSum(arr, targetSum);
            if (result.isEmpty()) {
                System.out.println("None");
            } else {
                System.out.println(result.get(0) + " " + result.get(1));
            }
        }
    }

    private static int readInt(BufferedReader reader) throws IOException {
        return Integer.parseInt(reader.readLine());
    }

    private static List<Integer> readList(BufferedReader reader) throws IOException {
        return Arrays.asList(reader.readLine().split(" "))
                .stream()
                .map(elem -> Integer.parseInt(elem))
                .collect(Collectors.toList());
    }

}