import java.util.*;
import java.util.stream.Collectors;

public class ThreadChecker {
    public static boolean threadPrime(Integer[] arrays, int threadsNumber) {
        int threadsCount = Runtime.getRuntime().availableProcessors();
        if (threadsNumber < threadsCount){
            threadsCount = threadsNumber;
        }
        List<Integer> arr = Arrays.stream(arrays).collect(Collectors.toList());
        int repeats = arr.size() / threadsCount;
        Searcher[] threads = new Searcher[threadsCount];

        for (int i = 0; i < threadsCount; i++) {
            threads[i] = new Searcher(arr.subList(i * repeats, (i + 1) * repeats));
            threads[i].start();
        }

        for (int i = 0; i < threadsCount; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        boolean result = false;
        for (int i = 0; i < threadsCount; i++) {
            if (!threads[i].getRes()) {
                result = true;
                break;
            }
        }
        return result;
    }

    public static class Searcher extends Thread {
        List<Integer> arr;
        public boolean res = false;

        Searcher(List<Integer> arr) {
            this.arr = arr;
        }

        @Override
        public void run() {
            for (Integer num : arr) {
                if (Checker.PrimeChecker(num)) {
                    setRes(true);
                }
            }
        }

        public void setRes(boolean res) {
            this.res = res;
        }

        public boolean getRes() {
            return res;
        }
    }
}
