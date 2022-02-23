package editor.cn;


public class Demo {

    public static void main(String[] args) throws InterruptedException {
        String s3 = new String("a");
        s3.intern();
        String s4 = "a";

        System.out.println(s3==s4);

    }
}

