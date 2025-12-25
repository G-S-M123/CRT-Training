import java.util.InputMismatchException;

class Bus extends Thread{
    int ticket = 3;
    int seats;
    String name;

    public Bus(String name, int seats) {
        this.seats = seats;
    }
    
    public void book(){
        try{
            name = Thread.currentThread().getName();
            System.out.println("\nHello " + name + " Welcome to Bus Services.");
            
            System.out.print("\nNumber of tickets you want to book " + name + ": " + seats);
            if((ticket-seats) >= 0){
                System.out.println(name + ", there are " + ticket + " available.");
                ticket = ticket - seats;
                System.out.println("\nCongratulations " + name + ", You successfully booked " + seats + " tickets.");
            }
            else{
                System.out.println("\nSorry " + name + ", there are only " + ticket + " tickets available.");
            }

        }
        catch(InputMismatchException e){
            System.err.println("\nSeats cannot be characters");
        }
    }

    public void run(){
        book();
    }
    
}

public class BookMulti {
    public static void main(String[] args) {
        Bus b1 = new Bus("aa", 3);

        Thread t1 = new Thread(b1);
        Thread t2 = new Thread(b1);
        Thread t3 = new Thread(b1);

        t1.setName("x");
        t2.setName("y");
        t3.setName("z");

        t1.start();
        t2.start();
        t3.start();
        
        System.out.println("\n\nDone");

    }
}
