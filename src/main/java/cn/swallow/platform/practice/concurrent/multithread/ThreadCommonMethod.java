package cn.swallow.platform.practice.concurrent.multithread;

/**
 * @author shenyu
 * @create 2019/4/12
 */
public class ThreadCommonMethod {

    public static void main(String[] args) throws Exception{
        Thread threadA = new Thread(new ThreadA());
        Thread threadB = new Thread(new ThreadB());
        threadA.start();
        threadB.start();
        threadA.join();
        threadB.join();
        System.out.println("finalCount: "+ClickCount.count);

    }


}
