public class Quiz03 {

    public static void main(String[] args) {
        Counter1 counter = new Counter1("counter", 10);

        
        counter.start();
    }
}

class Counter1 extends Thread {
    String name;
    int maxCount;
    int count = 0;
    

    public Counter1(String name, int maxCount) {
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