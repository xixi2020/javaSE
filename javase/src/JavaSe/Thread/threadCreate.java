package JavaSe.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * 用不同的方式创建线程
 */
public class ThreadCreate {
    public static void main(String[] args) {

        //Thread
        Thread thread01 = new Thread("thread01") {
            @Override
            public void run() {
                System.out.println("thread类创建方式");
            }
        };
        thread01.start();

        new Thread("thread00"){
            @Override
            public void run() {
                System.out.println("thread内部类");
            }
        }.start();

        //runnable
        Thread runnble = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("runnable创建方式1");
            }
        });
        runnble.start();

        Runnable  runnable = () -> System.out.println("Runnble创建");

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("runnable创建方式2");
            }
        }, "thread02").start();
        //lambda 这里是runnble不是thread，省略了run()
        new Thread(() -> System.out.println("runnabble上同"),"tt").start();
        //这里是使用内部类
        new Thread("t1"){
            @Override
            public void run() {
                System.out.println("Thread");
            }
        }.start();
        //Future来接收一(个返回值,主要是异步计算结果，需要一个futureTask来接手线程计算的结果
        FutureTask futureTask = new FutureTask<>(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                return 1;
            }
        });
        new Thread(futureTask, "thread03").start();
        try {
            Object o = futureTask.get();
            System.out.println(o);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }

    }
}
