package Scenario3;

import Scenario3.messageBrokers.AssistantReceiver;
import Scenario3.messageBrokers.CookerReceiver;
import Scenario3.messageBrokers.CustomerSender;
import Scenario3.messageBrokers.DeliverReceiver;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;

@SpringBootApplication
public class Main {
    private static Thread thread(Runnable runnable, boolean daemon) {
        Thread thread = new Thread(runnable);
        thread.setDaemon(daemon);
        thread.start();
        return thread;
    }

    public static void main(String[] args) {
        Pizza fromage = new Pizza(8000, "fromage");
        Pizza thon = new Pizza(10000, "thon");
        Pizza legume = new Pizza(4000, "legume");
        Pizza viande = new Pizza(9000, "viande");

        Customer c1 = new Customer("Joel", fromage);
        Customer c2 = new Customer("Julien", legume);
        Customer c3 = new Customer("Bastien", viande);
        Customer c4 = new Customer("Gilles", thon);
        ArrayList<Customer> customerList1 = new ArrayList<Customer>();
        customerList1.add(c1);
        customerList1.add(c2);
        ArrayList<Customer> customerList2 = new ArrayList<Customer>();
        customerList2.add(c3);
        customerList2.add(c4);

        Assistant a1 = new Assistant(customerList1);
        Assistant a2 = new Assistant(customerList2);
        a1.listenCustomerDemand();
        a2.listenCustomerDemand();

        Deliver d1 = new Deliver();
        Deliver d2 = new Deliver();
        d1.listenCookerDemand();
        d2.listenCookerDemand();

        thread(new CustomerSender(customerList1,0), false);
        thread(new CustomerSender(customerList2,1), false);


        thread(new CookerReceiver(3), false);
        thread(new CookerReceiver(4), false);


    }
}
