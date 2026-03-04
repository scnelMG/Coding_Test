import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int[] moneys = { 50000, 10000, 5000, 1000, 500, 100, 50, 10 }; // 지폐 값 저장

		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			System.out.println("#" + tc); // 결과 바로 출력

			for (int i = 0; i < moneys.length; i++) {
				if (N >= moneys[i]) { // 현재 잔액이 지폐 값보다 크다면
					System.out.print((N / moneys[i]) + " "); // 그 몫 만큼 출력
					N %= moneys[i]; // 나머지를 N으로 갱신
				} else { // 지폐 값보다 작다면 0 출력
					System.out.print(0 + " ");
				}
			}
			System.out.println();

		}
	}
}
