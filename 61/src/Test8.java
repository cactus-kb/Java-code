import java.io.*;


public class Test8 {

    public static class Person implements Serializable {
        String name;
        int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        {
            Person person1 = new Person("A",19);
            Person person2 = new Person("B",20);
            OutputStream os = new FileOutputStream("Person对象.bin");
            ObjectOutputStream oos = new ObjectOutputStream(os);
            oos.writeObject(person1);
            oos.writeObject(person2);
            oos.close();
        }

        {
            InputStream is = new FileInputStream("Person对象.bin");
            ObjectInputStream ois = new ObjectInputStream(is);
            Person p;
            p = (Person)ois.readObject();
            System.out.println(p);
            p = (Person)ois.readObject();
            System.out.println(p);
            ois.close();
        }
    }
}
