import java.util.Scanner;

public class QueryQue {
    public static void main(String[] args) {
        int n, q, sum = 0;
        
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter n: ");
            n = scanner.nextInt();

            System.out.print("Enter q: ");
            q = scanner.nextInt();

            int A[] = new int [n];
            for (int i = 0; i < n; i++) {
                System.out.print("Enter " + i + " element: ");
                A[i] = scanner.nextInt();
            }

            int a, l, r;
            for (int i = 0; i < q; i++) {
                System.out.print("Enter Query " + (i + 1) + ": ");
                a = scanner.nextInt();

                System.out.print("Enter l for Query " + (i + 1) + ": ");
                l = scanner.nextInt();

                System.out.print("Enter r for Query " + (i + 1) + ": ");
                r = scanner.nextInt();

                if(a == 1){
                    for (int j = l; j <= r; j++) {
                        A[j] = (j - l + 1) * A[l];
                    }
                }
                else{
                    for (int j = l; j <= r; j++) {
                        sum = sum + A[j];
                    }
                }
            }
        }
        System.out.println("Sum: " + sum);
    }

    
}
