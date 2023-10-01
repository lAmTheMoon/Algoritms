package yandex.Item2.sprint5.fialTasks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * ID посылки 91810556
 *
 * Чтобы отсортировать массив объектов методом пирамидальной сортировки нужно:
 * - Создать новый массив heap длины n+1, далее добавить кажлый объект по очереди и запустить метод просеивания вверх,
 * чтобы в heap в ячейке с индексом 1 лежал самый приоритетный объект
 * - Создать новый массив, в который будем помещать отсортированные объекты, берем объект с индеком 1 из heap и
 * добавляем его в новый массив, в heap меняем местами первый и последний эл-ты, удаляем последний и
 * запускаем метод просеивания вниз, чтобы в ячейке с индеком 1 оказался самый приоритетный эл-т, повторяем
 * пока массив heap не опустеет
 *
 * Временная сложность - O(nlog(n))
 */

public class A {

    public static final int HEAD_INDEX = 1;
    public static final int SHIFT = 1;
    public static final StringBuilder sb = new StringBuilder();

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
        List<Contestant> heap = addContestantsToHeap(contestants);
        List<Contestant> sortContestants = sortHeap(heap);
        sortContestants.forEach(contestant -> sb.append(contestant.getLogin()).append("\n"));
        System.out.println(sb);
    }

    private static List<Contestant> addContestantsToHeap(List<Contestant> contestants) {
        List<Contestant> heap = new ArrayList<>(contestants.size() + 1);
        heap.add(null);
        for (int i = 0; i < contestants.size(); i++) {
            heap.add(contestants.get(i));
            shiftUp(heap, i + SHIFT);
        }
        return heap;
    }

    private static List<Contestant> sortHeap(List<Contestant> heap) {
        List<Contestant> sortContestants = new ArrayList<>(heap.size() - 1);
        for (int i = heap.size() - 1; i > 0; i--) {
            sortContestants.add(heap.get(HEAD_INDEX));
            Collections.swap(heap, HEAD_INDEX, i);
            heap.remove(i);
            shiftDown(heap, HEAD_INDEX);
        }
        return sortContestants;
    }

    private static void shiftUp(List<Contestant> heap, int idx) {
        if (idx == HEAD_INDEX) {
            return;
        }
        int parent = idx / 2;
        if (heap.get(idx).compareTo(heap.get(parent)) > 0) {
            Collections.swap(heap, idx, parent);
            shiftUp(heap, parent);
        }
    }

    private static void shiftDown(List<Contestant> heap, int idx) {
        int left = 2 * idx;
        int right = 2 * idx + 1;
        int size = heap.size() - 1;
        if (left > size) {
            return;
        }
        int largest;
        if (right <= size && heap.get(left).compareTo(heap.get(right)) < 0) {
            largest = right;
        } else {
            largest = left;
        }
        if (heap.get(idx).compareTo(heap.get(largest)) < 0) {
            Collections.swap(heap, idx, largest);
            shiftDown(heap, largest);
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
