import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class Node{
    char value;
    Node left;
    Node right;

    public Node(char value) {
        this.value = value;
    }
}

public class Tree {

    public void first(Node root) {
        if (root == null) {
            return;
        }
        System.out.println(root.value + " ");
        first(root.left);
        first(root.right);
    }

    public void mid(Node root) {
        if (root == null) {
            return;
        }
        mid(root.left);
        System.out.println(root.value);
        mid(root.right);
    }

    public void last(Node root) {
        if (root == null) {
            return;
        }
        last(root.left);
        last(root.right);
        System.out.println(root.value);
    }

    //求叶子节点个数
    public int getlen(Node root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null || root.right == null) {
            return 1;
        }
        return getlen(root.left) + getlen(root.right);
    }

    //求节点个数
    public int getsize(Node root) {
        if (root == null) {
            return 0;
        }
        return getsize(root.left) + getsize(root.right) + 1;
    }

    //查找val所在节点，没有找到返回null
    public Node find(Node root, int val) {
        if (root == null) {
            return null;
        }
        if (root.value == val) {
            return root;
        }
        Node node = find(root.left, val);
        if (node != null) {
            return node;
        }
        Node node2 = find(root.right, val);
            if (node2 != null) {
                return node2;
            }
        return null;
    }

    public void midorder(Node root) {
        Stack<Node> stack = new Stack<>();
        Node cur = root;
        while (cur != null || !stack.empty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            System.out.println(cur.value + " ");
            cur = cur.right;
        }
    }

    public void lastorder(Node root) {
        Stack<Node> stack = new Stack<>();
        Node cur = root;
        Node flg = null;
        while (cur != null || !stack.empty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.peek();
            if (cur.right == null || cur.right == flg) {
                System.out.println(cur.value + " ");
                stack.pop();
                flg = cur;
                cur = null;
            } else {
                cur = cur.right;
            }
        }
    }

    public void levelorder(Node root) {
        Queue<Node> queue = new LinkedList<>();
        if (root != null) {
            queue.offer(root);
        }
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            if (cur == null) {
                return;
            }
            System.out.println(cur.value + " ");
            if (cur.left != null) {
                queue.offer(cur.left);
            }
            if (cur.right != null) {
                queue.offer(cur.right);
            }
        }
    }

    public boolean isTree(Node root) {
        Queue<Node> queue = new LinkedList<>();
        if (root != null) {
            queue.offer(root);
        }
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            if (cur != null) {
                queue.offer(root.left);
                queue.offer(root.right);
            } else {
                break;
            }
        }
        return true;
    }
}

















