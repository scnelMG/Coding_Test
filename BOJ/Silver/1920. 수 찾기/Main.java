import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr1 = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr1[i] = Integer.parseInt(st.nextToken());
		}

		// 1. 이분 탐색을 위해 배열을 반드시 오름차순 정렬해야 합니다!
		Arrays.sort(arr1);

		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < M; i++) {
			int targetNum = Integer.parseInt(st.nextToken());

			// 2. 직접 만든 이분 탐색 메서드 호출
			if (binarySearch(arr1, targetNum)) {
				sb.append("1\n");
			} else {
				sb.append("0\n");
			}
		}
		System.out.println(sb.toString());
	}

	// 3. 이분 탐색 로직 구현
	static boolean binarySearch(int[] arr, int target) {
		int left = 0;
		int right = arr.length - 1;

		while (left <= right) {
			int mid = (left + right) / 2; // 중간 인덱스 계산

			if (arr[mid] == target) {
				return true; // 찾았음!
			} else if (arr[mid] > target) {
				right = mid - 1; // 타겟이 중간값보다 작으면 왼쪽 구간 탐색
			} else {
				left = mid + 1; // 타겟이 중간값보다 크면 오른쪽 구간 탐색
			}
		}
		return false; // 끝까지 못 찾았을 경우
	}
}