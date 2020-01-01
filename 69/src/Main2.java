import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Person {
    public String name;
    public int score;

    public Person(String name, int score) {
        this.name = name;
        this.score = score;
    }
}

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int paixu = scanner.nextInt();
            List<Person> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                list.add(new Person(scanner.next(), scanner.nextInt()));
            }
            if (paixu == 0) {
                list.sort((o1, o2) -> o2.score - o1.score);
            } else if (paixu == 1) {
                list.sort((o2, o1) -> o1.score - o2.score);
            }
            for (Person person : list) {
                System.out.println(person.name + " " + person.score);
            }
        }
        scanner.close();
    }
}

















