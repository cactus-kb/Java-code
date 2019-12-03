
/*
class OuterClass {
    public int data1 = 10;
    public static int data2 = 20;


    class InnerClass {
        public int data3 = 30;
        public static final int data4 = 40;
        public int data1 = 100;
        OuterClass oc = null;

        public InnerClass() {

        }

        public InnerClass (OuterClass out) {
            this.oc = out;
        }

        public void func() {
            System.out.println("InnerClass's func()");
            System.out.println("data1 :" + this.data1);
            System.out.println("data2 :" + data2);
            System.out.println("data3 :" + data3);
            System.out.println("data4 :" + data4);
            System.out.println("Outdata1: +" + oc.data1);
        }
    }
}

*/

import java.util.*;

class OutnerClass {
    public int data1 = 10;
    public static int data2 = 20;

    class InnerClass {
        public int data3 = 30;
        public static final int data4 = 40;
        public int data1 = 100;
        public InnerClass() {

        }

        public void func() {
            System.out.println("InnerClass's method");
            System.out.println("data1:" + this.data1);
            System.out.println("data2: " + data2);
            System.out.println("data3: " + data3);
            System.out.println("data4: " + data4);
            System.out.println("Outerdata1: " +OutnerClass.this.data1);
        }
    }
}

class OuterClass2 {
    public int data1 = 10;
    public static int data2 = 20;

    static class InnerClass2 {
        public int data3 = 30;
        public static int data4 = 40;
        public int data1 = 100;
        OuterClass2 o = null;

        public InnerClass2() {

        }

        public InnerClass2(OuterClass2 out) {
            this.o = out;
        }

        public void func() {
            System.out.println("InnerClass2's method");
            System.out.println("data1:" + this.data1);
            System.out.println("data2: " + data2);
            System.out.println("data3: " + data3);
            System.out.println("data4: " + data4);
            System.out.println("outdata1: " + o.data1);
        }
    }
}

class MyThread {
    public void func() {
        System.out.println("out::MyThread::func()");
    }
}

public class Tesr {

    public static<T extends Comparable<T>> TestLink.Node<T>
    mergeList(TestLink.Node<T> headA,
              TestLink.Node<T> headB) {

        /*TestLink testLink = new TestLink();
        TestLink.Node newHead = testLink.new Node();*/
        TestLink.Node<T> newHead = new TestLink.Node<>();

        TestLink.Node<T> tmp = newHead;

        while (headA != null && headB != null) {
            if(headA.data .compareTo(headB.data)<0 ) {
                tmp.next = headA;
                headA = headA.next;
                tmp = tmp.next;
            }else {
                tmp.next = headB;
                headB = headB.next;
                tmp = tmp.next;
            }
        }
        if(headA != null) {
            tmp.next = headA;
        }
        if(headB != null) {
            tmp.next = headB;
        }
        return newHead.next;
    }

    public static void main5(String[] args) {

        TestLink<Integer> testLink = new TestLink<>();
        testLink.addLast(10);
        testLink.addLast(20);
        testLink.addLast(30);
        testLink.addLast(40);
        testLink.addLast(50);
        testLink.display();

        TestLink<Integer> testLink2 = new TestLink<>();
        testLink2.addLast(10);
        testLink2.addLast(20);
        testLink2.addLast(30);
        testLink2.addLast(40);
        testLink2.addLast(50);
        testLink2.display();

        TestLink.Node newHead =
                mergeList(testLink.head,testLink2.head);
        testLink2.display2(newHead);

    }




    public static void main4(String[] args) {
        new MyThread() {
            @Override
            public void func() {
                //super.func();
                System.out.println("inner::MyThread::func()");
            }
        }.func();
    }


    public static void main3(String[] args) {
        OuterClass2 outerClass2 = new OuterClass2();
        OuterClass2.InnerClass2 innerClass2 = new OuterClass2.InnerClass2(outerClass2);
        innerClass2.func();
    }

    public static void main2(String[] args) {
        OutnerClass outnerClass = new OutnerClass();
        OutnerClass.InnerClass innerClass = outnerClass.new InnerClass();
        innerClass.func();
    }

//    public static void main1(String[] args) {
//       OuterClass c = new OuterClass();
//        OuterClass.InnerClass in = c.new InnerClass();
//        in.func();
//  }


    public static void main6(String[] args) {
        Map<Integer,String> map = new HashMap<>();
        map.put(1,"哈哈");
        map.put(2,"呵呵");
        map.put(3,"哦哦");
        map.put(4,"嗯嗯");
        map.put(5,"哼哼");
        map.put(6,"pp");
        String str = map.get(2);
        System.out.println(str);
        String str2 = map.getOrDefault(8,"null");
        System.out.println("str2: " + str2);
        map.remove(6);
        String str3 = map.getOrDefault(6,"nothing");
        System.out.println("str3: " + str3);
    }

    public static void main7(String[] args) {
        Map<Integer,String> map = new HashMap<>();
        map.put(1,"hello");
        map.put(1,"@ hello");
        map.put(3,"java");
        map.put(2,"world");
        System.out.println(map);
        System.out.println(map.get(2));
        System.out.println(map.get(99));
        System.out.println("=============");
        for (Integer key : map.keySet()) {
            System.out.println(key);
        }
        for (String value : map.values()) {
            System.out.println(value);
        }
        for (Map.Entry<Integer,String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        set.add("Hello");
        set.add("Hello");
        set.add("world");
        set.add("Hello");
        set.add("java");
        System.out.println(set);
        Iterator<String> it = set.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}





























