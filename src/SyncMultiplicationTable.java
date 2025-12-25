class Print{
    synchronized void printTable(int n){
        for (int i = 1; i <= 10; i++) {
            System.out.println(i*n);
        }
        System.out.println();
    }

}

class Number extends Thread{
    Print S;
    int n;

    public Number(Print s, int n) {
        S = s;
        this.n = n;

    }
    
    public void run(){
        S.printTable(n);
    }
}

public class SyncMultiplicationTable {
    public static void main(String[] args) {
        Print op = new Print();

        Number t1 = new Number(op, 5);
        Number t2 = new Number(op, 7);

        t1.start();
        t2.start();
    }

}
