import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int[][] magnet;
    static int[] top; // 각 자석의 빨간색 화살표(0번 위치)가 배열의 어느 인덱스를 가리키는지 저장

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            int K = Integer.parseInt(br.readLine());
            
            magnet = new int[5][8];
            top = new int[5]; // 매 테케마다 0으로 초기화됨

            // 자석 정보 입력
            for (int i = 1; i <= 4; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 8; j++) {
                    magnet[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            // 회전 정보 입력
            for (int i = 0; i < K; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int num = Integer.parseInt(st.nextToken());
                int dir = Integer.parseInt(st.nextToken());
                solve(num, dir);
            }

            // 점수 계산 (각 자석의 top 인덱스의 값을 확인)
            int sum = 0;
            for (int i = 1; i <= 4; i++) {
                if (magnet[i][top[i]] == 1) {
                    sum += (1 << (i - 1));
                }
            }
            System.out.println("#" + tc + " " + sum);
        }
    }

    static void solve(int cur, int dir) {
        // 각 자석의 회전 방향 기록 (1: 시계, -1: 반시계, 0: 정지)
        int[] dirs = new int[5];
        dirs[cur] = dir;

        // 1. 왼쪽 방향 자석들 연쇄 확인
        for (int i = cur; i > 1; i--) {
            // 현재 자석의 왼쪽 극(top+6)과 왼쪽 자석의 오른쪽 극(top+2) 비교
            int leftOfCurrent = magnet[i][(top[i] + 6) % 8];
            int rightOfLeft = magnet[i - 1][(top[i - 1] + 2) % 8];
            
            if (leftOfCurrent != rightOfLeft) {
                dirs[i - 1] = -dirs[i]; // 반대 방향으로 회전
            } else {
                break; // 극이 같으면 연쇄 중단
            }
        }

        // 2. 오른쪽 방향 자석들 연쇄 확인
        for (int i = cur; i < 4; i++) {
            // 현재 자석의 오른쪽 극(top+2)과 오른쪽 자석의 왼쪽 극(top+6) 비교
            int rightOfCurrent = magnet[i][(top[i] + 2) % 8];
            int leftOfRight = magnet[i + 1][(top[i + 1] + 6) % 8];
            
            if (rightOfCurrent != leftOfRight) {
                dirs[i + 1] = -dirs[i]; // 반대 방향으로 회전
            } else {
                break;
            }
        }

        // 3. 기록된 방향을 바탕으로 한 번에 회전(top 인덱스만 갱신) 적용
        for (int i = 1; i <= 4; i++) {
            if (dirs[i] == 1) { // 시계 방향 회전 (기준점이 왼쪽으로 1칸 이동하는 것과 같음)
                top[i] = (top[i] + 7) % 8; // -1 대신 +7을 하여 음수 나머지 연산 방지
            } else if (dirs[i] == -1) { // 반시계 방향 회전 (기준점이 오른쪽으로 1칸 이동)
                top[i] = (top[i] + 1) % 8;
            }
        }
    }
}