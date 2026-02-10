import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			String s = sc.next();
			if (s.equals("0")) {
				break;
			}
			StringBuilder sb = new StringBuilder();
			sb.append(s);
			sb.reverse();
			if (s.equals(sb.toString()))
				System.out.println("yes");
			else
				System.out.println("no");
		}

	}
}
