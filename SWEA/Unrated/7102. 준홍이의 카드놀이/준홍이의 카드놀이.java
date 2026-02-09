import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			int[] cntArr = new int[N + M + 1]; // N+M까지 인덱스를 가져야하므로 -> N+M+1 크기 배열 생성
			for (int i = 1; i <= N; i++) { // (1~N), (1~M) 두 수의 합을 구하고 그 합에 해당하는 인덱스에 개수 늘리기
				for (int j = 1; j <= M; j++) {
					cntArr[i + j]++; // 두 수 합에 해당하는 인덱스에 접근해서 + 1
				}
			}

			int max_v = -1;
			for (int i = 0; i < cntArr.length; i++) { // 개수 젤 많은거 구하기
				if (max_v < cntArr[i])
					max_v = cntArr[i];
			}

			System.out.print("#" + tc + " ");
			for (int i = 0; i < cntArr.length; i++) { // 개수 젤 많은 것들의 인덱스 추출
				if (cntArr[i] == max_v)
					System.out.print(i + " ");
			}
			System.out.println();

		}
	}

}
