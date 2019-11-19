package package1910;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Node {
    char value;
    Node left;
    Node right;

    public Node(char value) {
        this.value = value;
    }
}

public class BinaryTree {

    //人为创建二叉树
    public Node buildTree() {
        Node A = new Node('A');
        Node B = new Node('B');
        Node C = new Node('C');
        Node D = new Node('D');
        Node E = new Node('E');
        Node F = new Node('F');
        Node G = new Node('G');
        Node H = new Node('H');
        A.left = B;
        A.right = C;
        B.left = D;
        B.right = E;
        E.right = H;
        C.left = F;
        C.right = G;
        return A;
    }

    //前序遍历
    public void preOrderTraversal(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.value + " ");
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }

    //中序遍历
    public void inOrderTraversal(Node root) {
        if (root == null) {
            return;
        }
        inOrderTraversal(root.left);
        System.out.print(root.value + " ");
        inOrderTraversal(root.right);
    }

    //后序遍历
    public void postOrderTraversal(Node root) {
        if (root == null) {
            return;
        }
        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.print(root.value + " ");
    }

    // 求结点个数
    public int getSize1(Node root) {
        if (root == null) {
            return 0;
        }
        return getSize1(root.left) + getSize1(root.right) + 1;
    }

    //求叶子节点的个数
    public int getLeafSize1(Node root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        return getLeafSize1(root.left) + getLeafSize1(root.right);
    }

    //查找 val 所在结点，没有找到返回 null
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
        Node node1 = find(root.right, val);
        if (node1 != null) {
            return node1;
        }
        return null;
    }

    public void midorderTriversal(Node root) {
        Stack<Node> stack = new Stack<>();
        Node cur = root;
        while (cur != null || !stack.empty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            System.out.print(cur.value + " ");
            cur = cur.right;
        }
    }

    public void lastorderTriversal(Node root) {
        Stack<Node> stack = new Stack<>();
        Node cur = root;
        while (cur != null || !stack.empty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            cur = cur.right;
        }
    }
}
