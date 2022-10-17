package Scenario3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

class PizzaPreparation implements Callable<Customer>{

    private Customer customerToHandle;
    private ArrayList<Customer> customersList;

    private int idCooker;

    public PizzaPreparation(Customer customerToHandle, int id) {
        this.idCooker = id;
        this.customerToHandle = customerToHandle;
    }

    public PizzaPreparation(ArrayList<Customer> customersList, int id) {
        this.idCooker = id;
        this.customersList = customersList;
    }

    @Override
    public Customer call() throws Exception {
        System.out.println("Cuisinier "+ idCooker + " commence la preparation de la pizza de "+customerToHandle.getNom());
        Thread.sleep(customerToHandle.getPizza().getTimeToCook());
        System.out.println("Pizza " + customerToHandle.getPizza().getFlavour() + " de " + customerToHandle.getNom()+" prete !");
        Cooker.sendToDeliver(customerToHandle);
        return customerToHandle;
    }

    public void preparePizza(){
        ExecutorService pool = Executors.newFixedThreadPool(2);
        try{
            Callable<Customer> result1 = new PizzaPreparation(customersList.get(0), idCooker);
            Callable<Customer> result2 = new PizzaPreparation(customersList.get(1), idCooker);
            List<Callable<Customer>> listePizzaAPreparer = Arrays.asList(result1, result2);
            List<Future<Customer>> listePizzaPrete = pool.invokeAll(listePizzaAPreparer);
            System.out.println("Cuisinier "+ idCooker+ " a fini de préparer ses commandes");
        }
        catch (Exception e) {
            System.out.println("L'exécution des threads ne s'est pas bien passée " + e.getMessage());
        } finally {
            if (pool != null)
                pool.shutdown();
        }
    }

}
