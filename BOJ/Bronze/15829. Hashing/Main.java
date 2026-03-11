import java.util.Scanner;

class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int L = sc.nextInt();
		String s = sc.next();

		int r = 31;
		int M = 1234567891;

		long H = 0;
		long pow = 1;
		for (int i = 0; i < L; i++) {
			long alpha = s.charAt(i) - 'a' + 1;

			H = (H + (alpha * pow) % M) % M;
			pow = (pow * r) % M;
		}
		System.out.println(H);

	}

}