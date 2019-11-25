
class Node {
    char value;
    Node left;
    Node right;

    public Node(char value) {
        this.value = value;
    }
}

public class BTree {

    //二叉树的前序遍历
    public void first(Node root) {
        if (root == null) {
            return;
        }
        System.out.println(root.value + " ");
        first(root.left);
        first(root.right);
    }

    //二叉树的中序遍历
    public void mid(Node root) {
        if (root == null) {
            return;
        }
        mid(root.left);
        System.out.println(root.value + " ");
        mid(root.right);
    }

    //二叉树的后序遍历
    public void last(Node root) {
        if (root == null) {
            return;
        }
        last(root.left);
        last(root.right);
        System.out.println(root.value + " ");
    }

    //检查两棵树是否相同
    public boolean isSameTree(Node root, Node root2) {
        if (root == null && root2 == null) {
            return true;
        }
        if (root.value != root2.value) {
            return false;
        }
        if (root != null && root2 == null) {
            return false;
        }
        if (root == null && root2 != null) {
            return false;
        }
        return isSameTree(root.left, root2.left) && isSameTree(root.right, root2.right);
    }

    //另一棵树的子树
    public boolean isSubtree(Node s, Node t) {
        if (s == null || t == null) {
            return false;
        }
        if (isSameTree(s,t)) {
            return true;
        }
        if (isSubtree(s.left, t)) {
            return true;
        }
        if (isSubtree(s.right, t)) {
            return  true;
        }
        return  false;
    }

    //二叉树最大深度
    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }
        int lefth = maxDepth(root.left);
        int righth = maxDepth(root.right);
        if (lefth > righth) {
            return lefth + 1;
        } else {
            return righth + 1;
        }
    }

    //判断一棵二叉树是否是平衡二叉树
    public boolean isbalanced(Node root) {
        if (root == null) {
            return false;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.abs(left - right) <= 1 && isbalanced(root.left) && isbalanced(root.right);

    }

    //对称二叉树
    public boolean isSymmetric(Node root) {
        if (root == null) {
            return false;
        }
        return isSymmetricchild(root.left, root.right);
    }
    public boolean isSymmetricchild(Node leftTree, Node rightTree) {
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

    //给定一个二叉树，找到该树中指定节点的最近公共祖先
    public Node ancester(Node root, Node p, Node q) {
        if (root == null) {
            return null;
        }
        if (root == p) {
            return root;
        }
        if (root == q) {
            return root;
        }
        Node le = ancester(root.left, p, q);
        Node ri = ancester(root.right, p, q);
        if (le != null && ri != null) {
            return root;
        }
        if (le != null) {
            return le;
        }
        if (ri != null) {
            return ri;
        }
        return null;
    }
}
