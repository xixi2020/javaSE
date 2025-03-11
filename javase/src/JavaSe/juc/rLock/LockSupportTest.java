package JavaSe.juc.rLock;

import java.util.concurrent.locks.LockSupport;

/**
 * 使用LockSupport来实现等待唤醒机制
 * AQS线程原语LockSupport.park()和 LockSupport.unpark()实现线程的阻塞和唤醒的。
 */
public class LockSupportTest {
    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("A被阻塞");
                LockSupport.park();
                System.out.println("A被B释放");
            }
        }, "A");
        thread.start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("B开始释放A");
                //这里是指定要释放的线程
                LockSupport.unpark(thread);
            }
        },"B").start();

    }
}
