package package0;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

class Node {
    char value;
    Node left;
    Node right;

    public Node(char value) {
        this.value = value;
    }
}

public class Tree {

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

    //非递归实现二叉树的前序遍历
    public void prevorderTriversal(Node root) {
        Stack<Node> stack = new Stack<>();
        Node cur = root;
        while (cur != null || !stack.empty()) {
            while (cur != null) {
                stack.push(cur);
                System.out.println(cur.value + " ");
                cur = cur.left;
            }
            cur = stack.pop();
            cur = cur.right;
        }
    }


    //非递归实现二叉树的中序遍历
    public void midorder(Node root) {
        Stack<Node> stack = new Stack<>();
        if (root == null) {
            return;
        }
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

    //非递归实现二叉树的后续遍历
    public void lastorder(Node root) {
        Stack<Node> stack = new Stack<>();
        Node cur = root;
        Node flg = null;
        while (cur != null || !stack.empty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            //cur 得到栈顶元素，看是否有右子树
            cur = stack.peek();
            if (cur.right == null ||cur.right == flg) {
                System.out.print(cur.value + " ");
                stack.pop();
                flg = cur;
                cur = null;
            } else {
                cur = cur.right;
            }
        }
    }

    //层序遍历
    public void levelorderTraversal(Node root) {
        Queue<Node> queue = new LinkedList<>();
        if (root != null) {
            queue.offer(root);
        }
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            if (cur == null) {
                return;
            }
            System.out.print(cur.value + " ");
            if (cur.left != null) {
                queue.offer(cur.left);
            }
            if (cur.right != null) {
                queue.offer(cur.right);
            }
        }
    }

    //判断一棵二叉树是否是完全二叉树
    public boolean isCompleteTree(Node root) {
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
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            if (cur != null) {
                return false;
            }
        }
        return true;

//        Queue<Node> queue = new LinkedList<>();
//        Node cur = root;
//        if (root != null) {
//            queue.offer(root);
//        }
//        while (cur != null) {
//            if (cur.left != null) {
//                queue.offer(cur.left);
//            }
//            if (cur.right != null) {
//                queue.offer(cur.right);
//            }
//            cur = queue.poll();
//        }
//        if (queue.isEmpty()) {
//            return true;
//        }
//        return false;
    }

    public void preorder(Node root) {
        if (root == null) {
            return;
        }
        System.out.println(root.value + " ");
        preorder(root.left);
        preorder(root.right);
    }

    public void inoeder(Node root) {
        if (root == null) {
            return;
        }
        inoeder(root.left);
        System.out.println(root.value + " ");
        inoeder(root.right);
    }

    public void postorder(Node root) {
        if (root == null) {
            return;
        }
        preorder(root.left);
        preorder(root.right);
        System.out.println(root.value + " ");
    }

    public int getsize(Node root) {
        if (root == null) {
            return 0;
        }
        return getsize(root.left) + getsize(root.right) + 1;
    }

    public int getleaf(Node root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        return getleaf(root.left) + getleaf(root.right);
    }

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

}
