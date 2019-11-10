package package1;


class Address {
    public String domicNum;
    public int floor;

    public Address(String domicNum, int floor) {
        this.domicNum = domicNum;
        this.floor = floor;
    }
}

class Student {
    public String name;
    public int age;
    public Address address;

    public Student (String name, int age, Address address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    @Override
    public String
    toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", address.domicNum=" + address.domicNum +
                ", address.floor=" + address.floor +
                '}';
    }
}

public class Demo1 {
    public static void main1(String[] args) {
        Address address = new Address("6号楼",4);
        Student stu = new Student("kk",12,address);
        System.out.println(stu);
    }
}
