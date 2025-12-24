
import java.util.Arrays;

class SortLinkedList{
    public static void main(String[] args) {
        int [][] testCases = {
            {5},
            {1, 2, 3, 4, 5},
            {5, 4, 3, 2, 1},
            {4, 2, 1, 3},
            {3, 3, 1, 2},
            {-1, 5, 3, 4, 0},
            {2, 1}
        };
        for (int[] testCase : testCases) {
            System.out.println("Test Case " + Arrays.toString(testCase));
            Node head = createLinkedList(testCase);
            System.out.println("Input:");
            printList(head);
            head = insertionSortList(head);
            System.out.println("Output: ");
            printList(head);
            System.out.println("--------------------");
        }
    }

    public static Node createLinkedList(int arr[]){
        Node head = new Node(arr[0]);
        Node cur = head;
        for (int i = 1; i < arr.length; i++) {
            cur.next = new Node(arr[i]);
            cur = cur.next;
            
        }
        return head;
    }

    public static void printList(Node head){
        Node cur = head;
        while(cur.next != null){
            System.out.print(cur.data + " -> ");
            cur = cur.next;
        }
        System.out.println(cur.data);
    }

    public static Node insertionSortList(Node head) {

        Node sorted = null;
        Node cur = head;
        while(cur != null){
            Node next = cur.next;
            if(sorted == null){
                sorted = cur;
                sorted.next = null;
            }
            else if(sorted.data > cur.data){
                cur.next = sorted;
                sorted = cur;
            }
            else{
                Node temp = sorted;
                while((temp.next != null) && (temp.next.data < cur.data)){
                    temp = temp.next;
                }
                cur.next = temp.next;
                temp.next = cur;
            }
            cur = next;
        }


        return sorted;
    }
}