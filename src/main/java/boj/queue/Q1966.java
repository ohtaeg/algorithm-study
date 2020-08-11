package boj.queue;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.Queue;

public class Q1966 {
    public static void main(String[] args) {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out))) {

            List<String> result = new ArrayList<>();
            StringTokenizer stringTokenizer;
            int caseCount = Integer.parseInt(bufferedReader.readLine());
            while (caseCount-- > 0) {
                stringTokenizer = new StringTokenizer(bufferedReader.readLine());
                int n = parseInt(stringTokenizer.nextToken());
                int index = parseInt(stringTokenizer.nextToken());
                String[] priorities = bufferedReader.readLine()
                                                    .split(" ");
                Queue<Document> queue = initQueue(n, index, priorities);


                result.add(String.valueOf(print(queue)));
            }

            final String value = result.stream().collect(Collectors.joining(System.lineSeparator()));
            bufferedWriter.write(value);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int parseInt(String input) {
        return Integer.parseInt(input);
    }

    private static Queue initQueue(final int n, final int index, final String[] priorities) {
        Queue<Document> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            int priority = parseInt(priorities[i - 1]);
            queue.offer(Document.of(priority, i - 1 == index));
        }
        return queue;
    }

    private static int print(final Queue<Document> queue) {
        int printCount = 0;
        int currentMaxPriority;

        while (!queue.isEmpty()) {
            currentMaxPriority = calculateMaxPriority(queue);
            Document document = queue.poll();
            if (document.isMaxPriority(currentMaxPriority)) {
                ++printCount;
                if (document.isTarget()) {
                    return printCount;
                }
            } else {
                queue.offer(document);
            }
        }
        return printCount;
    }

    private static int calculateMaxPriority(final Queue<Document> queue) {
        return queue.stream()
                    .mapToInt(Document::getPriority)
                    .max()
                    .getAsInt();
    }
}

class Document {
    private final int priority;
    private final boolean isTarget;

    private Document(final int priority, final boolean isTarget) {
        this.priority = priority;
        this.isTarget = isTarget;
    }

    public static Document of(final int priority, final boolean isTarget) {
        return new Document(priority, isTarget);
    }

    public boolean isMaxPriority(final int currentMaxPriority) {
        return this.priority == currentMaxPriority;
    }

    public boolean isTarget() {
        return isTarget;
    }

    public int getPriority() {
        return priority;
    }
}
