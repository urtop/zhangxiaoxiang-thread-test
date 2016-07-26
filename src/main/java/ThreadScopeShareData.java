import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Created by Mark on 2016/7/26.
 */
public class ThreadScopeShareData {
    public static int data = 0;
    private static Map<Thread,Integer> threadData = new HashMap<Thread,Integer>();
    public static void main(String[] args) {
        for (int i = 0; i < 99; i++) {
            new Thread(new Runnable() {
                 @Override
                public void run() {
                    int data = new Random().nextInt();
                    System.out.println(Thread.currentThread().getName() + " output data: " + data);
                     threadData.put(Thread.currentThread(),data);
                    new A().get();
                    new B().get();
                }
            }).start();
        }

    }

    static class A {
        public void get() {
            int data= threadData.get(Thread.currentThread());
            System.out.println("A from " + Thread.currentThread().getName()+" output data: " + data);
        }
    }

    static class B {
        int data= threadData.get(Thread.currentThread());
        public void get() {
            System.out.println("B from "+ Thread.currentThread().getName()+" output data: " + data);
        }
    }
}
