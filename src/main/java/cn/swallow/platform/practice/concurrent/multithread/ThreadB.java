package cn.swallow.platform.practice.concurrent.multithread;

/**
 * @author shenyu
 * @create 2019/4/12
 */
public class ThreadB implements Runnable{

    @Override
    public void run() {
        System.out.println("2开始执行了---");
        int i = 0;
        try {
            while (i<5000){
                System.out.println("2正在执行");
                Thread.sleep(0);
                synchronized (ClickCount.class){
                    ClickCount.count++;
                }
                i++;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("2结束执行---");
    }
}
