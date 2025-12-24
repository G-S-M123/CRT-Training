
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Interleave {

    public static void interleave(Queue<Integer> q) {
        ArrayList<Integer> arr = new ArrayList<>();
        Integer element;
        System.out.println("Input: " + q.toString());
        while ((element = q.poll()) != null) {
            arr.add(element);
        }
        int mid = arr.size() / 2;
        for (int i = 0; i < arr.size() / 2; i++) {
            q.offer(arr.get(i));
            q.offer(arr.get(mid++));
        }
        System.out.println("Output: " + q.toString());
    }

    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= 6; i++) {
            q.offer(i);
        }
        interleave(q);
    }
}
