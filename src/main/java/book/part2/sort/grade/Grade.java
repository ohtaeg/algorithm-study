package book.part2.sort.grade;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Grade {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        List<Student> students = new ArrayList<>(n);

        while (n-- >0) {
            students.add(new Student(bufferedReader.readLine()));
        }

        Collections.sort(students);

        for (int i = 0; i < students.size(); i++) {
            System.out.print(students.get(i).getName());
            if (i != students.size() - 1) {
                System.out.print(" ");
            }
        }
        bufferedReader.close();
    }
}
