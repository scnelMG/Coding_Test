import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int cnt = 0;
		String tmp = null;
		for (int i = 666; cnt < N; i++) {
			tmp = Integer.toString(i);
			if (tmp.contains("666")) {
				cnt++;
			}
		}
		System.out.println(tmp);

	}
}