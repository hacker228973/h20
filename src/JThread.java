import com.sun.deploy.panel.JHighDPITable;

import java.util.ArrayList;

class JThread extends Thread {
    static int counter = 0;

    JThread(String name) {
        super(name);
    }

    public void run() {

        System.out.printf("%s started... \n", Thread.currentThread().getName());
        for (int i = 0; i < 1000; i++) {
            counter = Program.nextCounter(counter);

        }
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            System.out.println("Thread has been interrupted");
        }
        System.out.printf("%s finished... \n", Thread.currentThread().getName());
    }

    @Override
    public String toString() {
        return getName();
    }
}

class Program {

    public static void main(String[] args) {

        Thread[] ThreadList = new Thread[10];
        System.out.println("Main thread started...");
//        for(int i=1; i <= 10; i++)
//            new JThread("JThread " + i).start();
//        JThread t = new JThread("JThread 1");
//        t.start();
//        JThread s = new JThread("JThread 2");
//        s.start();

        for (int i = 0; i < 10; i++) {
//            JThread k = new JThread("JThread "+i);
            ThreadList[i] = new JThread("JThread " + i);
            ;
            ThreadList[i].start();
        }

        for (int i = 0; i < 10; i++) {
            try {
                ThreadList[i].join();
                if (i == 9) {
                    System.out.println(JThread.counter);
                }
            } catch (InterruptedException e) {

                System.out.printf("%s has been interrupted", ThreadList[i].getName());
            }

        }

//        try {
//            t.join();
//        } catch (InterruptedException e) {
//
//            System.out.printf("%s has been interrupted", t.getName());
//        }

        System.out.println("Main thread finished...");
    }

    public static int nextCounter(int counter) {
        return counter++;
    }
}