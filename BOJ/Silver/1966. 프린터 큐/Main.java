
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            Queue<int[]> q = new ArrayDeque<>();

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                q.add(new int[] { i, Integer.parseInt(st.nextToken()) });
            }

            int cnt = 0;
            while (!q.isEmpty()) {
                int[] first = q.poll();
                boolean isMax = true;

                for (int i = 0; i < q.size(); i++) {
                    int[] cur = q.poll();
                    if (first[1] < cur[1])
                        isMax = false;
                    q.add(cur);
                }

                if (isMax) {
                    cnt++;
                    if (first[0] == M) {
                        System.out.println(cnt);
                        break;
                    }

                } else {
                    q.add(first);
                }
            }

        }
    }

}