

public class Main {
    public static void main(String[] args){
        final Integer[] testArray = {6997901, 6997927, 6997937, 6997967, 6998009, 6998029, 6998039, 6998051, 6998053};
        final Integer[] bigArray = new Integer[10000];
        for (int i = 0; i < bigArray.length; i++) {
            bigArray[i] = testArray[i % testArray.length];
        }
        bigArray[bigArray.length - 1] = 1048561;
        long time = System.currentTimeMillis();
        ThreadChecker.threadPrime(bigArray,2);
        System.out.println(System.currentTimeMillis() - time);
    }
}
