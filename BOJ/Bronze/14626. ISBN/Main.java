import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();

		int res = 0;
		int resIdx = -1;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) != '*') {
				if (i % 2 == 0) {
					res += (s.charAt(i) - '0');
				} else {
					res += (s.charAt(i) - '0') * 3;
				}
			} else {
				resIdx = i;
			}

		}
		if (resIdx % 2 == 0)
			System.out.println(10 - (res % 10));
		else
			System.out.println((10 - (res % 10)) / 3);

	}

}
