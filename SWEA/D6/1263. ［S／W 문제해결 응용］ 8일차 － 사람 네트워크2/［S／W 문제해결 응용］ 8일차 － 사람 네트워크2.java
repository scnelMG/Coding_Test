import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        
        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine()); 
            int N = Integer.parseInt(st.nextToken());
            int[][] adjArr = new int[N][N];
            
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    adjArr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int minV = Integer.MAX_VALUE;
            int[] visited = new int[N]; 
            int[] q = new int[N]; // 속도를 극대화하는 커스텀 큐

            for (int i = 0; i < N; i++) {
                int head = 0;
                int tail = 0;
                int dist = 1;
                int total = 0;
                int visitedCount = 1; // 발견한 노드 개수 추적 (자신 포함 1개)

                q[tail++] = i;
                visited[i] = i + 1; // 방문 마커 재사용

                boolean isAllVisited = false;

                while (head < tail && !isAllVisited) {
                    int size = tail - head;
                    
                    for (int j = 0; j < size; j++) {
                        int cur = q[head++]; 
                        
                        for (int k = 0; k < N; k++) { 
                            if (adjArr[cur][k] == 1 && visited[k] != i + 1) { 
                                visited[k] = i + 1; 
                                total += dist; 
                                visitedCount++; // 노드 발견! 카운트 증가
                                
                                //핵심 조기 종료 로직
                                // 전체 노드를 다 발견했다면 더 이상 탐색할 필요가 없음
                                if (visitedCount == N) {
                                    isAllVisited = true;
                                    break;
                                }
                                q[tail++] = k; 
                            }
                        }
                        if (isAllVisited) break; // 외부 for문도 즉시 탈출
                    }
                    dist++; 
                }
                minV = Math.min(minV, total);
            }
            System.out.println("#" + tc + " " + minV);
        }
    }
}