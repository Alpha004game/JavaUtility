package testPack;

public class TestThread extends Thread{

    public void run()
    {
        double a=Math.random();
        System.out.println(a);
    }

    public static void main(String[] args)
    {
        TestThread a,b;
        a=new TestThread();
        b=new TestThread();
        a.start();
        b.start();
        try {
            a.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            b.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
