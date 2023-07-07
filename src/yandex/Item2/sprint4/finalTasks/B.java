package yandex.Item2.sprint4.finalTasks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B {

    public static final String GET = "get";
    public static final String PUT = "put";
    public static final String DELETE = "delete";

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int commandCount = Integer.parseInt(reader.readLine());
            int dequeCapacity = Integer.parseInt(reader.readLine());
            String[] commands = new String[commandCount];
            for (int i = 0; i < commandCount; i++) {
                commands[i] = reader.readLine();
            }
            printResult(dequeCapacity, commands);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void printResult(int mapCapacity, String[] commands) {
        MyMap<Integer, Integer> map = new MyMap<>(mapCapacity);
        for (String command : commands) {
            if (command.startsWith(GET)) {
                map.get(getValue(command)[1]);
            } else if (command.startsWith(PUT)) {
                int[] numbers = getValue(command);
                map.put(numbers[1], numbers[2]);
            } else if (command.startsWith(DELETE)) {
                map.delete(getValue(command)[1]);
            } else {
                throw new UnsupportedOperationException();
            }
        }
    }

    private static int[] getValue(String command) {
        return Arrays.stream(command.split(" "))
                .skip(1)
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}

class MyMap<T, N> {

    private final int capacity;

    public MyMap(int capacity) {
        this.capacity = capacity;
        objects = new Object[capacity];
    }

    public void put(T t, N n) {

    }

    public void get(T t) {

    }

    public void delete(T t) {

    }
}
