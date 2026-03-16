import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		int cnt = 0;
		for (int i = 0; i < s.length(); i++) {
			if ("aeiou".indexOf(s.charAt(i)) != -1) {
				cnt++;
			}
		}
		System.out.println(cnt);
	}
}
