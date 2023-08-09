package entity;

import java.util.Objects;

public class ComplexNumber {
    private double real;
    private double imaginary;

    /**
     * Constructs a ComplexNumber object with the given real and imaginary parts.
     *
     * @param real      The real part of the complex number.
     * @param imaginary The imaginary part of the complex number.
     */
    public ComplexNumber(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    /**
     * Gets the real part of the complex number.
     *
     * @return The real part.
     */
    public double getReal() {
        return real;
    }

    /**
     * Gets the imaginary part of the complex number.
     *
     * @return The imaginary part.
     */
    public double getImaginary() {
        return imaginary;
    }

    /**
     * Calculates and returns the norm (magnitude) of the complex number.
     *
     * @return The norm of the complex number.
     */
    public double getNorm() {
        return Math.sqrt(real * real + imaginary * imaginary);
    }

    /**
     * Calculates and returns the argument (angle) of the complex number.
     *
     * @return The argument of the complex number.
     */
    public double getArgument() {
        return Math.atan2(imaginary, real);
    }

    /**
     * Compares this complex number to another object for equality.
     *
     * @param o The object to compare to.
     * @return true if the objects are equal, false otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ComplexNumber that = (ComplexNumber) o;
        return Double.compare(that.real, real) == 0 &&
                Double.compare(that.imaginary, imaginary) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(real, imaginary);
    }

    @Override
    public String toString() {
        if (imaginary >= 0) {
            return real + " + " + imaginary + "i";
        } else {
            return real + " - " + (-imaginary) + "i";
        }
    }
}