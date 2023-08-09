package usecase.operation;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import entity.ComplexNumber;

public class AdditionOperationTest {

    @Test
    public void testAddition() {
        ComplexNumber num1 = new ComplexNumber(3, 4);
        ComplexNumber num2 = new ComplexNumber(-1, 2);

        AdditionOperation additionOperation = new AdditionOperation();
        ComplexNumber result = additionOperation.perform(num1, num2);

        // Assert that the addition is performed correctly
        assertEquals(2, result.getReal(), 1e-6);
        assertEquals(6, result.getImaginary(), 1e-6);
    }

    @Test
    public void testAdditionWithZero() {
        ComplexNumber num1 = new ComplexNumber(5, 6);
        ComplexNumber num2 = new ComplexNumber(0, 0);

        AdditionOperation additionOperation = new AdditionOperation();
        ComplexNumber result = additionOperation.perform(num1, num2);

        // Assert that addition with zero doesn't change the value
        assertEquals(5, result.getReal(), 1e-6);
        assertEquals(6, result.getImaginary(), 1e-6);
    }

    @Test
    public void testAdditionWithNegativeRealPart() {
        ComplexNumber num1 = new ComplexNumber(3, 2);
        ComplexNumber num2 = new ComplexNumber(-1, 4);

        AdditionOperation additionOperation = new AdditionOperation();
        ComplexNumber result = additionOperation.perform(num1, num2);

        // Assert that addition with negative real parts is performed correctly
        assertEquals(2, result.getReal(), 1e-6);
        assertEquals(6, result.getImaginary(), 1e-6);
    }
}
