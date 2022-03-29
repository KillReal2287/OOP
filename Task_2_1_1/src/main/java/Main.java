import java.util.concurrent.ExecutionException;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        long time = System.currentTimeMillis();
        Integer[] digitals = new Integer[1000];
        for (int i = 0; i < 1000-1; i++) {
            digitals[i] = 7;
        }
        digitals[999] = 10;
        ThreadChecker threadChecker = new ThreadChecker();
        System.out.println(threadChecker.threadPrime(digitals,16));
        System.out.println(System.currentTimeMillis() - time);
    }
}
