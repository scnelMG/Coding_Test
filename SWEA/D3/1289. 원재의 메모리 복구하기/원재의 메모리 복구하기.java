import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) { // 테스트 케이스 입력
			String s = sc.next();
			boolean isOne = false; // 이전에 1이 있었는가
			int res = 0; // 바꿔야하는 개수
			for (int i = 0; i < s.length(); i++) {
				if (!isOne && s.charAt(i) == '1') { // 이전에 1이 없었고, 1이 들어오면
					isOne = true; // 1이 있다 하고
					res++; // 바꿔야하는 횟수 추가 +1
				} else if (isOne && s.charAt(i) == '0') { // 이전에 1이 있었고, 0이 들어오면
					isOne = false; // 1이 없다 하고
					res++; // 바꿔야하는 횟수 추가 +1
				}
			}
			System.out.println("#" + tc + " " + res);

		}
	}

}
