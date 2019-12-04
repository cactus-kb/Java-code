public class Test {
    public static void main(String[] args) {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        int[] arr = new int[] {10,7,8,2,11,9,15};
        for (int i = 0; i < arr.length; i++) {
            binarySearchTree.insert(arr[i]);
        }
        binarySearchTree.inOrder(binarySearchTree.root);
        System.out.println();
        binarySearchTree.prevOrder(binarySearchTree.root);
        System.out.println();
        try{
            BinarySearchTree.Node ret = binarySearchTree.search(10);
            System.out.println(ret.val);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        System.out.println();
        binarySearchTree.remove(8);
        binarySearchTree.inOrder(binarySearchTree.root);
    }
}
