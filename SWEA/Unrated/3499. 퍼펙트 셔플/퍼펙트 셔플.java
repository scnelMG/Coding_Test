import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			String[] arr = new String[N]; // 입력받는 값 저장하는 배열
			String[] res = new String[N]; // 셔플 결과 저장하는 배열

			for (int i = 0; i < N; i++) { // 문자열 하나씩 입력해서 저장
				arr[i] = sc.next();
			}

			// 입력 받은 배열을 절반으로 나누고, 그 앞부분 넣기
			for (int i = 0; i < (N + 1) / 2; i++) { // 홀수 잘 처리하기
				// 5에 절반하고 그 앞부분 길이가 3이어야함
				res[i * 2] = arr[i];
			}

			// 절반으로 나눈, 그 뒷부분 넣기
			for (int i = 0; i < N / 2; i++) { // 인덱스 잘 처리할 수 있을거 같은데... 난 이게 최선..
				res[i * 2 + 1] = arr[(N + 1) / 2 + i];
			}

			System.out.print("#" + tc + " ");
			for (int i = 0; i < res.length; i++) {
				System.out.print(res[i] + " ");
			}
			System.out.println();

		}
	}

}
