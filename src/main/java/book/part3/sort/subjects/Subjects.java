package book.part3.sort.subjects;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 국영수
 */
public class Subjects {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());

        List<Student> students = new ArrayList<>(n);

        while (n-- > 0) {
            students.add(new Student(bufferedReader.readLine()));
        }

        Collections.sort(students);

        for (Student student : students) {
            System.out.println(student.getName());
        }

        bufferedReader.close();
    }
}
