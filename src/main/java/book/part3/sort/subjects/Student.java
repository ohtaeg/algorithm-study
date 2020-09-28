package book.part3.sort.subjects;

public class Student implements Comparable<Student> {
    private final String name;
    private final int korean;
    private final int english;
    private final int math;

    public Student(final String input) {
        final String[] data = input.split(" ");
        this.name = data[0];
        this.korean = Integer.parseInt(data[1]);
        this.english = Integer.parseInt(data[2]);
        this.math = Integer.parseInt(data[3]);
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(final Student other) {
        if (this.korean != other.korean) {
            return Integer.compare(other.korean, this.korean);
        }

        if (this.english != other.english) {
            return Integer.compare(this.english, other.english);
        }

        if (this.math != other.math) {
            return Integer.compare(other.math, this.math);
        }

        return this.name.compareTo(other.name);
    }
}
