package book.part2.sort.grade;

public class Student implements Comparable<Student> {
    private final String name;
    private final int grade;

    public Student(final String source) {
        String[] data = source.split(" ");
        this.name = data[0];
        this.grade = Integer.parseInt(data[1]);
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(final Student o) {
        return Integer.compare(this.grade, o.grade);
    }
}
