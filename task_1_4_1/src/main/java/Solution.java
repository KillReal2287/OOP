import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello world");
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        Calculator subject = new Calculator();
        System.out.println(subject.Calculate(str));

    }
}
