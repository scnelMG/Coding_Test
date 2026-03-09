import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		int cnt = 0;
		boolean isY = false;

		if (s.contains("y")) {
			isY = true;
		}
		for (int i = 0; i < s.length(); i++) {
			if ("aieuo".indexOf(s.charAt(i)) >= 0) {
				cnt++;
			}
		}
		if (isY) {
			System.out.println(cnt + " " + (cnt + 1));
		} else {
			System.out.println(cnt + " " + cnt);
		}

	}
}
