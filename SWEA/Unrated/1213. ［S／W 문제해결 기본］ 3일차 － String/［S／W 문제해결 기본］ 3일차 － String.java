import java.util.Arrays;
import java.util.Scanner;
import java.io.FileInputStream;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);

		for (int test_case = 1; test_case <= 10; test_case++) {
			int T = sc.nextInt();
			char[] search = sc.next().toCharArray();
			char[] input = sc.next().toCharArray();

			int cnt = 0;
			for (int i = 0; i < input.length - search.length + 1; i++) { // 영어문장에서 하나씩 돌기
				boolean isFind = true;

				for (int j = 0; j < search.length; j++) { // 찾아야하는 문자열과 비교
					if (input[i + j] != search[j]) // 다르면 false
						isFind = false;
				}
				if (isFind) {
					cnt++;
				}
			}
			System.out.println("#" + test_case + " " + cnt);
		}
	}
}