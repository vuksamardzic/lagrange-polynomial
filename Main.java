
public class Main {

	public static double F(double x) {
		return (3 / (1 + (25 * Math.pow(x, 2))));
	}

	public static double prod(double[] n, int xi, double x) {
		double numerator = 1;
		double denominator = 1;

		for (int i = 0; i < n.length; i++) {
			if (i != xi) {
				numerator *= (x - n[i]);
				denominator *= (n[xi] - n[i]);
			}
		}

		return (numerator / denominator) * F(n[xi]);
	}

	public static double lagrange_polynomial(double[] n, double x) {
		double Ln = 0;
		for (int i = 0; i < n.length; i++) {
			double step = prod(n, i, x);
			Ln += step;
		}
		return Ln;
	}

	public static void main(String[] args) {

		double[] steps = { -0.4, -0.3, -0.2, -0.1, 0, 0.1, 0.2, 0.4 };
		double x = 0.3;

		System.out.printf("x = %.4f\nLn(%.4f) = %.4f", x, x, lagrange_polynomial(steps, x));
	}

}
