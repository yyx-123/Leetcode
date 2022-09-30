package editor.cn;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class P_Thread_MyBQ {

    static class MyBQ{
        int capacity;
        volatile int size;
        Lock putlock = new ReentrantLock(), getLock = new ReentrantLock();
        Condition notFull = putlock.newCondition(), notEmpty = getLock.newCondition();
        Deque<Integer> q;

        MyBQ(int c){
            capacity = c;
            q = new LinkedList<>();
            size = 0;
        }

        public void put(int i){
            putlock.lock();
            try {
                while (size == capacity){
                    notFull.await();
                }

                q.offerLast(i);
                size++;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                putlock.unlock();
            }

            if (size > 0){
                signalNotEmpty();
            }
        }

        private void signalNotEmpty() {
            getLock.lock();
            try {
                notEmpty.signalAll();
            }finally {
                getLock.unlock();
            }
        }

        public int get(){
            Integer integer;

            getLock.lock();
            try {
                while (size == 0){
                    notEmpty.await();
                }

                integer = q.pollFirst();
                size--;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                getLock.unlock();
            }
            if (size < capacity){
                signalNotFull();
            }
            return integer;
        }

        private void signalNotFull() {
            putlock.lock();
            try {
                notFull.signalAll();
            }finally {
                putlock.unlock();
            }
        }

    }

    static class Producer implements Runnable{
        MyBQ bq;
        Random random;
        Producer(MyBQ q){
            bq = q;
            random = new Random();
        }
        public void produce() throws InterruptedException {
            int i = random.nextInt(20);
            Thread.sleep(500);

            bq.put(i);
            System.out.println(Thread.currentThread().getName() + " produced " + i);
            System.out.println(bq.q);
        }

        @Override
        public void run() {
            for (int i = 0; i < 5; i++) {
                try {
                    produce();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    static class Consumer implements Runnable{
        MyBQ bq;

        Consumer(MyBQ q){
            bq = q;
        }

        public void consume() throws InterruptedException {
            Thread.sleep(2000);
            int i = bq.get();


            System.out.println(Thread.currentThread().getName() + " consumed " + i);
            System.out.println(bq.q);
        }

        @Override
        public void run() {
            for (int i = 0; i < 5; i++) {
                try {
                    consume();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public static void main(String[] args) {
        MyBQ bq = new MyBQ(5);

        new Thread(new Producer(bq), "producer1").start();
        new Thread(new Producer(bq), "producer2").start();
        new Thread(new Consumer(bq), "consumer1").start();
        new Thread(new Consumer(bq), "consumer2").start();
    }
}
