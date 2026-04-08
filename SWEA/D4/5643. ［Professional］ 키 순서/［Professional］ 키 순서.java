import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());

        for (int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine().trim());
            int M = Integer.parseInt(br.readLine().trim());

            // 2차원 배열 하나로 끝! (도달 가능 여부만 체크)
            boolean[][] connected = new boolean[N + 1][N + 1];

            for (int i = 0; i < M; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                connected[a][b] = true; // a가 b보다 작다는 사실을 기록
            }

            // [플로이드-워셜 핵심 로직] 3중 for문
            // k: 거쳐가는 학생, i: 출발 학생, j: 도착 학생
            for (int k = 1; k <= N; k++) {
                for (int i = 1; i <= N; i++) {
                    for (int j = 1; j <= N; j++) {
                        // i가 k보다 작고, k가 j보다 작으면 -> i는 j보다 작다!
                        if (connected[i][k] && connected[k][j]) {
                            connected[i][j] = true;
                        }
                    }
                }
            }

            int answer = 0;
            // 모든 학생에 대해 자신과 연결된(크거나 작은) 학생 수 세기
            for (int i = 1; i <= N; i++) {
                int count = 0;
                for (int j = 1; j <= N; j++) {
                    // i에서 j로 갈 수 있거나 (i가 더 작음)
                    // j에서 i로 올 수 있다면 (i가 더 큼)
                    if (connected[i][j] || connected[j][i]) {
                        count++;
                    }
                }
                // 나를 제외한 모든 사람(N-1)과의 관계를 안다면 순위 확정
                if (count == N - 1) answer++;
            }

            System.out.println("#" + tc + " " + answer);
        }
    }
}