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
        int begin = 0;
        int end = 0;
        int reduce = arr.size() % threadsCount;
        for (int i = 0; i < threadsCount; i++) {
            if (reduce > 0){
                end = begin + repeats + 1;
                threads[i] = new Searcher(arr.subList(begin, end));
                reduce--;
            }
            else{
                end = begin + repeats;
                threads[i] = new Searcher(arr.subList(begin,end));
            }
            begin = end;
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
