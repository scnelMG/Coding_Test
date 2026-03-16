import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int rate1 = sc.nextInt();
		int rate2 = sc.nextInt();

		int n = sc.nextInt();

		for (int i = 0; i < n; i++) {
			int use = sc.nextInt();
			int total = 0;

			if (use <= 1000) {
				total = use * rate1;
			} else {
				total = (1000 * rate1) + ((use - 1000) * rate2);
			}

			System.out.println(use + " " + total);
		}

	}
}