package model;

public class FFT {

	public Complex[] dft(byte[] inreal) {
		int n = inreal.length;
		double[] outreal = new double[inreal.length];
		double[] outimag = new double[inreal.length];
		double[] inimag = new double[inreal.length];
		for(int i = 0; i < inreal.length; i++) {
			inimag[i] = 0.0;
		}
		for (int k = 0; k < n; k++) {
			double sumreal = 0;
			double sumimag = 0;
			for (int t = 0; t < n; t++) {
				double angle = 2 * Math.PI * t * k / n;
				sumreal +=  inreal[t] * Math.cos(angle) + inimag[t] * Math.sin(angle);
				sumimag += -inreal[t] * Math.sin(angle) + inimag[t] * Math.cos(angle);
			}
			outreal[k] = sumreal;
			outimag[k] = sumimag;
		}
		return this.packageDoubleArraysIntoComplexArray(outreal, outimag);
	}

	private Complex[] packageDoubleArraysIntoComplexArray(double[] real, double[] imaginary) {
		Complex[] values = new Complex[real.length];
		for(int i = 0; i < real.length; i++) {
			values[i] = new Complex(real[i], imaginary[i]);
		}
		return values;
	}

}
