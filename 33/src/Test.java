class Node{
    char value;
    Node left;
    Node right;

    public Node(char value) {
        this.value = value;
    }
}

public class Test {

    public int maxdepth(Node root) {
        if (root == null) {
            return 0;
        }
        int lefth = maxdepth(root.left);
        int righh = maxdepth(root.right);
        if (lefth > righh) {
            return lefth + 1;
        } else {
            return righh + 1;
        }
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
        Node lnode = ancester(root.left, p, q);
        Node rnode = ancester(root.right, p, q);
        if (lnode != null && rnode != null) {
            return root;
        }
        if (lnode != null) {
            return lnode;
        }
        if (rnode != null) {
            return rnode;
        }
        return null;
    }

    //二叉搜索树转换成排序双向链表
    public Node Convert(Node root) {
        midorder(root);
        Node head = root;
        while (head != null && head.left != null) {
            head = head.left;
        }
        return head;
    }

    public Node prev = null;

    private void midorder(Node rt) {
        if (rt == null) {
            return;
        }
        midorder(rt.left);
        rt.left = prev;
        if (prev != null) {
            prev.right = rt;
        }
        prev = rt;
        midorder(rt.right);
    }

    //从前序与中序遍历序列构造二叉树
//    public Node buildTree(int[] preorder, int[] inorder) {
//        if (preorder.length == 0 || inorder.length == 0) {
//
//        }
//    }
//
//    public Node buildTree(int[] preorder, int preIndex)


    /*
    *
    public int preIndex = 0;
    public TreeNode buildTreeChild(int[] preorder,int[] inorder,int inbegin,
    int inend) {
        //肯定会没有左树 没有右树
        if(inbegin > inend) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preIndex]);
        //找到root在中序遍历数组当中的位置
        int rootIndex = findInorderIndex(inorder,inbegin,inend,preorder[preIndex]);
        if(rootIndex == -1) {
            return null;
        }
        preIndex++;//3

        root.left = buildTreeChild(preorder,inorder,inbegin,rootIndex-1);

        root.right = buildTreeChild(preorder,inorder,rootIndex+1,inend);

        return root;
    }

    public int findInorderIndex(int[] inorder,int inbegin,int inend,int val) {
        for(int i = inbegin;i <= inend;i++) {
            if(inorder[i] == val){
                return i;
            }
        }
        return -1;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {

        if(preorder.length == 0 || inorder.length == 0) {
            return null;
        }

       return buildTreeChild(preorder,inorder,0,inorder.length-1);
    }
}
    * */


    //二叉树创建字符串（前序）
    public String treeStr(Node root) {
        StringBuilder  sb = new StringBuilder();
        treestrchilde(root, sb);
        return sb.toString();
    }
    public void treestrchilde(Node root, StringBuilder sb) {
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
            treestrchilde(root.left, sb);
            sb.append(")");
        }
        if (root.right == null) {
            return;
        } else {
            sb.append("(");
            treestrchilde(root.right,sb);
            sb.append(")");
        }
    }

}
