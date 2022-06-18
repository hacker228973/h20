
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class JThread extends Thread {


    JThread(String name) {
        super(name);
    }

    public void run() {

        System.out.printf("%s started... \n", Thread.currentThread().getName());
        for (int i = 0; i < 1000; i++) {
            Program.nextCounter();
        }

        System.out.printf("%s finished... \n", Thread.currentThread().getName());
    }

    @Override
    public String toString() {
        return getName();
    }
}

class Program {
    static class MyRunnable implements Runnable{
        @Override
        public void run() {

        }
    }
    static int COUNTER = 0;

    public static void main(String[] args) {
        ExecutorService executorService= Executors.newFixedThreadPool(10);

        System.out.println("Main thread started...");

        for(int i = 0;i<10;i++){
            executorService.execute(new JThread("Джо Байден"));
        }
        executorService.shutdown();
        try {
            executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        } catch (InterruptedException e) {
            System.out.println("Exception "+e);
        }

//            }
//
//        }
        System.out.println(COUNTER);


        System.out.println("Main thread finished...");
    }



    public static void nextCounter() {

        COUNTER++;
    }

}