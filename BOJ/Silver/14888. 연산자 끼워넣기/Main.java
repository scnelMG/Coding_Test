import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
	static int N;
	static int minV = Integer.MAX_VALUE;
	static int maxV = -1 * Integer.MAX_VALUE;
	static int[] numArr, opers;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine()); // 피연산자 개수
		numArr = new int[N]; // 피연산자 저장 배열
		// 피연산자 배열에 저장
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			numArr[i] = Integer.parseInt(st.nextToken());
		}

		// 연산자 저장
		st = new StringTokenizer(br.readLine());
		opers = new int[4];
		for (int i = 0; i < 4; i++) {
			opers[i] = Integer.parseInt(st.nextToken());
		}

		// 재귀함수 진행
		solve(1, numArr[0]); // idx 1부터 시작, 젤 처음의 피연산자 값으로 연산 결과 시작
		System.out.println(maxV);
		System.out.println(minV);

	}

	// 재귀함수
	static void solve(int idx, int res) {
		if (idx == N) { // 모든 피연산자들을 계산했을 때 return
			// 해당 결과에 대해서 최대, 최소를 갱신
			if (res < minV)
				minV = res;
			if (res > maxV)
				maxV = res;
			return;
		}

		// 4개의 연산자 계산
		// +, -, *, / 순서
		for (int i = 0; i < 4; i++) {
			if (opers[i] == 0) // i번째의 연산자를 사용할 수 있는 횟수가 0이면 계산 안함
				continue;
			// 해당 연산자 사용! -> 횟수 하나 차감
			opers[i]--;

			// i번호를 보고 어떤 연산자인지 판단
			switch (i) {
			case 0:
				// 그 다음 스텝으로 이동하면서, 연산 결과를 가지고 이동
				solve(idx + 1, res + numArr[idx]);
				break;
			case 1:
				solve(idx + 1, res - numArr[idx]);
				break;
			case 2:
				solve(idx + 1, res * numArr[idx]);
				break;
			case 3:
				solve(idx + 1, res / numArr[idx]);
				break;
			}
			// 다시 연산 사용 횟수를 복구 -> 백트래킹
			opers[i]++;
		}
	}
}