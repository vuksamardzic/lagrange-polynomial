
public class Main {

	public static double F(double x) {
		return (3 / (1 + (25 * Math.pow(x, 2))));
		// return Math.log(x);
	}

	public static double prod(double[] n, int xi, double x) {
		double numerator = 1;
		double denominator = 1;
		double func_xi = 1;

		for (int i = 0; i < n.length; i++) {
			if (i != xi) {
				System.out.printf("(x[%.4f] - xj[%.4f]) ", x, n[i]);
				numerator *= (x - n[i]);
			} else {
				func_xi = F(n[xi]);
			}
		}

		System.out.printf(
				"\n------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- * f(xi)[%f]\n",
				func_xi);

		for (int i = 0; i < n.length; i++) {
			if (i != xi) {
				System.out.printf("(xi[%.4f] - xj[%.4f]) ", n[xi], n[i]);
				denominator *= (n[xi] - n[i]);
			}
		}
		System.out.println("\n\n");

		return (numerator / denominator) * func_xi;
	}

	public static double lagrange_polynomial(double[] n, double x) {
		double Ln = 0;
		for (int i = 0; i < n.length; i++) {
			double step = prod(n, i, x);
			System.out.printf("Σ(%d) -> %f \n\n\n", i, step);
			Ln += step;
		}
		return Ln;
	}

	public static void main(String[] args) {
		// -1, 1 for original function ..
		// double[] steps = { 0.4, 0.5, 0.7, 0.8 };
		// double x = 0.6;

		double[] steps = { -0.4, -0.3, -0.2, -0.1, 0, 0.1, 0.2, 0.4 };
		double x = 0.3;

		System.out.printf("x = %.4f \nLn(%.4f) = %.4f", x, x, lagrange_polynomial(steps, x));
	}

}
