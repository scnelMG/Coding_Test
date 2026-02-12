import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int[] arr = new int[6];
		for (int i = 0; i < 6; i++) {
			arr[i] = sc.nextInt();
		}
		int T = sc.nextInt();
		int P = sc.nextInt();

		int res = 0;
		for (int i = 0; i < 6; i++) {
			if (arr[i] != 0) {
				res += ((arr[i] - 1) / T) + 1;
			}

		}

		System.out.println(res);
		System.out.println(N / P + " " + N % P);

	}

}
