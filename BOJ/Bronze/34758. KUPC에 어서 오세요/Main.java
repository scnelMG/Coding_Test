import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int X = sc.nextInt();
		int Y = sc.nextInt();
		int N = sc.nextInt();
		for (int i = 0; i < N; i++) {
			int x1 = sc.nextInt();
			int y1 = sc.nextInt();
			int res = 1;
			if (x1 == X || y1 == Y)
				res--;

			System.out.println(res);
		}
	}
}
