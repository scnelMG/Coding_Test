package 박민규.CodeTree.도미노정렬하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            arr[num] = i;
        }

        // --- 여기서부터 수정된 부분 ---
        int maxCnt = 1; // 가장 길었던 연속 수열의 길이
        int currentCnt = 1; // 현재 세고 있는 연속 수열의 길이

        for (int i = 1; i < N; i++) {
            if (arr[i] < arr[i + 1]) { // 위치가 정상적으로 뒤에 있다면
                currentCnt++;
                if (currentCnt > maxCnt) {
                    maxCnt = currentCnt; // 최댓값 갱신
                }
            } else {
                // 위치가 역주행했다면, 끊어진 것이므로 1부터 다시 세기!
                currentCnt = 1;
            }
        }

        System.out.println(N - maxCnt);
    }
}