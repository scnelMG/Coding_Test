package 박민규.CodeTree.1이3개이상있는위치;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int N;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];

		solve(0);
	}

	static void solve(int depth) {
		// 종료 조건: 길이가 N인 수열을 완성했을 때
		if (depth == N) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < N; i++) {
				sb.append(arr[i]);
			}
			System.out.println(sb.toString());
			System.exit(0);
		}

		// 4, 5, 6 순서대로 숫자를 넣어봅니다. (사전순 탐색)
		for (int i = 4; i <= 6; i++) {
			arr[depth] = i; // 현재 위치에 4, 5, 6 중 하나를 넣음

			// 방금 넣은 숫자로 인해 불가능한 수열이 되지 않았다면 다음 깊이로 이동
			if (isValid(depth)) {
				solve(depth + 1);
			}
			// 백트래킹 원상복구 로직(arr[depth] = 0)은 생략 가능합니다.
			// 어차피 다음 반복문이나 재귀에서 새로운 값으로 덮어씌워지기 때문입니다.
		}
	}

	// 인접한 연속 부분 수열이 동일한지 검사하는 함수
	static boolean isValid(int lastIndex) {
		int length = lastIndex + 1; // 현재까지 만들어진 수열의 전체 길이

		// 부분 수열의 길이(len)를 1부터 현재 길이의 절반까지 늘려가며 검사
		for (int len = 1; len <= length / 2; len++) {
			boolean isSame = true;

			// 방금 끝에 추가된 부분과, 그 바로 앞의 연속된 부분을 비교
			for (int i = 0; i < len; i++) {
				// 뒤쪽 부분 수열의 인덱스: lastIndex - i
				// 앞쪽 부분 수열의 인덱스: lastIndex - i - len
				if (arr[lastIndex - i] != arr[lastIndex - i - len]) {
					isSame = false; // 하나라도 다르면 동일한 부분 수열이 아님
					break;
				}
			}

			// 두 부분 수열이 완벽히 똑같다면 불가능한 수열임
			if (isSame) {
				return false;
			}
		}
		return true; // 모든 검사를 무사히 통과하면 가능한 수열임
	}
}