package JavaSe.juc.rLock;

import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * 实现哲学家用餐的问题：使用reentrantLock
 */
public class PhilosopherEating {
    public static void main(String[] args) {
        Chopsticks c1 = new Chopsticks("c1");
        Chopsticks c2 = new Chopsticks("c2");
        Chopsticks c3 = new Chopsticks("c3");
//        Chopsticks c4 = new Chopsticks("c4");
        Philosopher philosopher01 = new Philosopher(c1,c2,"ajmd");
        Philosopher philosopher02 = new Philosopher(c2,c3,"lk");
        Philosopher philosopher03 = new Philosopher(c3,c1,"flyd");
        philosopher01.start();
        philosopher02.start();
        philosopher03.start();

    }



}

/**
 * 筷子类使用锁
 */
class Chopsticks extends ReentrantLock {
    private String name;

    public Chopsticks(String name) {
        this.name = name;
    }

}

/**
 * 规定哲学家用餐行为
 */
class Philosopher extends Thread{

    //需要得到两只筷子吃饭
    Chopsticks left;
    Chopsticks right;

    String name;


    public Philosopher( Chopsticks left, Chopsticks right, String name) {
        this.left = left;
        this.right = right;
        this.name = name;
    }

    @Override
    public void run() {
        //一直尝试获取一双筷子，否者不吃饭
        while (true){
            //获取左筷子
            if (left.tryLock()){
                try {
                    if (right.tryLock()){
                        try {
                            System.out.println(name + "在吃饭");
                        } finally {
                            right.unlock();
                        }
                    }
                }finally {
                    left.unlock();
                }
            }
        }
    }
}