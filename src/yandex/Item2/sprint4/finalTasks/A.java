package yandex.Item2.sprint4.finalTasks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class A {

    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int firstCount = Integer.parseInt(reader.readLine());
            List<List<String>> headers = new ArrayList<>(firstCount);
            for (int i = 1; i <= firstCount; i++) {
                headers.add(getListFromStrings(reader));
            }

            int secondCount = Integer.parseInt(reader.readLine());
            List<List<String>> questions = new ArrayList<>(secondCount);
            for (int i = 0; i < secondCount; i++) {
                questions.add(getListFromStrings(reader));
            }

            Map<String, Set<Integer>> dictionary = fillDictionary(headers);

            questions.forEach(question -> {
                Set<Integer> headersIndex = new HashSet<>();
                for (String str : question) {
                    if (dictionary.containsKey(str)) {
                        headersIndex.addAll(dictionary.get(str));
                    }
                }

                Map<Integer, Integer> result = new HashMap<>();
                headersIndex.forEach(idx -> {
                    Set<Integer> headerIndexes = new HashSet<>();
                    List<String> header = headers.get(idx);
                    for (int i = 0; i < header.size(); i++) {
                        if (question.contains(header.get(i))) {
                            headerIndexes.add(i);
                        }
                    }
                    result.put(idx, headerIndexes.size());
                });

                result.entrySet().stream()
                        .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                        .limit(5)
                        .forEach(k -> sb.append(k.getKey() + 1).append(" "));
                sb.append("\n");
            });

            System.out.println(sb.toString());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static List<String> getListFromStrings(BufferedReader reader) throws IOException {
        return Arrays.stream(reader.readLine().split(" "))
                .collect(Collectors.toList());
    }

    private static Map<String, Set<Integer>> fillDictionary(List<List<String>> headings) {
        Map<String, Set<Integer>> dictionary = new HashMap<>();
        for (int i = 0; i < headings.size(); i++) {
            for (String word : headings.get(i)) {
                if (dictionary.containsKey(word)) {
                    dictionary.get(word).add(i);
                } else {
                    Set<Integer> headersIndex = new HashSet<>();
                    headersIndex.add(i);
                    dictionary.put(word, headersIndex);
                }
            }
        }
        return dictionary;
    }
}
