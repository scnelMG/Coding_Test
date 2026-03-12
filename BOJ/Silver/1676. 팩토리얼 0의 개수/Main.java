import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int cnt2 = 0;
		int cnt5 = 0;

		for (int i = 1; i <= N; i++) {
			int num = i;
			while (num > 0) {
				if (num % 5 == 0) {
					cnt5++;
					num /= 5;
				} else if (num % 2 == 0) {
					cnt2++;
					num /= 2;
				} else {
					break;
				}
			}
		}
		System.out.println(Math.min(cnt2, cnt5));
	}
}
