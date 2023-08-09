package usecase.operation;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import entity.ComplexNumber;

public class SubtractionOperationTest {

    @Test
    public void testSubtraction() {
        ComplexNumber num1 = new ComplexNumber(5, 6);
        ComplexNumber num2 = new ComplexNumber(2, 3);

        SubtractionOperation subtractionOperation = new SubtractionOperation();
        ComplexNumber result = subtractionOperation.perform(num1, num2);

        // Assert that the subtraction is performed correctly
        assertEquals(3, result.getReal(), 1e-6);
        assertEquals(3, result.getImaginary(), 1e-6);
    }

    @Test
    public void testSubtractionWithNegativeImaginary() {
        ComplexNumber num1 = new ComplexNumber(3, -2);
        ComplexNumber num2 = new ComplexNumber(-1, -4);

        SubtractionOperation subtractionOperation = new SubtractionOperation();
        ComplexNumber result = subtractionOperation.perform(num1, num2);

        // Assert that the subtraction with negative imaginary parts is performed correctly
        assertEquals(4, result.getReal(), 1e-6);
        assertEquals(2, result.getImaginary(), 1e-6);
    }

    @Test
    public void testSubtractionWithZero() {
        ComplexNumber num1 = new ComplexNumber(2, 3);
        ComplexNumber num2 = new ComplexNumber(0, 0);

        SubtractionOperation subtractionOperation = new SubtractionOperation();
        ComplexNumber result = subtractionOperation.perform(num1, num2);

        // Assert that subtraction with zero doesn't change the value
        assertEquals(2, result.getReal(), 1e-6);
        assertEquals(3, result.getImaginary(), 1e-6);
    }
}