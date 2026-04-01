import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int[][] magnet;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine()); // 테스트 케이스 개수 입력

		for (int tc = 1; tc <= T; tc++) {
			int K = Integer.parseInt(br.readLine()); // K -> 회전 횟수 입력

			// 자석 정보 저장 배열
			// 총 4개인데, 1번부터 사용할거임 -> 크기 4+1
			// 톱니는 그냥 0번부터 -> 크기 8
			magnet = new int[5][8];

			// 자석 정보 입력
			for (int i = 1; i <= 4; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 8; j++) {
					magnet[i][j] = Integer.parseInt(st.nextToken()); // 0이면 N극, 1이면 S극
				}
			}

			// 회전 정보 입력
			for (int i = 0; i < K; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int num = Integer.parseInt(st.nextToken()); // 회전하는 톱니의 번호
				int dir = Integer.parseInt(st.nextToken()); // 회전하는 방향 (1 / -1)
				solve(num, dir); // 풀이 시작
			}

			// 합계 구하기
			int sum = 0;
			for (int i = 1; i < 5; i++) {
				if (magnet[i][0] == 1) // 0번 인덱스(빨간색 화살표 위치)가 1(S극)이면 합계
					sum += (1 << (i - 1)); // 1, 2, 4 ,8 -> 2의 제곱만큽 증가 -> 비트로 구현
			}
			System.out.println("#" + tc + " " + sum);

		}
	}

	static void solve(int cur, int dir) {

		// 현재 상태에서 회전해야하는 톱니부터 확인
		// 회전하면 톱니의 정보가 변함 -> 그럼 접해있는 톱니 정보가 바뀜
		// 미리 접해있는 톱니 정보를 다 보고, 회전이 되는지 확인하기

		// 회전 여부를 저장하는 boolean 배열
		boolean[] isTurn = new boolean[5]; // 얘도 1번부터 쓸거임 -> 크기 4 + 1
		isTurn[cur] = true; // 돌리는 톱니는 무조건 회전

		// 왼쪽 오른쪽 각각 확인할거임
		// 돌리는 톱니의 정보가 바뀌면 안되기 때문에 tmpCur 변수를 사용해서 cur이 안바뀌도록

		// 왼쪽 체크
		int tmpCur = cur;
		int l = tmpCur - 1;
		while (l >= 1) { // 1~4 범위 안에
			if (magnet[tmpCur][6] != magnet[l][2]) { // 접하는 톱니의 정보가 다르면 -> 회전시켜야함
				isTurn[l] = true;
				// 또한 옆의 톱니가 돌아가야하면, 그 옆도 돌아가는지 확인해야함(연쇄)
				tmpCur = l;
				l = tmpCur - 1;
			} else {
				break;
			}

		}

		// 오른쪽 체크
		tmpCur = cur;
		int r = tmpCur + 1;
		while (r <= 4) { // 1~4 범위 안에
			if (magnet[tmpCur][2] != magnet[r][6]) { // 접하는 톱니의 정보가 다르면 -> 회전시켜야함
				isTurn[r] = true;
				// 또한 옆의 톱니가 돌아가야하면, 그 옆도 돌아가는지 확인해야함(연쇄)
				tmpCur = r;
				r = tmpCur + 1;
			} else {
				break;
			}
		}

		// 이제 회전시켜야하는 톱니를 돌리기
		turn(cur, dir); // 선택된 톱니를 회전

		// 회전도 왼쪽, 오른쪽 나눠서 진행
		// 연쇄되어 회전된다면, 회전 방향 정하는게 왼쪽 오른쪽 나눠서 진행하는게 편함

		l = cur - 1;
		r = cur + 1;
		int tmpDir = dir;

		// 왼쪽 회전
		while (l >= 1) {
			tmpDir = -1 * tmpDir; // 회전 방향은 기존의 반대 -> 곱하기 -1
			if (isTurn[l]) { // 회전해야하는 톱니면 회전
				turn(l, tmpDir);
				l--; // 그 다음 왼쪽으로 이동
			} else {
				break;
			}

		}

		// 오른쪽 회전
		tmpDir = dir;
		while (r <= 4) {
			tmpDir = -1 * tmpDir;
			if (isTurn[r]) {
				turn(r, tmpDir);
				r++; // 그 다음 오른쪽으로 이동
			} else {
				break;
			}
		}

	}

	// 회전 -> 돌려야하는 톱니 번호랑 방향을 입력받음
	static void turn(int num, int dir) {
		// 시계 방향
		if (dir == 1) {

			// 예시 : 1 0 0 1 1 -> 1 1 0 0 1
			int tmp = magnet[num][7]; // 맨 뒤에꺼 저장해두고
			for (int i = 7; i > 0; i--) { // 그 뒤로 덮어쓰기 -> 거꾸로 해야 정보 손실없이 제대로 덮힘
				magnet[num][i] = magnet[num][i - 1];
			}
			magnet[num][0] = tmp;
		}
		// 반시계 방향
		else {
			// 예시 : 1 0 0 1 1 -> 0 0 1 1 1
			int tmp = magnet[num][0];
			for (int i = 0; i < 7; i++) {
				magnet[num][i] = magnet[num][i + 1];
			}
			magnet[num][7] = tmp;
		}

	}

}
