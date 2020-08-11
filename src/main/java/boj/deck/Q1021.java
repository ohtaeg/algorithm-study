package boj.deck;

import java.io.*;
import java.util.LinkedList;

public class Q1021 {
    public static void main(String[] args) {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out))) {
            String[] inputs = bufferedReader.readLine().split(" ");
            int n = Integer.parseInt(inputs[0]);
            String[] sources = bufferedReader.readLine().split(" ");

            CustomDeque customDeque = new CustomDeque(n);
            int result = customDeque.select(sources);

            bufferedWriter.write(String.valueOf(result));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class CustomDeque {
    private final LinkedList<Integer> list;

    public CustomDeque(final int n) {
        this.list = init(n);
    }

    private LinkedList<Integer> init(final int n) {
        final LinkedList<Integer> list = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }
        return list;
    }


    public int select(final String[] sources) {
        int result = 0;
        for (int i = 0; i < sources.length; i++) {
            result += rotate(Integer.parseInt(sources[i]));
        }
        return result;
    }

    private int rotate(final int target) {
        int rotateCount = 0;
        while (true) {
            int targetPosition = list.indexOf(target);
            int leftDiff = targetPosition;
            int rightDiff = list.size() - targetPosition;

            if (targetPosition == 0) {
                list.removeFirst();
                break;
            }

            if (leftDiff <= rightDiff) {
                list.add(list.removeFirst());
            } else {
                list.addFirst(list.removeLast());
            }
            rotateCount++;
        }

        return rotateCount;
    }
}


