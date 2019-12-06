import java.util.Objects;

class Person {
    String id;

    public Person(String id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(id, person.id);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }
}

class HashBuck2<k,v> {
    static class Node<k,v> {
        k key;
        v val;
        Node<k,v> next;
        public Node(k key,v val) {
            this.key = key;
            this.val = val;
        }
    }
    public Node<k,v>[] array;
    public int usedSize = 0;

    public HashBuck2() {
        this.array = (Node<k,v>[]) new Node[8];
    }

    public void push(k key, v val) {
        int hash = key.hashCode();
        int index = hash % array.length;
        for (Node<k,v> cur = array[index]; cur != null; cur = cur.next) {
            if (cur.key.equals(key)) {
                cur.val = val;
                return;
            }
        }
        Node<k,v> node = new Node<> (key,val);
        node.next = array[index];
        array[index] = node;
        usedSize++;
    }

    public v get(k key) {
        int hash = key.hashCode();
        int index = hash% array.length;
        for (Node<k,v> cur = array[index]; cur != null; cur = cur.next) {
            if (cur.key.equals(key)) {
                return cur.val;
            }
        }
        return null;
    }
}

public class TestDemo {
    public static void main2(String[] args) {
        Person person1 = new Person("1234");
        Person person2 = new Person("1234");
        System.out.println(person1.hashCode());
        System.out.println(person2.hashCode());
        HashBuck2<Person,String> hashBuck2 = new HashBuck2<>();
        hashBuck2.push(person1,"aa");
        String ret = hashBuck2.get(person2);
        System.out.println(ret);
    }
}
