package assignment1;

public class Complex {
	private double real;
	private double imag;
	public Complex() {
		real=0;
		imag=0;
	}
	public Complex(double real,double imag) {
		this.real=real;
		this.imag=imag;
	}
	public double getReal() {
		return real;
	}
	public double getImag() {
		return imag;
	}
	public void setReal(double real) {
		this.real=real;
	}
	public void setImag(double imag) {
		this.imag=imag;
	}
	public Complex add(Complex n) {
		return new Complex(real + n.getReal(),imag+n.getImag ());
	}
	public Complex sub(Complex m) {
		return new Complex(real -m.getReal(),imag-m.getImag());
	}
	public Complex mul(Complex m) {
		double realPart = real+ m.getReal()-imag*m.getImag();
		double imagPart = real * m.getImag() + imag* m.getReal();
		return new Complex(realPart , imagPart);
	}
	public Complex div(Complex m) {
		double denominator = m.getReal()+ m.getReal() + m.getImag()*m.getImag();
		double realPart = (real * m.getReal() + imag * m.getImag());
		double imagPart = (imag* m.getReal()-real * m.getImag());
		return new Complex(realPart , imagPart);
	}
	public String toString() {
		if(imag>=0) {
			return real+ "+" + imag + "i";
		}
		else {
			return real + " - " +(-imag)+ "i";
		}
	}
}
