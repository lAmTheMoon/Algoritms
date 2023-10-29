package yandex.Item2.sprint8.finalTasks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * ID посылки 95037346
 *
 * Чтобы определить, можно ли разбить текст на слова из словаря необходимо сперва создать префиксное дерево,
 * в котором будем хранить два значения: является ли нода терминальной и список ребер для перехода.
 * Далее мы создаем массив булевых значений, куда будем записывать промежуточный результат возможности
 * создания строки с данным индексом, те мы будем проходить по каждому индексу и записывать значение true,
 * если найден последний символ строки из словаря. Те мы можем пройти по дочерним нодам до значения текущей
 * ноды isTerminal = true -> слово найдено.
 * Если последнее слово из текста было найдено, то выходим из цикла.
 *
 * Временная сложность - O(L + N^2), где L — суммарная длина всех слов во множестве, а N - количество символов в строке.
 * Пространственная сложность - O(L + N)
 */

public class B {

    private static final String YES = "YES";
    private static final String NO = "NO";
    private static final int SHIFT = 1;

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String text = reader.readLine();
            int count = Integer.parseInt(reader.readLine());
            PrefixTree dictionary = new PrefixTree();

            for (int i = 0; i < count; i++) {
                addToTree(reader.readLine(), dictionary);
            }

            System.out.println(isCanBeSplit(text, dictionary) ? YES : NO);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean isCanBeSplit(String text, PrefixTree dictionary) {
        int textSize = text.length();
        int dpSize = textSize + SHIFT;
        boolean[] dp = new boolean[dpSize];
        dp[0] = true;
        for (int i = 0; i < textSize; i++) {
            PrefixTree node = dictionary;
            if (dp[textSize]) {
                return true;
            }
            if (dp[i]) {
                for (int j = i; j < dpSize; j++) {
                    if (node.isTerminal) {
                        dp[j] = true;
                    }
                    if (j == textSize || node.children.get(text.charAt(j)) == null) {
                        break;
                    }
                    node = node.children.get(text.charAt(j));
                }
            }
        }
        return dp[textSize];
    }

    private static void addToTree(String word, PrefixTree current) {
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            PrefixTree prefixTree = current.children.get(c);
            if (prefixTree == null) {
                prefixTree = new PrefixTree();
                current.children.put(c, prefixTree);
            }
            current = prefixTree;
        }
        current.isTerminal = true;
    }

    static class PrefixTree {

        private final Map<Character, PrefixTree> children;
        private boolean isTerminal;

        public PrefixTree() {
            this.children = new HashMap<>();
            this.isTerminal = false;
        }
    }
}
