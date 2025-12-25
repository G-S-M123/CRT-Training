
import java.util.InputMismatchException;
import java.util.Scanner;

class Bus1 {
    int ticket = 3;
    Scanner sc = new Scanner(System.in);
    public void book(String name){
        try{
            System.out.println("\nHello " + name);
            System.out.println("There are " + ticket + " available.");
            System.out.print("Enter Number of tickets you want to book: ");
            int seats = sc.nextInt();
            if((ticket-seats) >= 0){
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
    int getAvailableTicket(){
        return ticket;
    }

}


public class BookSingle {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        Bus1 b = new Bus1();
        while(b.getAvailableTicket() > 0){
            System.out.println("\n\nWelcome to RCOEM Bus Services\n");
            System.out.print("\nEnter you name: ");
            String name = sc.next();

            b.book(name);
        }
        System.out.println("\nThere are no more seats available.");
        sc.close();
    }
}
