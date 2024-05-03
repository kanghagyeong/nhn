public class Quiz04 {
    public static void main(String[] args) {
        Counter3 counter = new Counter3("counter", 10);

        counter.start();
    }

    
}
class Counter3 implements Runnable {
    int maxCount;
    String name;
    Thread thread;
    int count = 0;

    public Counter3 (String name, int maxCount){
        this.name = name;
        this.maxCount = maxCount;
        thread = new Thread(this);
    }

    public void start() {
        thread.start();
    }

    @Override
    public void run() {
        while (count < maxCount) {
            try {
                thread.sleep(1000);
                count++;
                System.out.println(name + " : " + count);
                
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

}
