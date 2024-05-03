public class Quiz02 {

    public static void main(String[] args) {
        Counter counter = new Counter("counter", 10);
        Counter counter2 = new Counter("counter2", 10);

        Thread thread = new Thread(counter);
        Thread thread2 = new Thread(counter2);

        thread.start();
        thread2.start();
    }
}

class Counter implements Runnable {
    String name;
    int maxCount;
    int count = 0;

    public Counter(String name, int maxCount) {
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
            //
        }
    }
}