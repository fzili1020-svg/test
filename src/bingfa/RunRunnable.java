package bingfa;

public class RunRunnable {
    public static void main(String[] args) {
        MyRunnable mr = new MyRunnable();
        Thread t1 = new Thread(mr, "小赵");
        Thread t2 = new Thread(mr, "小钱");
        Thread t3 = new Thread(mr, "小孙");
        t1.start();
        t2.start();
        t3.start();
    }
}
