package editor.cn;

public class P_Thread_12A34B {

    static class Printer{
        private char[] chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
        
        private volatile int cnt = 0;
        
        public void print(int idx, int num) throws InterruptedException {
            synchronized (this){
                while (cnt != idx){
                    wait();
                }
                if (idx == 0){
                    System.out.println(Thread.currentThread().getName() + ": " + (2 * num - 1) + "" + (2 * num));
                }else{
                    System.out.println(Thread.currentThread().getName() + ": " + chars[num - 1]);
                }
                cnt = (cnt + 1) % 2;
                
                notifyAll();
            }
        }
    }

    public static void main(String[] args) {
        Printer printer = new Printer();

        new Thread(() ->{
            for (int i = 1; i <= 26; i++) {
                try {
                    printer.print(0, i);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }, "thread1").start();
        new Thread(() ->{
            for (int i = 1; i <= 26; i++) {
                try {
                    printer.print(1, i);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }, "thread2").start();

    }
}
