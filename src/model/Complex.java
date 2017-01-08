package model;

public class Complex {
	private double realPart;
	private double imaginaryPart;

	public Complex() {
		this(0, 0);
	}

	public Complex(double r, double i) {
		this.realPart = r;
		this.imaginaryPart = i;
	}

	public Complex add(Complex b) {
		return new Complex(this.realPart + b.realPart, this.imaginaryPart + b.imaginaryPart);
	}

	public Complex sub(Complex b) {
		return new Complex(this.realPart - b.realPart, this.imaginaryPart - b.imaginaryPart);
	}

	public Complex mult(Complex b) {
		return new Complex(this.realPart * b.realPart - this.imaginaryPart * b.imaginaryPart,
				this.realPart * b.imaginaryPart + this.imaginaryPart * b.realPart);
	}

	public double getRealPart() {return this.realPart;}

	public double getImaginaryPart() {return this.imaginaryPart;}

	public void setRealPart(double newRealPart) {this.realPart = newRealPart;}

	public void setImaginaryPart(double newImaginaryPart) {this.imaginaryPart = newImaginaryPart;}

	@Override
	public String toString() {
		return String.format("(%f,%f)", realPart, imaginaryPart);
	}
}