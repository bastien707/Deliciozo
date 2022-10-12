package com.example.demo;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import receiver.MyReceiver;
import sender.MySender;

@SpringBootApplication
public class DemoApplication {
	private static Thread thread(Runnable runnable, boolean daemon) {
		Thread thread = new Thread(runnable);
		thread.setDaemon(daemon);
		thread.start();
		return thread;
	}
	
	public static void main(String[] args) {
		thread(new MySender(), false);
		thread(new MyReceiver(), false);
		thread(new MyReceiver(), false);
	}
}
