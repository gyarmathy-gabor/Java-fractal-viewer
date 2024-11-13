package model.fractal;


/**
 * The {@code Complex} class represents a complex number with a real and imaginary part.
 */
public class Complex {
    private final double real;
    private final double imaginary;

    /**
     * Constructs a complex number with the given real and imaginary parts.
     *
     * @param r the real part of the complex number
     * @param i the imaginary part of the complex number
     */
    public Complex(double r, double i){
        real = r;
        imaginary = i;
    }

    /**
     * Adds this complex number to another complex number.
     *
     * @param other the complex number to add
     * @return a new {@code Complex} object representing the sum of the two complex numbers
     */
    public Complex add(Complex other){
        return new Complex(this.real+other.real,this.imaginary+other.imaginary);
    }

    /**
     * Subtracts another complex number from this complex number.
     *
     * @param other the complex number to subtract
     * @return a new {@code Complex} object representing the difference between the two complex numbers
     */
    public Complex subtract(Complex other){
        return new Complex(this.real-other.real,this.imaginary-other.imaginary);
    }

    /**
     * Multiplies this complex number by another complex number.
     *
     * @param other the complex number to multiply
     * @return a new {@code Complex} object representing the product of the two complex numbers
     */
    public Complex multiply(Complex other){
        double returnReal = this.real*other.real - this.imaginary*other.imaginary;
        double returnImag = this.real*other.imaginary + this.imaginary* other.real;

        return new Complex(returnReal,returnImag);
    }

    /**
     * Squares this complex number by multiplying it by itself.
     *
     * @return a new {@code Complex} object representing the square of this complex number
     */
    public Complex square(){
        return this.multiply(this);
    }


    /**
     * Computes the radius (magnitude) of this complex number.
     *
     * @return the radius (magnitude) of the complex number
     */
    public double radius(){
        return Math.sqrt(Math.pow(this.real,2)+Math.pow(this.imaginary,2));
    }

    /**
     * Returns the imaginary part of this complex number.
     *
     * @return the imaginary part of the complex number
     */
    public double getImaginary() {
        return imaginary;
    }

    /**
     * Returns the real part of this complex number.
     *
     * @return the real part of the complex number
     */
    public double getReal() {
        return real;
    }
}
