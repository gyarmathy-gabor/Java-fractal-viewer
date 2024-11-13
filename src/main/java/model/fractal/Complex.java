package model.fractal;

public class Complex {
    private final double real;
    private final double imaginary;

    public Complex(double r, double i){
        real = r;
        imaginary = i;
    }

    public Complex add(Complex other){
        return new Complex(this.real+other.real,this.imaginary+other.imaginary);
    }

    public Complex subtract(Complex other){
        return new Complex(this.real-other.real,this.imaginary-other.imaginary);
    }

    public Complex multiply(Complex other){
        double returnReal = this.real*other.real - this.imaginary*other.imaginary;
        double returnImag = this.real*other.imaginary + this.imaginary* other.real;

        return new Complex(returnReal,returnImag);
    }

    public Complex square(){
        return this.multiply(this);
    }


    public double radius(){
        return Math.sqrt(Math.pow(this.real,2)+Math.pow(this.imaginary,2));
    }

    public double getImaginary() {
        return imaginary;
    }

    public double getReal() {
        return real;
    }
}
