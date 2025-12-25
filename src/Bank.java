class Account extends Thread{
    static int balance = 5000;
    int amount;

    public Account(int amt) {
        amount = amt;
    }
    

    synchronized void withdraw(){
        String name = Thread.currentThread().getName();
        if((balance-amount) >= 0){
            balance = balance - amount;
            System.out.println("Congratulations " + name + ", You successfully withdrawed " + amount + " rupees.");
        }
        else{
            System.out.println("Sorry " + name + ", there is insufficient " + balance + " balance.");
        }
    }

    public void run(){
        withdraw();
    }
}

public class Bank {
    public static void main(String[] args) {
        Account a1 = new Account(2000);

        Thread t1 = new Thread(a1);
        Thread t2 = new Thread(a1);
            
        Account a2 = new Account(2000);

        Thread t3 = new Thread(a2);
        Thread t4 = new Thread(a2);

        t1.setName("Somesh");
        t2.setName("Onkar");
        t3.setName("Soham");
        t4.setName("Anshul");

        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }

}
