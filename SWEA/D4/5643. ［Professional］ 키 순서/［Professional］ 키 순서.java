import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
 
class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
 
        for (int tc = 1; tc <= T; tc++) {
            int N = sc.nextInt();
            int M = sc.nextInt();
 
            // 정방향 인접리스트
            List<Integer>[] adjList = new ArrayList[N + 1];
 
            // 역방향 인접리스트
            List<Integer>[] adjListRev = new ArrayList[N + 1];
 
            // 리스트 초기화
            for (int i = 1; i <= N; i++) {
                adjList[i] = new ArrayList<>();
                adjListRev[i] = new ArrayList<>();
            }
 
            // 인접리스트에 관계 정보 넣기
            for (int i = 0; i < M; i++) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                adjList[a].add(b);
                adjListRev[b].add(a);
            }
 
            // 키 알 수 있는 학생 수
            int res = 0;
            for (int i = 1; i <= N; i++) {
                int cnt = bfs(i, N, adjList);
                int cntRev = bfs(i, N, adjListRev);
 
                // 정방향으로 연결된 학생수 + 역방향으로 연결된 학생수 = 자기를 제외한 학생 수
                // 이면 키가 몇번째인지 알 수 있음
                if (cnt + cntRev == N - 1)
                    res++;
            }
            System.out.println("#" + tc + " " + res);
 
        }
    }
 
    // 연결된 학생 수 구하는 bfs 함수
    static int bfs(int i, int n, List<Integer>[] arr) {
        Queue<Integer> q = new ArrayDeque<>();
        boolean[] visited = new boolean[n + 1];
        q.add(i);
        visited[i] = true;
 
        int cnt = 0;
        while (!q.isEmpty()) {
            int cur = q.poll();
 
            for (int next : arr[cur]) {
                if (!visited[next]) {
                    visited[next] = true;
                    q.add(next);
                    cnt++;
                }
            }
        }
 
        return cnt;
    }
}