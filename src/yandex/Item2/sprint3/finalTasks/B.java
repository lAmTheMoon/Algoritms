package yandex.Item2.sprint3.finalTasks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * ID посылки 88549352
 *
 * Алгоритм быстрой сортировки основан на рекурсивном вызове метода сортировки:
 * Берем опорный эл-т, им явл-ся первый эл-т в отрезке, далее мы меняем местами эл-ты в переданном в параметры метода
 * списке, в левую часть добавляем больший эл-т, а в правую меньший, пока левый указатель не больше правого.
 * Возвращаем индекс последнего перемещенного эл-та - это и будет разделитель, делим лист на два промежутка,
 * в которых повторяем выше описанный алгоритм до тех пор, пока указатели не столкнутся.
 */

public class B {

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int count = Integer.parseInt(reader.readLine());
            List<Contestant> contestants = new ArrayList<>(count);
            for (int i = 0; i < count; i++) {
                String[] contestant = reader.readLine().split(" ");
                contestants.add(new Contestant(contestant[0],
                                               Integer.parseInt(contestant[1]),
                                               Integer.parseInt(contestant[2])));
            }

            sortContestantsAndPrint(contestants);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void sortContestantsAndPrint(List<Contestant> contestants) {
        quickSort(contestants, 0, contestants.size());
        contestants.forEach(contestant -> System.out.println(contestant.getLogin()));
    }

    public static int getPartition(List<Contestant> array, int first, int right) {
        Contestant pivot = array.get(first);
        int left = first + 1;
        right = right - 1;

        while (true) {
            right = array.get(right).compareTo(pivot) > 0 ? right - 1 : right;
            left = array.get(left).compareTo(pivot) < 0 ? left + 1 : left;

            if (left > right) {
                Collections.swap(array, first, right);
                break;
            }
            Collections.swap(array, left, right);
        }
        return right;
    }

    public static void quickSort(List<Contestant> array, int first, int last) {
        if ((last - first) < 2) {
            return;
        }
        int partition = getPartition(array, first, last);
        quickSort(array, first, partition);
        quickSort(array, partition + 1, last);
    }
}

class Contestant implements Comparable<Contestant> {

    private final String login;
    private final Integer finishedTaskCount;
    private final Integer penalty;

    public Contestant(String login, int finishedTaskCount, int penalty) {
        this.login = login;
        this.finishedTaskCount = finishedTaskCount;
        this.penalty = penalty;
    }

    public String getLogin() {
        return login;
    }

    @Override
    public int compareTo(Contestant contestant) {
        if (Objects.equals(this.finishedTaskCount, contestant.finishedTaskCount)) {
            if (Objects.equals(this.penalty, contestant.penalty)) {
                return this.login.compareTo(contestant.login);
            }
            return this.penalty.compareTo(contestant.penalty);
        }
        return contestant.finishedTaskCount.compareTo(this.finishedTaskCount);
    }
}
