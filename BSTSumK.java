public class BSTSumK {
    public static void main(String[] args) {
        int[] arr = new int[]{5, 3, 7, 2, 4, 8};
        int k = 9;
        BSTNode root = null;
        for (int i = 0; i < arr.length; i++) {
            root = addNode(root, arr[i]);           
        }
        checkSum(root, root, k);
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

    public static void checkSum(BSTNode head, BSTNode root, int k){
        if(root == null)
            return;
        checkSum(head, root.left, k);
        int diff = k - root.data;
        boolean check = search(head, diff);
        System.out.println(check);
        System.out.println(root.data);
        checkSum(head, root.right, k);
    }

    public static boolean search(BSTNode root, int key) {
        if(root == null) return false;
        else if (key > root.data){
            System.out.println(root.data + " k: " + key);
            return search(root.right, key);
        }
        else if (key < root.data){
            System.out.println(root.data + " k: " + key);
            return search(root.left, key);
        }
        return false;
        
    }
}

