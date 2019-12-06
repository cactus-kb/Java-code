public class Demo {
    public static void main(String[] args) {
        String str = "";
        System.out.print(str.split(",").length);
    }

    class Node1 {
        public int data;
        public Node1 next;

        public Node1() {

        }

        public Node1(int data) {
            this.data = data;
        }
    }

    public Node1 head;
    public void removeAllkey(int data) {
        if (this.head == null) {
            return;
        }
        Node1 cur = this.head;
        while (cur.next != null) {
            if (cur.next.data != data) {
                cur = cur.next;
            } else {
                cur.next = cur.next.next;
            }
        }
        if (this.head.data == data) {
            this.head = this.head.next;
        } else {
            this.head = this.head;
        }
    }
}


