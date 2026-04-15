import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine());
            List<int[]> manList = new ArrayList<>();
            List<int[]> stairList = new ArrayList<>();

            // 데이터 저장 완료
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    int num = Integer.parseInt(st.nextToken());
                    if (num == 1) // 사람 위치 저장
                        manList.add(new int[] { i, j });
                    else if (num > 1) { // 계단 위치 저장
                        stairList.add(new int[] { i, j, num });
                    }
                }
            }

            int minV = Integer.MAX_VALUE;
            int manNum = manList.size();

            // 비트 마스킹으로 부분집합 구하기
            for (int i = 0; i < (1 << manNum); i++) {
                List<Integer> stair1Arrival = new ArrayList<>();
                List<Integer> stair2Arrival = new ArrayList<>();

                for (int j = 0; j < manNum; j++) {
                    int r = manList.get(j)[0];
                    int c = manList.get(j)[1];
	
                    if (((i & (1 << j)) != 0)) {
                        stair1Arrival.add(Math.abs(r - stairList.get(0)[0]) + Math.abs(c - stairList.get(0)[1]));
                    } else {
                        stair2Arrival.add(Math.abs(r - stairList.get(1)[0]) + Math.abs(c - stairList.get(1)[1]));
                    }
                }

                // 먼저 도착한 사람부터 처리하기 위해 도착 시간 오름차순 정렬
                Collections.sort(stair1Arrival);
                Collections.sort(stair2Arrival);

                int time1 = simulation(stair1Arrival, stairList.get(0)[2]);
                int time2 = simulation(stair2Arrival, stairList.get(1)[2]);

                int finalTime = Math.max(time1, time2);
                minV = Math.min(minV, finalTime);
            }

            System.out.println("#" + tc + " " + minV);
        }
    }

    static int simulation(List<Integer> stairArrival, int size) {
        if (stairArrival.isEmpty())
            return 0;

        Queue<Integer> q = new ArrayDeque<>();
        int lastTime = 0;

        for (int arr : stairArrival) {
            int start;
            if (q.size() < 3) {
                start = arr + 1;
            } else {
                // 큐가 3명으로 꽉 찼으면, 가장 먼저 빠져나가는 사람 시간과 비교
                start = Math.max(arr + 1, q.poll());
            }
            lastTime = start + size;
            q.offer(lastTime);
        }
        return lastTime;
    }
}