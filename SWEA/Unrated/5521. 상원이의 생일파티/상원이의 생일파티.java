import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int[][] arr = new int[N + 1][N + 1]; // 1부터 번호 시작 -> N+1 by N+1 크기의 행렬 생성

			for (int i = 0; i < M; i++) { // 친한 칭구 정보 저장
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				arr[a][b] = 1;
				arr[b][a] = 1;
			}

			int res = 0;
			List<Integer> list = new ArrayList<>(); // 선택된 친구들을 list에 저장

			for (int j = 2; j <= N; j++) {
				if (arr[1][j] == 1) { // 1번(상원이)의 친한 친구 추가
					res++;
					list.add(j);
				}
			}
			int listSize = list.size();
			for (int i = 0; i < listSize; i++) { // 친한 친구들의 친한 친구 추가
				int idx = list.get(i); // 친한 친구들 번호
				for (int j = 2; j <= N; j++) {
					if (arr[idx][j] == 1 && !(list.contains(j))) { // 상원이의 친한 친구에 포함 안되는 친구들만 카운트
						res++;
						list.add(j);
					}
				}
			}
			System.out.println("#" + tc + " " + res);

		}

	}
}