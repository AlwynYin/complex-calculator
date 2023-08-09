package usecase.operation;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import entity.ComplexNumber;

public class DivisionOperationTest {

    @Test
    public void testDivision() {
        ComplexNumber num1 = new ComplexNumber(4, 2);
        ComplexNumber num2 = new ComplexNumber(2, 1);

        DivisionOperation divisionOperation = new DivisionOperation();
        ComplexNumber result = divisionOperation.perform(num1, num2);

        // Assert that the division is performed correctly
        assertEquals(2, result.getReal(), 1e-6);
        assertEquals(0, result.getImaginary(), 1e-6);
    }

    @Test
    public void testDivisionWithNegativeImaginary() {
        ComplexNumber num1 = new ComplexNumber(6, -3);
        ComplexNumber num2 = new ComplexNumber(-2, -1);

        DivisionOperation divisionOperation = new DivisionOperation();
        ComplexNumber result = divisionOperation.perform(num1, num2);

        // Assert that the division with negative imaginary parts is performed correctly
        assertEquals((double) -9 / 5, result.getReal(), 1e-6);
        assertEquals((double) 12 / 5, result.getImaginary(), 1e-6);
    }
}
