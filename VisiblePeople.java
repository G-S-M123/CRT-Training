
import java.util.Arrays;
import java.util.Stack;



public class VisiblePeople {
    public static void main(String[] args) {
        int height[] = {10, 6, 8, 5, 11, 9};
        int result[] = new int[height.length];
        
        Stack<Integer> stack = new Stack<>();
        for (int i = height.length - 1; i >= 0; i--){
            while(!stack.isEmpty() &&  stack.peek() < height[i]){
                stack.pop();
                result[i]++;

            }
            if (!stack.isEmpty()) {
                result[i]++;
            }
            stack.push(height[i]);
        }
        System.out.println(Arrays.toString(result));
    }
}
