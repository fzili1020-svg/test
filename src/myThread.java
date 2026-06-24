public class myThread extends Thread{
    public void run(){
        for(int i = 0; i < 50; i++){
            System.out.println(getName() + "正在第" + i +"次执行");
        }
    }
}
