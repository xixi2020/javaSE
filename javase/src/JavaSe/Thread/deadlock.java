package JavaSe.thread;

/**
 *
 * 这里模拟一个死锁
 */
public class DeadLock {

    //创建两个互斥的资源
    static Object resource01 = new Object() ;
    static Object resource02 = new Object();


    public static void main(String[] args) {

        Thread t1 = new Thread("01"){
            @Override
            public void run() {
                synchronized (resource01){
                    try {
                        System.out.println("t1获取到了资源1");
                        //防止t1在t2获取锁之前就执行完成,确保t2拿到资源2
                        sleep(2000);
                        synchronized (resource02){
                            System.out.println("t1获取到了资源2");
                        }
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        };
        //匿名内部类和lambda的方式去启动线程:这里是接受runnable任务
        new Thread(new Runnable() {
            @Override
            public void run() {
                // 线程2：占用资源2 ，请求资源1
                synchronized (resource02) {

                    try {
                        System.out.println("线程2已经占用了资源2，开始请求资源1");
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    synchronized (resource01) {
                        System.out.println("线程2已经占用了资源1");
                    }
                }
            }
        }).start();
        //这里都是继承thread的方式
        Thread t2 = new Thread("t2"){
            public void run() {
                synchronized (resource02){
                    try {
                        System.out.println("t2获取到了资源2");
                        sleep(2000);
                        synchronized (resource02){
                            System.out.println("t2获取到了资源1");
                        }
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        };
        t1.start();
        t2.start();
    }




}


