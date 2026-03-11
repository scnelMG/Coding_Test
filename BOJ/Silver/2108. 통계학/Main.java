import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		int[] cntArr = new int[8001];

		double mean = 0.0;
		int maxV = Integer.MIN_VALUE;
		int minV = Integer.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());
			mean += num;
			cntArr[num + 4000]++;
			arr[i] = num;

			if (num > maxV)
				maxV = num;
			if (num < minV)
				minV = num;
		}
		
		Arrays.sort(arr);
		
		int maxFreq = 0;
		// 가장 높은 빈도수 찾기
		for (int i = 0; i <= 8000; i++) {
			if (cntArr[i] > maxFreq) {
				maxFreq = cntArr[i];
			}
		}
		
		int mode = 0;
		boolean isSecond = false;
		for (int i = 0; i <= 8000; i++) {
			if (cntArr[i] == maxFreq) {
				mode = i - 4000; // 실제 숫자로 복원
				if (isSecond) {
					break; // 두 번째로 작은 최빈값을 찾았으므로 즉시 탈출!
				}
				isSecond = true; // 첫 번째 최빈값을 찾았다고 표시
			}
		}
		
		mean /= N;
		System.out.println((int) Math.round(mean));
		System.out.println(arr[N/2]);
		System.out.println(mode);
		System.out.println(maxV - minV);
	}

}