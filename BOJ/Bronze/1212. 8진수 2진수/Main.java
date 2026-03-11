import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();

		if (s.equals("0")) {
			System.out.println("0");
			return;
		}

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < s.length(); i++) {
			int num = s.charAt(i) - '0';

			if (i == 0) {
				// 1. 첫 번째 팔진수 (앞의 0 생략하고 1부터 출력)
				for (int j = 2; j >= 0; j--) {
					int div = 1 << j;
					int bit = num / div;

					// 아직 한 글자도 안 썼는데 0이 나오면 그냥 버림
					if (sb.length() == 0 && bit == 0) {
						num %= div;
						continue;
					}

					sb.append(bit);
					num %= div;
				}
			} else {
				// 2. 두 번째 자릿수부터는 무조건 3자리 꽉 채워서 출력
				for (int j = 2; j >= 0; j--) {
					int div = 1 << j;
					sb.append(num / div);
					num %= div;
				}
			}
		}

		System.out.println(sb.toString());
	}
}