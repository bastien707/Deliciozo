package Scenario3;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class Asynchronous {
    static class Cuisinier implements Callable<Boolean> {
        int time_to_prepare;
        String commande;

        public Cuisinier(String commande,int time_to_prepare) {
            this.time_to_prepare = time_to_prepare;
            this.commande = commande;
        }

        @Override
        public Boolean call() throws Exception {
            System.out.println("Nouvelle commande: "+commande);
            TimeUnit.SECONDS.sleep(time_to_prepare);
            System.out.println(commande+" - prete!");
            return true;
        }
    }

    public void launchAsynchronous(){
        ExecutorService pool = Executors.newFixedThreadPool(3);
        try{
            Callable<Boolean> result = new Cuisinier("Burger", 8);
            Callable<Boolean> result2 = new Cuisinier("Salade Cesar", 3);
            Callable<Boolean> result3 = new Cuisinier("Cote de boeuf", 16);
            List<Callable<Boolean>> listeThreadsAexecuter = Arrays.asList(result, result2, result3);
            List<Future<Boolean>> listcuisinier = pool.invokeAll(listeThreadsAexecuter);
        }
        catch (Exception e) {
            System.out.println("L'exécution des threads ne s'est pas bien passée " + e.getMessage());
        } finally {
            if (pool != null)
                pool.shutdown();
        }
    }
}
