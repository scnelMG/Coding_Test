import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int max_v = -1;
		int maxIdx = -1;
		for (int i = 1; i <= 9; i++) {
			int tmp = sc.nextInt();
			if (tmp > max_v) {
				max_v = tmp;
				maxIdx = i;
			}
		}
		System.out.println(max_v);
		System.out.println(maxIdx);
	}
}
