package package1144;

import java.util.Scanner;

class Node {
    char value;
    Node left;
    Node right;

    public Node(char value) {
        this.value = value;
    }
}

//二叉树的构建以及遍历
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        Node node = buildTree(str);
        System.out.println(node);
    }

    public static void firstorder(Node root) {
        if (root == null) {
            return;
        }
        System.out.println(root.value + " ");
        firstorder(root.left);
        firstorder(root.right);
    }

    public static int i = 0;
    public static Node buildTree(String str) {
        Node root = null;
        if (str.charAt(i) != '#') {
            root = new Node(str.charAt(i));
            i++;
            root.left = buildTree(str);
            root.right = buildTree(str);
        } else {
            i++;
        }
        return root;

//            char ch = str.charAt(i);
//            if (root == null) {
//                root = new Node(ch);
//            } else if (root.left == null) {
//                root.left = new Node(ch);
//            } else {
//                root.right = new Node(ch);
//            }
//        } else {
//            i++;
//        }
//        return root;
    }
}
