import java.util.Scanner;

class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int L = sc.nextInt();
		String s = sc.next();

		int r = 31;
		int M = 1234567891;

		long H = 0;
		for (int i = 0; i < L; i++) {
			H += (s.charAt(i) - 'a' + 1) * Math.pow(r, i);
		}
		H %= M;
		System.out.println(H);

	}

}