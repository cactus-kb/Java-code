package package1115;

public class Demo {
    public static void main(String[] args) {
        LinkedList list1 = new LinkedList();
        list1.addLast(1);
        list1.addLast(2);
        list1.addLast(3);
        list1.addLast(2);
        list1.addLast(2);
        list1.addLast(4);
        list1.display();
        list1.removeAllkey(2);
        list1.display();
    }

    public static void main3(String[] args) {
        LinkedList list1 = new LinkedList();
        list1.addLast(1);
        list1.addLast(2);
        list1.addLast(3);
        list1.addLast(2);
        list1.addLast(4);
        list1.addLast(3);
        list1.display();
        list1.remove(2);
        list1.display();
    }

    public static void main2(String[] args) {
        LinkedList list1 = new LinkedList();
        list1.addLast(1);
        list1.addLast(2);
        list1.addLast(3);
        list1.display();
        list1.addIndex(0,0);
        list1.display();
        list1.addIndex(1,4);
        list1.display();
        boolean b = list1.contains(0);
        System.out.println(b);
        boolean b1 = list1.contains(5);
        System.out.println(b1);
    }


    public static void main1(String[] args) {
        LinkedList list = new LinkedList();
        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);
        list.display();
        LinkedList list1 = new LinkedList();
        list1.addLast(1);
        list1.addLast(2);
        list1.addLast(3);
        list1.display();
    }

}