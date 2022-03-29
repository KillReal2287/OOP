import java.util.Scanner;

public class LinealSolution {
    public static boolean Checker(Integer[] array) {

        for (Integer integer : array) {
            if (Checker.PrimeChecker(integer)) {
                return true;
            }
        }
        return false;

    }
}
