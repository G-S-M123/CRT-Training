class Person extends Thread{
    int available = 5;
    int ticket;

    public Person(int ticket) {
        this.ticket = ticket;
    }

    void bookTicket(){
        String name = Thread.currentThread().getName();
        System.out.println("\nHello " + name);
        System.out.println("Hello " + name);
        System.out.println("Hello " + name);

        synchronized (this) {
            if(available >= ticket){
                available = available - ticket;
                System.out.println("Congratulations " + name + ", you booked " + ticket + " tickets" + "\nAvailable tickets: " + available);
            }
            else{
                System.out.println("\nSorry " + name + " only " + available + " tickets are availble");
            }
        }
        System.out.println("\nBye " + name);
        System.out.println("Bye " + name);
        System.out.println("Bye " + name);
    }

    public void run(){
        bookTicket();
    }
}

public class Greet {
    public static void main(String[] args) {
        Person p1 = new Person(3);

        Thread t1 = new Thread(p1);
        Thread t2 = new Thread(p1);
        Thread t3 = new Thread(p1);

        t1.setName("a");
        t2.setName("Somesh");
        t3.setName("Onkar");

        t1.start();
        t2.start();
        t3.start();
    }
}
