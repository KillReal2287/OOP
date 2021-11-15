import java.util.Scanner;
import java.util.Stack;

public class Calculator {
    Stack<Double> number = new Stack<>();

    public double Calculate(String str) throws Exception{
            String [] array = str.split(" ");
            double a;
            double b;
            double res = 0.0;
            for (int i = array.length-1; i >= 0; i--) {
                switch (array[i]){
                    case "+":
                        a = CanPop();
                        b = CanPop();
                        number.push(a + b);
                        break;
                    case "-":
                        a = CanPop();
                        b = CanPop();
                        number.push(a - b);
                        break;
                    case "*":
                        a = CanPop();
                        b = CanPop();
                        number.push(1.0* a * b);
                        break;
                    case "/":
                        a = CanPop();
                        b = CanPop();
                        if (b != 0){
                            number.push(a / b);
                        }
                        else{
                            throw new Exception("can not be divided by zero");
                        }
                        break;
                    case "":

                    case "sin":
                        a = CanPop();
                        number.push(Math.sin(a));
                        break;
                    case "cos":
                        a = CanPop();
                        number.push(Math.cos(a));
                        break;
                    case "sqrt":
                        a = CanPop();
                        if (a>=0){
                            number.push(Math.sqrt(a));
                        }
                        else{
                            throw new Exception("Can not take negative root");
                        }
                        break;
                    case "pow":
                        a = CanPop();
                        b = CanPop();
                        number.push(Math.pow(a,b));
                        break;
                    case "log":
                        a = CanPop();
                        if (a>0)
                            number.push(Math.log(a));
                        else
                            throw new Exception("can not take logarithm from negative argument");
                        break;
                    default:
                        try {
                            res = Double.parseDouble(array[i]);
                            number.push(res);
                        }
                        catch(Exception e){
                            throw new Exception("Unknown character");
                        } break;
                }

            }


        return number.pop();
    }

    public double CanPop() throws Exception{
        if (number.isEmpty()){
            throw new Exception("Unexpected expression");
        }
        else{
            return number.pop();
        }
    }


}
