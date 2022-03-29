import static java.lang.Math.sqrt;

public class Checker{


    public static  boolean PrimeChecker(int n){
        if (n == 1){
            return true;
        }
        else {
            for (int i = 2; i <= sqrt(n); i++) {
                if (n % i == 0) {
                    return true;
                }
            }
        }
        return false;
    }
}
