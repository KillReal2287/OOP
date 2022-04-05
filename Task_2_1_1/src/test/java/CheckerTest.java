

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;




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

        Assertions.assertTrue(ParallelSolution.Checker(bigArray));
    }



    @Test
    public void threadTest2() {
        Assertions.assertTrue(ThreadChecker.threadPrime(bigArray,2));
    }

    @Test
    public void threadTest3(){
        Assertions.assertTrue(ThreadChecker.threadPrime(bigArray,3));
    }

    @Test
    public void threadTest4(){
        Assertions.assertTrue(ThreadChecker.threadPrime(bigArray,4));
    }

    @Test
    public void threadTest5(){
        Assertions.assertTrue(ThreadChecker.threadPrime(bigArray,5));
    }

    @Test
    public void threadTest6(){
        Assertions.assertTrue(ThreadChecker.threadPrime(bigArray,6));
    }

    @Test
    public void threadTest7(){
        Assertions.assertTrue(ThreadChecker.threadPrime(bigArray,7));
    }

    @Test
    public void threadTest8(){
        Assertions.assertTrue(ThreadChecker.threadPrime(bigArray,8));
    }

    @Test
    public void threadTest9(){
        Assertions.assertTrue(ThreadChecker.threadPrime(bigArray,9));
    }

    @Test
    public void threadTest10(){
        Assertions.assertTrue(ThreadChecker.threadPrime(bigArray,10));
    }

    @Test
    public void threadTest11(){
        Assertions.assertTrue(ThreadChecker.threadPrime(bigArray,11));
    }

    @Test
    public void threadTest12(){
        Assertions.assertTrue(ThreadChecker.threadPrime(bigArray,12));
    }

    @Test
    public void threadTest16(){
        Assertions.assertTrue(ThreadChecker.threadPrime(bigArray,16));
    }
}
