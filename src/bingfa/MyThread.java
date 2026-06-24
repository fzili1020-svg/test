package bingfa;

public class MyThread extends Thread{
    @Override
    public void run(){
        for (int i = 0; i < 10; i++) {
            System.out.println(getName() + "正在执行");
        }
    }

}
