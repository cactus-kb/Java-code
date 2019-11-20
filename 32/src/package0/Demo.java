package package0;

public class Demo {
    public static void main(String[] args) {
        Tree tree = new Tree();
        Node root = tree.buildTree();
        tree.midorder(root);
        System.out.println();
        tree.lastorder(root);
        System.out.println();
        tree.levelorderTraversal(root);
        tree.isCompleteTree(root);
    }
}
