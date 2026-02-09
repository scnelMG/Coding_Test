import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();

		int res = 0;
		int starIdx = -1;

		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);

			if (ch == '*') {
				starIdx = i;
				continue;
			}

			int digit = ch - '0';

			if (i % 2 == 0) {
				res += digit;
			} else {
				res += digit * 3;
			}
		}

		int need = (10 - (res % 10)) % 10;

		if (starIdx % 2 == 0) {
			System.out.println(need);
		} else {
			System.out.println((need * 7) % 10);
		}
	}
}
