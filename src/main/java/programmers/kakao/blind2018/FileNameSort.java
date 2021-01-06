package programmers.kakao.blind2018;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 1. 파일명은 우선 HEAD 기준으로 사전순으로 정렬한다. (대소문자 구분을 하지 않는다)
 * 2. HEAD 부분이 같을 경우 NUMBER 부분은 숫자 순으로 정렬한다.
 * 3. HEAD와 NUMBER 부분이 같으면 원래 입력 순서를 유지한다.
 */
public class FileNameSort {
    private static final Pattern PATTERN = Pattern.compile("(^[^0-9]*)([0-9]{1,5})");

    public static void main(String[] args) {
        FileNameSort solution = new FileNameSort();
        String[] input1 = {
                "img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"
        };
        solution.solution(input1);
    }

    public String[] solution(String[] inputs) {
        List<File> files = init(inputs);

        parse(files);
        Collections.sort(files);

        String[] answer = new String[inputs.length];
        for (int i = 0; i < inputs.length; i++) {
            answer[i] = files.get(i)
                             .getFileName();
        }
        return answer;
    }

    private List<File> init(final String[] inputs) {
        List<File> files = new ArrayList<>();
        for (int i = 0; i < inputs.length; i++) {
            files.add(new File(inputs[i], i));
        }
        return files;
    }

    private void parse(final List<File> files) {
        for (File file : files) {
            Matcher matcher = PATTERN.matcher(file.getFileName());
            if (matcher.find()) {
                final String head = matcher.group(1)
                                           .toLowerCase();
                final int number = Integer.parseInt(matcher.group(2));
                file.setHead(head);
                file.setNumber(number);
            }
        }
    }
}

class File implements Comparable<File> {
    private String fileName;
    private String head;
    private int number;
    private int order;

    public File(final String fileName, final int order) {
        this.fileName = fileName;
        this.order = order;
    }

    public void setHead(final String head) {
        this.head = head;
    }

    public void setNumber(final int number) {
        this.number = number;
    }

    public String getFileName() {
        return fileName;
    }

    @Override
    public int compareTo(final File o) {
        if (head.equals(o.head)) {
            if (this.number == o.number) {
                return Integer.compare(this.order, o.order);
            } else {
                return Integer.compare(this.number, o.number);
            }
        } else {
            return head.compareTo(o.head);
        }
    }
}
