package editor.cn;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class P_Threads_ABCprint {

    static class Printer{

        Lock lock = new ReentrantLock();
        Condition[] conditions;

        volatile int cnt;

        public Printer(){
            conditions = new Condition[3];
            for (int i = 0; i < 3; i++) {
                conditions[i] = lock.newCondition();
            }
            cnt = 0;
        }

        public void print(int idx) throws InterruptedException {
            lock.lock();
            try {
                while (cnt != idx){
                    conditions[idx].await();
                }

                System.out.println(Thread.currentThread().getName() + "1");

                cnt = (cnt + 1) % 3;
                conditions[cnt].signal();
            }finally {
                lock.unlock();
            }
        }
    }

    static class Printer2{
        private volatile int cnt = 0;

        private Object lockObject = new Object();

        public Printer2(){}

        public void print(int idx) throws InterruptedException {
            synchronized (lockObject){
                while (cnt != idx){
                    lockObject.wait();
                }

                System.out.println(Thread.currentThread().getName() + "2");
                cnt = (cnt + 1) % 3;

                lockObject.notifyAll();
            }
        }
    }

    static class Printer3{
        Semaphore[] semaphores;

        public Printer3(){
            semaphores = new Semaphore[3];
            semaphores[0] = new Semaphore(1);
            for (int i = 1; i < 3; i++) {
                semaphores[i] = new Semaphore(0);
            }
        }

        public void print(int idx) throws InterruptedException {
            semaphores[idx].acquire();

            System.out.println(Thread.currentThread().getName() + "3");

            semaphores[(idx + 1) % 3].release();
        }
    }

    static class PrintThread implements Runnable{

        String name;
        Printer printer;
        int idx;

        public PrintThread(Printer p, String n, int i){
            printer = p;
            name = n;
            idx = i;
        }

        @Override
        public void run() {
            try {
                for (int i = 0; i < 10; i++) {
                    printer.print(idx);
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void main(String[] args) {
        Printer printer = new Printer();

        PrintThread a = new PrintThread(printer, "A", 0);
        PrintThread b = new PrintThread(printer, "B", 1);
        PrintThread c = new PrintThread(printer, "C", 2);

        new Thread(a).start();
        new Thread(b).start();
        new Thread(c).start();
    }
}
