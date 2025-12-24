public class BSTEx {
    public static void main(String[] args) {
        int arr[] = {15, 8, 23, 5, 12, 18, 30, 6, 1, 10, 17, 20, 27, 52};
        BSTNode root = createTree(arr);
        inorder(root);

    }
    public static BSTNode addNode(BSTNode root, int data) {
        if(root == null){
            return new BSTNode(data);
        }
        else if (root.data < data){
            root.right = addNode(root.right, data);
        }
        else{
            root.left = addNode(root.left, data);
        }
        return root;
    }
    public static BSTNode createTree(int arr[]){
        BSTNode root = null;
        for (int i = 0; i < arr.length; i++) {
            root = addNode(root, arr[i]);           
        }
        return root;
    }
    public static void inorder(BSTNode root){
        if(root == null)
            return;
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }
}
