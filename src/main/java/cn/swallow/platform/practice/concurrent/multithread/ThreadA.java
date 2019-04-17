package cn.swallow.platform.practice.concurrent.multithread;

/**
 * @author shenyu
 * @create 2019/4/12
 */
public class ThreadA implements Runnable{

    @Override
    public void run() {
        System.out.println("1开始执行了---");
        int i = 0;
        try {
            while (i<5000){
                System.out.println("1正在执行");
                synchronized (ClickCount.class){
                    ClickCount.count++;
                }
                Thread.sleep(0);
                i++;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("1结束执行---");    }
}
