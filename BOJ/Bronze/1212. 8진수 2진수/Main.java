import java.util.Scanner;

class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		StringBuilder sb = new StringBuilder();

		int num = s.charAt(0) - '0';
		while (num > 0) {
			sb.append(num % 2);
			num /= 2;
		}
		for (int i = 1; i < s.length(); i++) {
			num = s.charAt(i) - '0';
			for (int j = 2; j >= 0; j--) {
				sb.append(num / (int) Math.pow(2, j));

				num = num % (int) Math.pow(2, j);
			}
		}
		System.out.println(sb.toString());

	}
}