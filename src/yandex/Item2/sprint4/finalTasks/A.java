package yandex.Item2.sprint4.finalTasks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * ID посылки 88925211
 *
 * На первом этапе формируется список из документов, который в дальнейшем преобразовывается в мапу(словарь),
 * где ключ - Слово, встречающееся в документах, значение тоже мапа, где ключ - индекс документа,
 * значение - количество повторений слова в документе.
 * Запросы представляют собой список, в запросе нет повторов слов.
 *
 * Далее сопоставляются запросы со словарем в цикле и для каждого запроса в результирующую мапу записывается
 * индекс и суммируется количество повторений для каждого слова.
 * После сортировка и вывод информации.
 *
 * Временная сложность - O(N^2)
 */
public class A {

    public static final int MAX_RESULT_SIZE = 5;
    public static final int SHIFT = 1;

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            int firstCount = Integer.parseInt(reader.readLine());
            List<List<String>> headers = new ArrayList<>(firstCount);
            for (int i = 1; i <= firstCount; i++) {
                headers.add(getListFromStrings(reader));
            }

            int secondCount = Integer.parseInt(reader.readLine());
            List<Set<String>> questions = new ArrayList<>(secondCount);
            for (int i = 0; i < secondCount; i++) {
                questions.add(getSetFromStrings(reader));
            }

            System.out.println(getInfoAboutResult(headers, questions));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String getInfoAboutResult(List<List<String>> headers, List<Set<String>> questions) {
        Map<String, Map<Integer, Integer>> dictionary = fillDictionary(headers);
        StringBuilder sb = new StringBuilder();

        questions.forEach(question -> {
            Map<Integer, Integer> result = getPriorityMap(dictionary, question);
            sortPriorityMapAndSafeInfo(result, sb);
        });

        return sb.toString();
    }

    private static void sortPriorityMapAndSafeInfo(Map<Integer, Integer> result, StringBuilder sb) {
        result.entrySet().stream()
                .sorted(Map.Entry.<Integer, Integer>comparingByValue().reversed()
                        .thenComparing(Map.Entry.comparingByKey()))
                .limit(MAX_RESULT_SIZE)
                .forEach(k -> sb.append(k.getKey() + SHIFT).append(" "));
        sb.append("\n");
    }

    private static Map<Integer, Integer> getPriorityMap(Map<String, Map<Integer, Integer>> dictionary,
                                                        Set<String> question) {
        Map<Integer, Integer> result = new HashMap<>();

        question.stream()
                .map(dictionary::get)
                .filter(Objects::nonNull)
                .map(Map::entrySet)
                .flatMap(Collection::stream)
                .forEach(entry -> result.merge(entry.getKey(), entry.getValue(), Integer::sum));

        return result;
    }

    private static List<String> getListFromStrings(BufferedReader reader) throws IOException {
        return Arrays.stream(reader.readLine().split(" "))
                .collect(Collectors.toList());
    }

    private static Set<String> getSetFromStrings(BufferedReader reader) throws IOException {
        return Arrays.stream(reader.readLine().split(" "))
                .collect(Collectors.toSet());
    }

    private static Map<String, Map<Integer, Integer>> fillDictionary(List<List<String>> headings) {
        Map<String, Map<Integer, Integer>> dictionary = new HashMap<>();
        for (int i = 0; i < headings.size(); i++) {
            for (String word : headings.get(i)) {
                if (dictionary.containsKey(word)) {
                    dictionary.get(word).merge(i, 1, Integer::sum);
                } else {
                    Map<Integer, Integer> headersIndexAndCount = new HashMap<>();
                    headersIndexAndCount.put(i, 1);
                    dictionary.put(word, headersIndexAndCount);
                }
            }
        }
        return dictionary;
    }
}
