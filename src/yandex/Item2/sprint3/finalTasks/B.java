package yandex.Item2.sprint3.finalTasks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
            if (left <= right && array.get(right).compareTo(pivot) > 0) {
                right -= 1;
            } else if (left <= right && array.get(left).compareTo(pivot) < 0) {
                left += 1;
            } else if (array.get(right).compareTo(pivot) >= 0 || array.get(left).compareTo(pivot) <= 0) {
                continue;
            }

            if (left <= right) {
                Contestant contestant = array.get(left);
                array.set(left, array.get(right));
                array.set(right, contestant);
            } else {
                Contestant contestant = array.get(first);
                array.set(first, array.get(right));
                array.set(right, contestant);
                return right;
            }
        }
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
