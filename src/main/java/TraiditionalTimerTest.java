import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Mark on 2016/7/20.
 */
public class TraiditionalTimerTest {
    public static void main(String[] args){
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("1111");

            }
        },1000,3000);

    }
}
