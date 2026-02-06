import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int i = 0; i < T; i++) {
			String s = sc.next();
			StringBuilder sb = new StringBuilder();

			sb.append(s.charAt(0));
			sb.append(s.charAt(s.length() - 1));
			System.out.println(sb);
		}
	}
}
