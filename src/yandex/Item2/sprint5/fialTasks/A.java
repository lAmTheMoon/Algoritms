package yandex.Item2.sprint5.fialTasks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;

public class A {

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
        if (contestants.size() > 1) {
            pyramidSort(contestants, 0, contestants.size() - 1);
        }
        contestants.forEach(contestant -> System.out.println(contestant.getLogin()));
    }

    public static int getPartition(List<Contestant> array, int left, int right) {
        int pivotIndex = ThreadLocalRandom.current().nextInt(left, right + 1);
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
        return left;
    }

    public static void pyramidSort(List<Contestant> array, int first, int last) {
        int partition = getPartition(array, first, last);
        if (first < partition - 1) {
            pyramidSort(array, first, partition - 1);
        }
        if (partition < last) {
            pyramidSort(array, partition, last);
        }
    }
}

class Contestant implements Comparable<Contestant> {

    private final String login;
    private final int finishedTaskCount;
    private final int penalty;

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
                return contestant.login.compareTo(this.login);
            }
            return this.penalty > contestant.penalty ? -1 : 1;
        }
        return this.finishedTaskCount > contestant.finishedTaskCount ? 1 : -1;
    }
}
