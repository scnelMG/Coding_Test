import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int tc = 1; tc <= 10; tc++) {
			int t = sc.nextInt();
			int[] arr = new int[8]; // 8개 숫자 저장할 배열

			for (int i = 0; i < arr.length; i++) { // 배열에 숫자 8개 넣기
				arr[i] = sc.nextInt();
			}

			int idx = 0; // 접근하는 배열의 인덱스 값 -> 점점 늘려감 (0~7)
			int minus = 1; // 빼주는 값 -> 점점 늘려감 (1~5)

			while (true) {
				idx = idx % 8; // 0~7범위에서 인덱스가 있도록
				minus = (minus - 1) % 5 + 1; // 1~5 범위에서 빼주는 값이 있도록

				if (arr[idx] - minus <= 0) { // 뺐을 때, 0보다 작거나 같으면 그 값을 0으로 설정하고 멈춤
					arr[idx] = 0;
					break;
				}

				arr[idx++] -= minus; // 해당 인덱스에 해당하는 배열의 값에서 빼줌
				minus++; // 빼주는 값 +1
			}
			System.out.print("#" + tc + " ");
			for (int i = idx + 1; i < idx + 1 + 8; i++) { // 마지막에 멈춘 인덱스의 +1부터 출력 시작
				// 인덱스가 0~7에서 있도록 나머지 처리
				System.out.print(arr[i % 8] + " ");
			}
			System.out.println();

		}
	}

}
