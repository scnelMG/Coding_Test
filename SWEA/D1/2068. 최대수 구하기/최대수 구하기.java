import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 가장 첫줄에는 보통 테스트 케이스 수가 주어짐

		int T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			int[] nums = new int[10]; // 문제에서 10으로 고정
			for (int i = 0; i < nums.length; i++) {
				nums[i] = sc.nextInt();
			} // 입력 끝

			// 반복문을 수행하면서 최댓값을 찾아보자
			// 최댓값이라면 임의의 아주 작은 수로 초기화 or 0번 인덱스 값으로 초기화
			int ans = -1;
			// 반복문을 수행하면서 최댓값을 찾아보자

			for (int i = 0; i < nums.length; i++) {
				if (ans < nums[i])
					ans = nums[i];

			}

			// 정답 출력부분
			// System.out.println("#" + test_case + " " + ans);
			System.out.printf("#%d %d\n", test_case, ans);

		} // 테스트 케이스 for문
	}

}
