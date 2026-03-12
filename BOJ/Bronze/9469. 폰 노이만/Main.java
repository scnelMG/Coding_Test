import java.util.Scanner;

class Main{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int P = sc.nextInt();
		for (int tc = 0; tc<P; tc++) {
			int N = sc.nextInt();
			double D = sc.nextDouble();
			double A = sc.nextDouble();
			double B = sc.nextDouble();
			double F = sc.nextDouble();
			
			double time = D / (A + B);
			double ans = time * F;
			System.out.printf("%d %.6f", N, ans);
			System.out.println();
		}
	}
}