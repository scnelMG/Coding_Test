import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) { // 테스트 케이스 입력
			int N = sc.nextInt(); // 확인해야하는 비트 수
			int M = sc.nextInt(); // 비트로 변환해야하는 10진수

			int idx = 0; // 비트 개수 세는 변수
			boolean isGood = true; // 모두 1인지

			while (M >= 0 && idx < N) { // 2진수 계산 -> 차피 뒤에서부터 계산되니 큰 문제 없음
				if (M % 2 == 0) { // 비트 0이 나오면 그만
					isGood = false;
					break;
				}
				idx++; // 비트 1이면, 개수 추가하고, 몫 계산ㄴ
				M /= 2;

			}
			if (isGood)
				System.out.println("#" + tc + " ON");
			else
				System.out.println("#" + tc + " OFF");

		}
	}

}
