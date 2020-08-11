package boj.deck;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

/**
 * 이 문제는 회전이 관건이였음;
 * 자료구조를 회전하는 순간 시간초과 되기에 방향에 따라 처음에 삭제할지 마지막에 삭제할지 판단하여 삭제하도록 로직 변경
 */
public class Q5430 {
    public static void main(String[] args) {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            int testCount = Integer.parseInt(bufferedReader.readLine());
            while (testCount-- > 0) {
                String[] command = bufferedReader.readLine().split("");
                int size = Integer.parseInt(bufferedReader.readLine());
                String data = bufferedReader.readLine();
                String[] datas = convertData(data);

                MyDeque myDeque = new MyDeque(datas);
                System.out.println(myDeque.operate(command));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String[] convertData(final String data) {
        return data.replace("[", "")
                   .replace("]", "")
                   .split(",");
    }
}

class MyDeque {
    private final LinkedList<String> list;

    public MyDeque(final String[] data) {
        this.list = init(data);
    }

    private LinkedList init(final String[] data) {
        final LinkedList<String> list = new LinkedList<>();
        if (data.length == 1 && data[0].isEmpty()) {
            return list;
        }
        for (int i = 0; i < data.length; i++) {
            list.add(data[i]);
        }
        return list;
    }

    public String operate(final String[] commands) {
        boolean isReverse = false;

        for (String command : commands) {
            if ("R".equals(command)) {
                isReverse = !isReverse;
            } else {
                if (list.isEmpty()) {
                    return "error";
                }

                if (isReverse) {
                    list.removeLast();
                } else {
                    list.removeFirst();
                }
            }
        }
        return printResult(isReverse);
    }

    private String printResult(final boolean isReverse) {
        StringBuilder result = new StringBuilder("[");
        while (!list.isEmpty()) {
            if (isReverse) {
                result.append(list.removeLast());
            } else {
                result.append(list.removeFirst());
            }

            if (!list.isEmpty()) {
                result.append(",");
            }
        }
        result.append("]");
        return result.toString();
    }
}
