package package949;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Node1 {
    int value;
    Node1 left;
    Node1 right;

    public Node1(char value) {
        this.value = value;
    }
}
public class BinTree {

    //人为创建二叉树
    public Node1 buildTree() {
        Node1 A = new Node1('A');
        Node1 B = new Node1('B');
        Node1 C = new Node1('C');
        Node1 D = new Node1('D');
        Node1 E = new Node1('E');
        Node1 F = new Node1('F');
        Node1 G = new Node1('G');
        Node1 H = new Node1('H');
        A.left = B;
        A.right = C;
        B.left = D;
        B.right = E;
        E.right = H;
        C.left = F;
        C.right = G;
        return A;
    }

    //二叉树的前序遍历
    public List<Integer> preOrderTraversal1(Node1 root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        list.add(root.value);
        List<Integer> left = preOrderTraversal1(root.left);
        list.addAll(left);
        List<Integer> right = preOrderTraversal1(root.right);
        list.addAll(right);
        return list;
    }

    //二叉树的中序遍历
    public List<Integer> inorderTraversal(Node1 root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        List<Integer> left = inorderTraversal(root.left);
        list.addAll(left);
        list.add(root.value);
        List<Integer> right = inorderTraversal(root.right);
        list.addAll(right);
        return list;
    }

    //二叉树的后序遍历
    public List<Integer> postOrderTraversal(Node1 root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        List<Integer> left = inorderTraversal(root.left);
        list.addAll(left);
        List<Integer> right = inorderTraversal(root.right);
        list.addAll(right);
        list.add(root.value);
        return list;
    }

    //判断两棵树是否相同
    /*
     * 以下代码是错解答
     *
     * */
    //public boolean isSameTree(Node1 root, Node1 root2) {
    //        if ((root != null && root2 == null) || (root == null && root2 != null)) {
    //            return false;
    //        }
    //        if (root.value != root2.value) {
    //            return false;
    //        }
    //        isSameTree(root.left, root2.left);
    //        if (root.left.value != root2.left.value) {
    //            return false;
    //        }
    //        isSameTree(root.right, root2.right);
    //        if (root.right.value != root2.right.value) {
    //            return false;
    //        }
    //        return true;
    //    }

    /*
     * 正确解如下
     * */
    public boolean isSameTree(Node1 root, Node1 root2) {
        if (root == null && root2 == null) {
            return true;
        }
        if (root.value != root2.value) {
            return false;
        }
        if (root == null && root2 != null) {
            return false;
        }
        if (root != null && root2 == null) {
            return false;
        }
        return isSameTree(root.left, root2.left) && isSameTree(root.right, root2.right);
    }


    //另一个树的子树
    public boolean isSubtree(Node1 s, Node1 t) {
        if (s == null || t == null) {
            return false;
        }
        if (isSameTree(s, t)) {
            return true;
        }
        if (isSubtree(s.left, t)) {
            return true;
        }
        if (isSubtree(s.right, t)) {
            return true;
        }
        return false;
    }

    //二叉树的最大深度
    public int maxDepth(Node1 root) {
        if (root == null) {
            return 0;
        }
        int leftHight = maxDepth(root.left);
        int rightHight = maxDepth(root.right);
        if (leftHight > rightHight) {
            return leftHight + 1;
        } else {
            return rightHight + 1;
        }
    }

    //判断一棵二叉树是否是平衡二叉树
    public boolean isBalanced(Node1 root) {
        if (root == null) {
            return false;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.abs(left - right) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    //对称二叉树
    public boolean isSymmetric(Node1 root) {
        if (root == null) {
            return false;
        }
        return isSymmetricchild(root.left, root.right);
    }

    public boolean isSymmetricchild(Node1 leftTree, Node1 rightTree) {
        if (leftTree == null && rightTree != null) {
            return false;
        }
        if (leftTree != null && rightTree == null) {
            return false;
        }
        if (leftTree == null && rightTree == null) {
            return true;
        }
        return (leftTree.value == rightTree.value) &&
                isSymmetricchild(leftTree.left, rightTree.right) &&
                isSymmetricchild(leftTree.right, rightTree.left);
    }

    //非递归实现二叉树的前序遍历
    public void prevorderTriversal(Node1 root) {
        Stack<Node1> stack = new Stack<>();
        Node1 cur = root;
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
//    public void midorderTriversal(Node1 root) {
//        Stack<Node1> stack = new Stack<>();
//        Node1 cur = root;
//        while (cur != null || !stack.empty()) {
//            while (cur != null) {
//                stack.push(cur);
//                cur = cur.left;
//            }
//            cur = cur.left;
//            System.out.print(cur.value + "");
//            cur = cur.right;
//        }
//    }

    //非递归实现二叉树的后序遍历
//    public void lastorderTriversal(Node1 root) {
//        Stack<Node1> stack = new Stack<>();
//        Node1 cur = root;
//        while (cur != null || !stack.empty()) {
//            while (cur != null) {
//                stack.push(cur);
//                cur = cur.left;
//            }
//            cur = stack.pop();
//            cur = cur.right;
//            System.out.println(cur.value + " ");
//        }
//    }
}

