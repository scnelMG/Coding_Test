import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int M = Integer.parseInt(br.readLine());

		// 1부터 20까지의 숫자가 집합에 있는지 체크하기 위한 배열 (인덱스를 바로 사용하기 위해 크기를 21로 설정)
		boolean[] set = new boolean[21];

		// 결과를 한 번에 모아서 출력하기 위해 for문 밖에 선언
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String cmd = st.nextToken();

			// all과 empty는 뒤에 숫자가 오지 않으므로 먼저 처리합니다.
			if (cmd.equals("all")) {
				for (int k = 1; k <= 20; k++) {
					set[k] = true;
				}
			} else if (cmd.equals("empty")) {
				for (int k = 1; k <= 20; k++) {
					set[k] = false;
				}
			} else {
				// 숫자가 필요한 명령어들
				int num = Integer.parseInt(st.nextToken());

				switch (cmd) {
				case "add":
					set[num] = true;
					break;
				case "remove":
					set[num] = false;
					break;
				case "check":
					if (set[num]) {
						sb.append("1\n");
					} else {
						sb.append("0\n");
					}
					break;
				case "toggle":
					set[num] = !set[num]; // true면 false로, false면 true로 반전
					break;
				}
			}
		}
		

		// 마지막에 한 번에 출력
		System.out.print(sb.toString());
	}
}