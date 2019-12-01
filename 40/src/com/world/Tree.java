package com.world;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

class Node {
    int value;
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
    }
}

public class Tree {

    //非递归中序遍历
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

//    public void mid(Node root) {
//        Stack<Node> stack = new Stack<>();
//        Node cur = root;
//        while (cur != null || !stack.empty()) {
//            while (cur != null) {
//                stack.push(cur);
//                cur = cur.left;
//            }
//            cur = stack.pop();
//            System.out.println(cur.value + " ");
//            cur = cur.right;
//        }
//    }

    //非递归后序遍历
    public void lastorder(Node root) {
        Stack<Node> stack = new Stack<>();
        Node cur = root;
        Node flg = null;
        while (cur != null && !stack.empty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            //cur == null
            cur = stack.peek();
            if (cur.right == null ||cur.right == flg) {
                System.out.println(cur.value);
                stack.pop();
                flg = cur;
                cur = null;
            } else {
                cur = cur.right;
            }
        }
    }

    //层序遍历
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

    //判断一棵树是不是完全二叉树
    public boolean iscomplete(Node root) {
        Queue<Node> queue = new LinkedList<>();
        if (root != null) {
            queue.offer(root);
        }
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            if (cur != null) {
                queue.offer(cur.left);
                queue.offer(cur.right);
            } else {
                break;
            }
        }
        //遍历队列中的元素
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            if (cur != null) {
                return false;
            }
        }
        return true;
    }

    //二叉树的构建及遍历(中序遍历)
    private static int i = 0;
    public static Node buildtree(String str) {
        Node root = null;
        if (str.charAt(i) != '#') {
            root = new Node(str.charAt(i));
            i++;
            root.left = buildtree(str);
            root.right = buildtree(str);
        } else {
            i++;
        }
        return root;
    }

    public static void inorder(Node root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        System.out.println(root.value + " ");
        inorder(root.right);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        Node root = buildtree(str);
        inorder(root);
    }

    //找到指定树中两个指定节点的最近公共祖先
    public Node ancestor(Node root, Node p, Node q) {
        if (root == null) {
            return null;
        }
        if (root == p || root == q) {
            return root;
        }
       Node left = ancestor(root.left, p, q);
        Node right = ancestor(root.right, p, q);
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

    //二叉搜索树转换成排序双向链表
    public Node convert(Node roottree) {
        convertchild(roottree);
        Node head = roottree;

        while (head != null && head.left != null) {
            head = head.left;
        }
        return head;
    }
    private Node prev = null;

    private void convertchild(Node root) {
        if (root == null) {
            return;
        }
        convertchild(root.left);
        root.left = prev;
        if (prev != null) {
            prev.right = root;
        }
        prev = root;
        convertchild(root.right);
    }


    //从前序遍历与中序遍历中构造二叉树
    public Node buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0) {
            return null;
        }
        return buildTreeChild(preorder,inorder,0,inorder.length - 1);
    }
    //pi:前序遍历的下标；ib:中序遍历的开始，ie:中序遍历的结尾
    public int preIndex;
    private Node buildTreeChild(int[] preorder, int[] inorder,int inbegin, int inend) {
        if (inbegin > inend) {
            return null;
        }
        Node root = new Node(preorder[preIndex]);
        int rootIndex = findInorderIndex(inorder,inbegin, inend,preorder[preIndex]);
        if (rootIndex == -1) {
            return null;
        }
        preIndex++;
        root.left = buildTreeChild(preorder, inorder,inbegin,rootIndex - 1);
        root.right = buildTreeChild(preorder,inorder,rootIndex + 1,inend);
        return root;
    }
    private int findInorderIndex(int[] inorder,int inbegin, int inend,int val) {
        for (int i = inbegin; i <= inend; i++) {
            if (inorder[i] == val) {
                return i;
            }
        }
        return -1;
    }

    //二叉树创建字符串
    public String treestr(Node t) {
        StringBuilder sb = new StringBuilder();
        treestrChild(t,sb);
        return sb.toString();
    }
    private void treestrChild(Node t, StringBuilder sb) {
        if (t == null) {
            return;
        }
        sb.append(t.value);
        if (t.left == null) {
            if (t.right == null) {
                return;
            } else {
                sb.append("()");
            }
        } else {
            sb.append("(");
            treestrChild(t.left,sb);
            sb.append(")");
        }
        if (t.right == null) {
            return;
        } else {
            sb.append("(");
            treestrChild(t.right,sb);
            sb.append(")");
        }
    }
}