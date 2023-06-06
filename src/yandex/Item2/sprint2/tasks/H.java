package yandex.Item2.sprint2.tasks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/*
Вот какую задачу Тимофей предложил на собеседовании одному из кандидатов.
Если вы с ней ещё не сталкивались, то наверняка столкнётесь –— она довольно популярная.
Дана скобочная последовательность. Нужно определить, правильная ли она.

Будем придерживаться такого определения:
пустая строка —– правильная скобочная последовательность;
правильная скобочная последовательность, взятая в скобки одного типа, –— правильная скобочная последовательность;
правильная скобочная последовательность с приписанной слева или справа правильной скобочной последовательностью —– тоже правильная.
На вход подаётся последовательность из скобок трёх видов: [], (), {}.
Напишите функцию is_correct_bracket_seq, которая принимает на вход скобочную последовательность и возвращает True, если последовательность правильная, а иначе False.
 */
public class H {

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String brackets = reader.readLine();
            System.out.println(checkBrackets(brackets) ? "True" : "False");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static private boolean checkBrackets(String brackets) {
        char[] array = brackets.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char c : array) {
            if (c == '{') {
                stack.push('}');
            } else if (c == '(') {
                stack.push(')');
            } else if (c == '[') {
                stack.push(']');
            } else if (stack.empty() || stack.peek() != c) {
                return false;
            } else {
                stack.pop();
            }
        }

        return stack.empty();
    }
}
