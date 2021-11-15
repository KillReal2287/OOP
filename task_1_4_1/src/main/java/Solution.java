import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        while(true) {
            String str = scanner.nextLine();
            if (str.equals("end")){
                break;
            }
            else {
                Calculator subject = new Calculator();
                System.out.println(subject.Calculate(str));
            }
        }
    }
}
