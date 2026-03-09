import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution {
	static int[] arr1 = new int[9];
	static int[] arr2 = new int[9]; // 인영이가 가지는 카드
	static int[] arr2_tmp = new int[9]; // 인영이가 내는 카드 순서
	static boolean[] visited = new boolean[9];
	static int cnt1, cnt2;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {

			StringTokenizer st = new StringTokenizer(br.readLine());

			// 규영이 카드 입력받기
			for (int i = 0; i < 9; i++) {
				arr1[i] = Integer.parseInt(st.nextToken());
			}

			// 인영이 카드 정보 저장
			int idx = 0;
			for (int i = 1; i <= 18; i++) {
				boolean isGood = true;
				for (int j = 0; j < 9; j++) {
					if (arr1[j] == i) {
						isGood = false;
						break;
					}

				}
				if (isGood) {
					arr2[idx++] = i;
				}
			}

			cnt1 = 0; // 규영이 승리 횟수
			cnt2 = 0; // 인영이 승리 횟수
			solve(0); // 순열
			System.out.println("#" + tc + " " + cnt1 + " " + cnt2);

		}
	}

	static void solve(int idx) {
		if (idx == 9) { // 인영이가 내는 카드 순서 다 정해짐
			int score1 = 0;
			int score2 = 0;
			for (int i = 0; i < 9; i++) { // 1~9라운드 진행
				if (arr1[i] > arr2_tmp[i]) {
					score1 += arr1[i] + arr2_tmp[i]; // 누적합
				} else if (arr1[i] < arr2_tmp[i]) {
					score2 += arr1[i] + arr2_tmp[i];
				}
			}

			if (score1 > score2) { // 승패 판단
				cnt1++;
			} else if (score1 < score2) {
				cnt2++;
			}
			return;
		}

		for (int i = 0; i < 9; i++) { // 순열로 계산ㄴ
			if (!visited[i]) {
				arr2_tmp[idx] = arr2[i];
				visited[i] = true;
				solve(idx + 1);
				visited[i] = false;
			}
		}

	}
}
