package usecase.operation;

import entity.ComplexNumber;
import usecase.operation.ComplexNumberOperation;

public class ExponentiationOperation implements ComplexNumberOperation {
    private double exponent;

    public ExponentiationOperation(double exponent) {
        this.exponent = exponent;
    }

    @Override
    public ComplexNumber perform(ComplexNumber num1, ComplexNumber num2) {
        double norm = Math.pow(num1.getNorm(), exponent);
        double argument = num1.getArgument() * exponent;
        double real = norm * Math.cos(argument);
        double imaginary = norm * Math.sin(argument);
        return new ComplexNumber(real, imaginary);
    }
}