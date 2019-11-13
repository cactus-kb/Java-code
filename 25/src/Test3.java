import java.util.ArrayList;
import java.util.List;

class Student {
    private String name;
    private String classroom;
    private double points;

    public Student(String name, String classroom, double points) {
        this.name = name;
        this.classroom = classroom;
        this.points = points;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", classroom='" + classroom + '\'' +
                ", points=" + points +
                '}';
    }
}

public class Test3 {
    public static void main1(String[] args) {
      List<Student> list = new ArrayList<>();
      list.add(new Student("kk","java",99));
      list.add(new Student("jj","java2",94));
      list.add(new Student("ll","java1",95));
        for (Student l:list
             ) {
            System.out.println(l);
        }
    }
}
