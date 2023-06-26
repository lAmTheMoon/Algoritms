package yandex.Item2.sprint3.finalTasks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * ID посылки 88549352
 *
 * Алгоритм быстрой сортировки основан на рекурсивном вызове метода сортировки:
 * Берем опорный эл-т, им явл-ся примерно средний эл-т в отрезке, далее мы меняем местами эл-ты в переданном в параметры метода
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
        quickSort(contestants, 0, contestants.size() - 1);
        contestants.forEach(contestant -> System.out.println(contestant.toString()));
    }

    public static int getPartition(List<Contestant> array, int left, int right) {
        int pivotIndex = (left + right) / 2;
        Contestant pivot = array.get(pivotIndex);

        while (left <= right) {
            while (array.get(left).compareTo(pivot) > 0) {
                left++;
            }
            while (array.get(right).compareTo(pivot) < 0) {
                right--;
            }
            if (left <= right) {
                Collections.swap(array, left, right);
                left++;
                right--;
            }
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
            return contestant.penalty.compareTo(this.penalty);
        }
        return this.finishedTaskCount.compareTo(contestant.finishedTaskCount);
    }

    @Override
    public String toString() {
        return "login='" + login + '\'' +
                ", finishedTaskCount=" + finishedTaskCount +
                ", penalty=" + penalty;
    }
}
