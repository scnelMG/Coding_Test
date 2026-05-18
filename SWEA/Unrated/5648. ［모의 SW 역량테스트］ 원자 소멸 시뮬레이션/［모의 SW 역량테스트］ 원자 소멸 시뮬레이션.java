import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
    
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    
    static int[][] grid = new int[4001][4001];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine());
         
            // 각 원자 정보(int 배열)를 저장하는 큐
            //  -> 리스트나 배열은 인덱스를 관리해야함
            //  -> 제거하는 경우가 발생하기 때문에 인덱스 관리 필요 없는 큐로 접근
            Queue<int[]> q = new ArrayDeque<>();  

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int d = Integer.parseInt(st.nextToken());
                int k = Integer.parseInt(st.nextToken());

                // 음수 좌표 + 0.5초 단위 처리
                x = (x + 1000) * 2;
                y = (y + 1000) * 2;
                
                // 원자 정보를 int 배열 형태로 큐에 넣기
                q.offer(new int[]{x, y, d, k});
            }

            int total = 0;

            // 남은 원자가 1개 이하면 종료
            while (q.size() >= 2) {
                int size = q.size();
                
                // 현재 존재하는 원자들을 한 번씩 진행(한 스텝)
                for (int i = 0; i < size; i++) {
                    int[] atom = q.poll(); // 원자 하나 꺼냄
                    
                    // 원자 방향에 맞춰서 x, y 이동
                    atom[0] += dx[atom[2]]; 
                    atom[1] += dy[atom[2]]; 

                    // 범위 체크
                    if (atom[0] < 0 || atom[0] > 4000 || atom[1] < 0 || atom[1] > 4000) {
                        continue;
                    }

                    // 이동한 격자의 좌표에 에너지값 누적 후 다시 큐에 저장
                    grid[atom[0]][atom[1]] += atom[3];
                    q.offer(atom); // 이동 완료 후 다시 큐에 넣음
                }

                // 충돌 판별하기
                size = q.size();
                 // 현재 존재하는 원자들을 한 번씩 진행(한 스텝)
                for (int i = 0; i < size; i++) {
                    int[] atom = q.poll();
                    int x = atom[0];
                    int y = atom[1];
                    int k = atom[3]; // 에너지 값
                    
                    if (grid[x][y] == k) {
                        // 격자의 에너지값이 현재 원자 에너지와 같다면 -> 충돌 발생 안함
                        q.offer(atom); // 아직 원자가 남아 있음 -> q에 넣기
                        grid[x][y] = 0; // 덮어쓴 에너지값 리셋 
                        
                    } else if (grid[x][y] > k) { 
                        // 내 에너지보다 맵의 에너지가 크다면 = 누군가와 부딪힘 (충돌)
                        total += grid[x][y]; // 충돌 ->< 해당 격자 값을 전체 합에 더함
                        grid[x][y] = 0;  // 덮어쓴 에너지값 리셋 
                    }
                }
            }
            // 전체 합 결과 출력
            System.out.println("#" + tc + " " + total);
        }
    }
}