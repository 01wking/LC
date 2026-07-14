package src.lock;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Test {
    private static final Lock lock = new ReentrantLock();
    public static void main(String[] args) {

        LinkedHashMap<Integer,Integer> ma = new LinkedHashMap<>();
        ma.put(1,1);
        ma.put(2,2);
        ma.keySet().iterator().next();


        System.currentTimeMillis();
        try {
            t1();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private  static void t1() throws Exception{
        Thread t1 = new Thread(() -> {
            lock.lock();
            try {
                Thread.sleep(5000); // 持有锁5秒
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            } finally {
                lock.unlock();
            }
        });
        t1.start();
        Thread.sleep(100); // 确保t1先拿到锁

        // 线程2尝试获取锁，1秒后被中断
        Thread t2 = new Thread(() -> {
            try {
                // 可中断地获取锁
                lock.lockInterruptibly();
                System.out.println("t2获取到锁");
                lock.unlock();
            } catch (InterruptedException e) {
                System.out.println("t2被中断，放弃等待"); // 预期执行
            }
        });
        t2.start();
        Thread.sleep(1000); // 等待1秒后中断t2
        t2.interrupt();
    }
}
