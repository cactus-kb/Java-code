package com.util;

import java.util.Stack;

class Node {
    char value;
    Node left;
    Node right;

    public Node (char value) {
        this.value = value;
    }
}

public class Demo {

    public void firstOrder(Node root) {
        if (root == null) {
            return;
        }
        System.out.println(root.value + " ");
        firstOrder(root.left);
        firstOrder(root.right);
    }

    public void mediumOrder(Node root) {
        if (root == null) {
            return;
        }
        mediumOrder(root.left);
        System.out.println(root.value + " ");
        mediumOrder(root.right);
    }

    public void lastOrder(Node root) {
        if (root == null) {
            return;
        }
        lastOrder(root.left);
        lastOrder(root.right);
        System.out.println(root.value + " ");
    }

    public boolean isSame(Node root, Node root2) {
        if (root == null && root2 == null) {
            return true;
        }
        if (root == null && root2 != null) {
            return false;
        }
        if (root != null && root2 == null) {
            return false;
        }
        if (root.value != root2.value) {
            return false;
        }
        return isSame(root.left, root2.left) && isSame(root.right, root2.right);
    }

    public boolean isSubtree(Node root, Node root2) {
        if (root == null || root2 == null) {
            return false;
        }
        if (isSame(root, root2)) {
            return true;
        }
        if (isSubtree(root.left, root2)) {
            return true;
        }
        if (isSubtree(root.right, root2)) {
            return true;
        }
        return false;
    }

    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        if (left > right) {
            return left + 1;
        } else {
            return right + 1;
        }
    }

    public boolean isBalance(Node root) {
        if (root == null) {
            return false;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.abs(left - right) <= 1 && isBalance(root.left) && isBalance(root.right);
    }

    public boolean isSymmetric(Node root) {
        if (root == null) {
            return false;
        }
        return isSymmetricChild(root.left, root.right);
    }
    private boolean isSymmetricChild(Node leftTree, Node rightTree) {
        if (leftTree == null && rightTree != null) {
            return false;
        }
        if (leftTree != null && rightTree == null) {
            return false;
        }
        if (leftTree == null && rightTree == null) {
            return true;
        }
        return (leftTree.value == rightTree.value) && isSymmetricChild(leftTree.left, rightTree.right
        ) && isSymmetricChild(leftTree.right, rightTree.left);
    }

    public void preveroder(Node root) {
        Stack<Node> stack = new Stack<>();
        Node cur = root;
        while (cur != null || !stack.empty()) {
            while (cur != null) {
                stack.push(cur);
                System.out.println(cur.value);
                cur = cur.left;
            }
            cur = stack.pop();
            cur = cur.right;
        }
    }

    public void midorder(Node root) {
        Stack<Node> stack = new Stack<>();
        Node cur = root;
        while (cur != null || !stack.empty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = cur.left;
            System.out.println(cur.value + " ");
            cur = cur.right;
        }
    }

    //二叉树创建字符串（前序）
    public String treeStr(Node root) {
        StringBuilder sb = new StringBuilder();
        treeStrChild(root,sb);
        return sb.toString();
    }
    private void treeStrChild(Node root, StringBuilder sb) {
        if (root == null) {
            return;
        }
        sb.append(root.value);
        if (root.left == null) {
            if (root.right == null) {
                return;
            } else {
                sb.append("()");
            }
        } else {
            sb.append("(");
            treeStrChild(root.left, sb);
            sb.append(")");
        }
        if (root.right == null) {
            return;
        } else {
            sb.append("(");
            treeStrChild(root.right, sb);
            sb.append(")");
        }
    }

    public Node ancester(Node root, Node p, Node q) {
        if (root == null) {
            return null;
        }
        if (p == null || q == null) {
            return root;
        }
        Node left = ancester(root.left, p, q);
        Node right = ancester(root.right,p, q);
        if (left != null && right != null) {
            return root;
        }
        if (left != null) {
            return left;
        }
        if (right != null) {
            return right;
        }
        return null;
    }
}






































































