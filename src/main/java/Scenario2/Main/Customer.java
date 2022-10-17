package Scenario2.Main;

import Scenario2.sender.CustomerSender;

import java.io.Serializable;
import java.util.Date;


public class Customer implements Serializable {
    private int id;
    private String surname;
    private String firstname;
    private String address;
    private String phone;
    private Date dateFirstOrder;

    private static int nextCustomerId=1;

    public Customer(String surname, String firstname, String address, String phone, Date dateFirstOrder) {
        this.surname = surname;
        this.firstname = firstname;
        this.address = address;
        this.phone = phone;
        this.dateFirstOrder = dateFirstOrder;
        this.id = nextCustomerId;
        nextCustomerId++;
    }

    public int getId() {
        return id;
    }

    public String getSurname() {
        return surname;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public Date getDateFirstOrder() {
        return dateFirstOrder;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setDateFirstOrder(Date dateFirstOrder) {
        this.dateFirstOrder = dateFirstOrder;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "surname='" + surname + '\'' +
                ", firstname='" + firstname + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", dateFirstOrder=" + dateFirstOrder +
                '}';
    }

    private static Thread thread(Runnable runnable, boolean daemon) {
        Thread thread = new Thread(runnable);
        thread.setDaemon(daemon);
        thread.start();
        return thread;
    }
    public void sendDemand(OrderAndCustomer demand){
        thread(new CustomerSender(demand), false);
    }
}