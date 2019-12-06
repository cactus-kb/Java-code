public class Test {
    public static void main1(String[] args) {
        HashBuck hashBuck = new HashBuck();
        hashBuck.put(1,66);
        hashBuck.put(11,88);
        hashBuck.put(4,400);
        hashBuck.put(26,900);
        hashBuck.put(21,8888);
        int ret = hashBuck.get(21);
        System.out.println(ret);
    }

    static class Node {
        public int data;
        public Node next;

        public Node() {

        }

        public Node(int data) {
            this.data = data;
        }
    }

    public static Node head;
    public static void ainsert(int data) {
        Node node = new Node(data);
        if (head == null) {
            head = node;
        } else {
            node.next = head;
            head = node;
        }
    }
}
