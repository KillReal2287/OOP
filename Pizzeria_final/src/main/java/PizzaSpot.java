import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * class for rightly start of pizza spot simulation
 * all threads will run just in time of object construction
 */

public class PizzaSpot {
    private final DataForSystem dataForSystem;
    private final BlockingQueue<Order> ordersQueue;
    private final BlockingQueue<Order> storage;
    private final ExecutorService executorService = Executors.newCachedThreadPool();

    PizzaSpot(DataForSystem dataForSystem){
        this.dataForSystem = dataForSystem;
        ordersQueue = new LinkedBlockingQueue();
        storage = new Storage(dataForSystem.getStorageSize());

        openPizzaSpot();
        startWorkers();

        executorService.shutdown();
    }

    private void openPizzaSpot(){
        executorService.execute(new NewOrders(ordersQueue));
    }

    private void startWorkers(){
        for(int i = 0 ; i< dataForSystem.getCooksCount(); i++) executorService.execute(new Cook(ordersQueue, storage));

        int[] deliveries = dataForSystem.getCapacitiesOfDeliveriesBags();
        for(int i = 0; i< deliveries.length; i++)
            executorService.execute(new Deliveryman(storage, deliveries[i]));
    }
}