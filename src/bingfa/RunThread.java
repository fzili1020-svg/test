package bingfa;

public class RunThread {
    public static void main(String[] args) {
        Thread t1 = new MyThread();
        Thread t2 = new MyThread();
        Thread t3 = new MyThread();

        t1.setName("小张");
        t2.setName("小王");
        t3.setName("小李");

        t1.start();
        t2.start();
        t3.start();
    }
}
