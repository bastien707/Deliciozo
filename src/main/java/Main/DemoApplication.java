package Main;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import receiver.AssistantReceiver;
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
		Assistant a1 = new Assistant(0, null);
		Customer c1 = a1.createCustomer(sc);
		//a1.createOrder(sc,0, c1);
		a1.listenCustomerDemand();
		c1.sendDemand();


		//thread(new MySender(), false);
		//thread(new MyReceiver(), false);
		//thread(new MyReceiver(), false);
	}
}
