import java.util.Arrays;
import java.util.List;

public class ParallelSolution {
    public static boolean Checker(Integer[] digitals) {


        List<Integer> list = Arrays.asList(digitals);


        return list.parallelStream().anyMatch(Checker::PrimeChecker);
    }
}
