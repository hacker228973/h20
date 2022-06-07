

class JThread extends Thread {


    JThread(String name) {
        super(name);
    }

    public void run() {

        System.out.printf("%s started... \n", Thread.currentThread().getName());
        for (int i = 0; i < 1000; i++) {
            Program.COUNTER = Program.nextCounter(Program.COUNTER);

        }

        System.out.printf("%s finished... \n", Thread.currentThread().getName());
    }

    @Override
    public String toString() {
        return getName();
    }
}

class Program {
    static int COUNTER = 0;

    public static void main(String[] args) {

        Thread[] ThreadList = new Thread[10];
        System.out.println("Main thread started...");


        for (int i = 0; i < 10; i++) {

            ThreadList[i] = new JThread("JThread " + i);
            ;
            ThreadList[i].start();
        }

        for (int i = 0; i < 10; i++) {
            try {
                ThreadList[i].join();

            } catch (InterruptedException e) {

                System.out.printf("%s has been interrupted", ThreadList[i].getName());
            }

        }
        System.out.println(COUNTER);


        System.out.println("Main thread finished...");
    }

    public static int nextCounter(int counter) {
        return counter++;
    }
}