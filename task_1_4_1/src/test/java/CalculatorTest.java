import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class CalculatorTest {
    @Test
    public void ComparingValues() throws Exception {
        Calculator calculator = new Calculator();

        Assertions.assertEquals(0, calculator.Calculate("sin + - 1 2 1"));
        Assertions.assertEquals(20, calculator.Calculate("+ 14 6"));
        Assertions.assertEquals(8, calculator.Calculate("- 14 6"));

        Assertions.assertEquals(5, calculator.Calculate("- * / 15 - 7 + 1 1 3 + 2 + 1 1"));
        Assertions.assertEquals(0, calculator.Calculate("* log 1 2"));
        Assertions.assertEquals(16, calculator.Calculate("pow 2 sqrt 16"));

        Assertions.assertEquals(Math.cos(2), calculator.Calculate("cos 2"));
        Assertions.assertEquals(Math.sin(5), calculator.Calculate("sin 5"));
    }

    @Test
    void ExceptionsExpressionsCheck() throws Exception {
        Calculator calculator = new Calculator();
        Exception e = assertThrows(Exception.class, () -> calculator.Calculate("a +b "));
        assertEquals("Unknown character", e.getMessage());
    }

    @Test
    void ExceptionsDivisionCheck() throws Exception {
        Calculator calculator = new Calculator();
        Exception e = assertThrows(Exception.class, () -> calculator.Calculate("/ 4 0"));
        assertEquals("can not be divided by zero", e.getMessage());
    }

    @Test
    void ExceptionsPowCheck() throws Exception {
        Calculator calculator = new Calculator();
        Exception e = assertThrows(Exception.class, () -> calculator.Calculate("pow 4"));
        assertEquals("Unexpected expression", e.getMessage());
    }

    @Test
    void ExceptionsSqrtCheck() throws Exception {
        Calculator calculator = new Calculator();
        Exception e = assertThrows(Exception.class, () -> calculator.Calculate("sqrt -4"));
        assertEquals("Can not take negative root", e.getMessage());
    }

    @Test
    void ExceptionsLogCheck() throws Exception {
        Calculator calculator = new Calculator();
        Exception e = assertThrows(Exception.class, () -> calculator.Calculate("log -4"));
        assertEquals("can not take logarithm from negative argument", e.getMessage());
    }
    

}
