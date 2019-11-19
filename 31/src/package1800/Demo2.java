package package1800;

class Node {
    char value;
    Node left;
    Node right;

    public Node(char value) {
        this.value = value;
    }
}

public class Demo2 {
    public void first(Node root) {
        if (root == null) {
            return;
        }
        System.out.println(root.value + " ");
        first(root.left);
        first(root.right);
    }
}
