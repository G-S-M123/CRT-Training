import java.util.ArrayList;
import java.util.List;

class Channel{
    List<CustomerSubscriber> c = new ArrayList<>();
    String title;
    void subscribe(CustomerSubscriber sub){
        c.add(sub);

    }

    void unsubscribe(CustomerSubscriber sub){
        c.remove(sub);
    }

    void upload(String title){
        this.title = title;
        notifySubscriber();
    }

    void notifySubscriber(){
        for(CustomerSubscriber sub : c){
            sub.update();
        }
    }
}

class CustomerSubscriber{

    String name;
    Channel worldAffairs = new Channel();
    public CustomerSubscriber(String name) {
        this.name = name;
    }
    
    void subscribeChannel(Channel ch){
        worldAffairs = ch;
    }

    void update(){
        System.out.println("\nHello, " + name + "! New Video: " + worldAffairs.title);
    }
}

public class YouTube {
    public static void main(String[] args) {
        Channel op = new Channel();

        CustomerSubscriber cs1 = new CustomerSubscriber("Onkar");
        CustomerSubscriber cs2 = new CustomerSubscriber("Shubham");
        CustomerSubscriber cs3 = new CustomerSubscriber("Amol");
        CustomerSubscriber cs4 = new CustomerSubscriber("Alankar");
        CustomerSubscriber cs5 = new CustomerSubscriber("Ankit");

        op.subscribe(cs1);
        op.subscribe(cs2);
        op.subscribe(cs3);
        op.subscribe(cs4);
        op.subscribe(cs5);

        op.unsubscribe(cs3);

        cs1.subscribeChannel(op);
        cs2.subscribeChannel(op);
        cs3.subscribeChannel(op);
        cs4.subscribeChannel(op);
        cs5.subscribeChannel(op);

        op.upload("INDIA  - CHINA Relations");
    }
}
