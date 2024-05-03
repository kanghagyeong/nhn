import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Quiz05 {
    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(3);

        pool.execute(new Counter4("counter", 5));
        pool.execute(new Counter4("gkrud", 5));
        pool.execute(new Counter4("gmlwns", 5));
    }
}

class Counter4 implements Runnable {
    String name;
    int maxCount;
    int count = 0;

    public Counter4(String name, int maxCount) {
        this.name = name;
        this.maxCount = maxCount;
    }

    @Override
    public void run() {
        try {
            while (count < maxCount) {
                Thread.sleep(1000);
                count++;
                System.out.println(name + " : " + count);
            }

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
