

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.util.concurrent.ExecutionException;

public class CheckerTest {

    private final Integer[] testArray = {6997901, 6997927, 6997937, 6997967, 6998009, 6998029, 6998039, 6998051, 6998053};
    private final Integer[] bigArray = new Integer[10000];

    public void buildHugeArray() {
        for (int i = 0; i < bigArray.length; i++) {
            bigArray[i] = testArray[i % testArray.length];
        }
        bigArray[bigArray.length - 1] = 1048561;
    }

    @BeforeEach
    public void init() {
        buildHugeArray();
    }

    @Test
    public void sequentialTest() {
        Assertions.assertTrue(LinealSolution.Checker(bigArray));
    }

    @Test
    public void streamTest() {
        Integer[] testArrayLong = new Integer[bigArray.length];
        for(int index = 0; index < bigArray.length; index++) {
            testArrayLong[index] = bigArray[index];
        }
        Assertions.assertTrue(ParallelSolution.Checker(testArrayLong));
    }



    @Test
    public void threadTest2() throws InterruptedException, ExecutionException {
        ThreadChecker thread = new ThreadChecker();
        Assertions.assertTrue(ThreadChecker.threadPrime(bigArray,2));
    }

    @Test
    public void threadTest3() throws InterruptedException, ExecutionException {
        ThreadChecker thread = new ThreadChecker();
        Assertions.assertTrue(ThreadChecker.threadPrime(bigArray,3));
    }

    @Test
    public void threadTest4() throws InterruptedException, ExecutionException {
        ThreadChecker thread = new ThreadChecker();
        Assertions.assertTrue(ThreadChecker.threadPrime(bigArray,4));
    }

    @Test
    public void threadTest5() throws InterruptedException, ExecutionException {
        ThreadChecker thread = new ThreadChecker();
        Assertions.assertTrue(ThreadChecker.threadPrime(bigArray,5));
    }

    @Test
    public void threadTest6() throws InterruptedException, ExecutionException {
        ThreadChecker thread = new ThreadChecker();
        Assertions.assertTrue(ThreadChecker.threadPrime(bigArray,6));
    }

    @Test
    public void threadTest7() throws InterruptedException, ExecutionException {
        ThreadChecker thread = new ThreadChecker();
        Assertions.assertTrue(ThreadChecker.threadPrime(bigArray,7));
    }

    @Test
    public void threadTest8() throws InterruptedException, ExecutionException {
        ThreadChecker thread = new ThreadChecker();
        Assertions.assertTrue(ThreadChecker.threadPrime(bigArray,8));
    }

    @Test
    public void threadTest9() throws InterruptedException, ExecutionException {
        ThreadChecker thread = new ThreadChecker();
        Assertions.assertTrue(ThreadChecker.threadPrime(bigArray,9));
    }

    @Test
    public void threadTest10() throws InterruptedException, ExecutionException {
        ThreadChecker thread = new ThreadChecker();
        Assertions.assertTrue(ThreadChecker.threadPrime(bigArray,10));
    }

    @Test
    public void threadTest11() throws InterruptedException, ExecutionException {
        ThreadChecker thread = new ThreadChecker();
        Assertions.assertTrue(ThreadChecker.threadPrime(bigArray,11));
    }

    @Test
    public void threadTest12() throws InterruptedException, ExecutionException {
        ThreadChecker thread = new ThreadChecker();
        Assertions.assertTrue(ThreadChecker.threadPrime(bigArray,12));
    }

    @Test
    public void threadTest16() throws InterruptedException, ExecutionException {
        ThreadChecker thread = new ThreadChecker();
        Assertions.assertTrue(ThreadChecker.threadPrime(bigArray,16));
    }
}
