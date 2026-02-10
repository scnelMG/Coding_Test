import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int cnt = 1;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M - 1; j++) {
				sb.append(cnt).append(" ");
				cnt++;
			}
			sb.append(cnt).append("\n");
			cnt++;
		}
		System.out.println(sb.toString());

	}
}
