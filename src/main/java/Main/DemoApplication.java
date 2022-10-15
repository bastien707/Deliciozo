package Main;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import receiver.AssistantReceiver;
import receiver.CookerReceiver;
import sender.CustomerSender;

import java.util.Scanner;

@SpringBootApplication
public class DemoApplication {
	private static Thread thread(Runnable runnable, boolean daemon) {
		Thread thread = new Thread(runnable);
		thread.setDaemon(daemon);
		thread.start();
		return thread;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Assistant a1 = new Assistant(0);
		Assistant a2 = new Assistant(1);

		Cooker cooker1 = new Cooker();
		Cooker cooker2 = new Cooker();
		Cooker cooker3 = new Cooker();

		DeliveryMan d1= new DeliveryMan(1,2);
		DeliveryMan d2= new DeliveryMan(3,3);

		Customer c1 = a1.createCustomer(sc);
		Customer c2 = a1.createCustomer(sc);
		Customer c3 = a1.createCustomer(sc);
		Customer c4 = a1.createCustomer(sc);
		Order o1 = a1.createOrder(sc,1, c1);
		Order o2 = a1.createOrder(sc,2, c2);
		Order o3 = a1.createOrder(sc,3, c3);
		Order o4 = a1.createOrder(sc,4, c4);
		OrderAndCustomer demand1 = new OrderAndCustomer(c1, o1);
		OrderAndCustomer demand2 = new OrderAndCustomer(c2, o2);
		OrderAndCustomer demand3 = new OrderAndCustomer(c3, o3);
		OrderAndCustomer demand4 = new OrderAndCustomer(c4, o4);

		a1.listenCustomerDemand(1);
		a2.listenCustomerDemand(2);
		cooker1.listenAssistantDemand();
		cooker2.listenAssistantDemand();
		cooker3.listenAssistantDemand();
		d1.listenCookerDemand();
		d2.listenCookerDemand();

		c1.sendDemand(demand1);
		c2.sendDemand(demand2);
		c3.sendDemand(demand3);
		c4.sendDemand(demand4);

	}
}
