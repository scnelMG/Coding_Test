import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int X = sc.nextInt();
		int Y = sc.nextInt();
		int N = sc.nextInt();

		double min = (double) X / Y;

		for (int i = 0; i < N; i++) {
			int x1 = sc.nextInt();
			int y1 = sc.nextInt();
			if (((double) x1 / y1) < min) {
				min = (double) x1 / y1;
			}
		}
		System.out.println(min * 1000);

	}

}
