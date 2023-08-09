package usecase.operation;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import entity.ComplexNumber;

public class MultiplicationOperationTest {

    @Test
    public void testMultiplication() {
        ComplexNumber num1 = new ComplexNumber(2, 3);
        ComplexNumber num2 = new ComplexNumber(1, -2);

        MultiplicationOperation multiplicationOperation = new MultiplicationOperation();
        ComplexNumber result = multiplicationOperation.perform(num1, num2);

        // Assert that the multiplication is performed correctly
        assertEquals(8, result.getReal(), 1e-6);
        assertEquals(-1, result.getImaginary(), 1e-6);
    }

    @Test
    public void testMultiplicationByZero() {
        ComplexNumber num1 = new ComplexNumber(4, -5);
        ComplexNumber num2 = new ComplexNumber(0, 0);

        MultiplicationOperation multiplicationOperation = new MultiplicationOperation();
        ComplexNumber result = multiplicationOperation.perform(num1, num2);

        // Assert that multiplication by zero results in zero
        assertEquals(0, result.getReal(), 1e-6);
        assertEquals(0, result.getImaginary(), 1e-6);
    }
}
