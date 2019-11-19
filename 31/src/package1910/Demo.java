package package1910;

public class Demo {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        Node root = binaryTree.buildTree();
        binaryTree.postOrderTraversal(root);
        System.out.println();
        System.out.println("========");
        binaryTree.lastorderTriversal(root);
    }


    public static void main6(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        Node root = binaryTree.buildTree();
        binaryTree.inOrderTraversal(root);
        System.out.println();
        System.out.println("========");
        binaryTree.midorderTriversal(root);
    }


    public static void main5(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        Node root = binaryTree.buildTree();
        int len = binaryTree.getLeafSize1(root);
        System.out.println(len);
    }

    public static void main4(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        Node root = binaryTree.buildTree();
        int len = binaryTree.getSize1(root);
        System.out.println(len);
    }

    public static void main3(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        Node root = binaryTree.buildTree();
        binaryTree.postOrderTraversal(root);
    }

    public static void main2(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        Node root = binaryTree.buildTree();
        binaryTree.inOrderTraversal(root);
    }

    public static void main1(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        Node root = binaryTree.buildTree();
        binaryTree.preOrderTraversal(root);
    }
}
