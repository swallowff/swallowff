package cn.swallow.platform.practice.concurrent.callable;

import cn.swallow.platform.core.util.GsonHelper;
import cn.swallow.platform.practice.concurrent.callable.entity.MsgResult;
import cn.swallow.platform.practice.concurrent.callable.threads.CallableThread;
import javafx.util.Builder;

import java.util.concurrent.*;

/**
 * @author shenyu
 * @create 2019/3/29
 */
public class StartMain {
    public static ExecutorService executorService = new ThreadPoolExecutor(5,10,0L, TimeUnit.MILLISECONDS,new LinkedBlockingDeque<>());

    public static void main(String[] args) throws Exception{
        Callable<MsgResult> callable = new CallableThread();
        Future<MsgResult> future = executorService.submit(callable);
        System.out.println(GsonHelper.toJson(future.get()));

//        FutureTask<MsgResult> task = new FutureTask<MsgResult>(new CallableThread());
//        new Thread(task,"有返回的线程池").start();
//        MsgResult result = task.get();
//        System.out.println(result);
    }
}
