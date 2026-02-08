import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			Stack<Integer> stack = new Stack<>();
			int K = sc.nextInt();
			int res = 0;
			for (int i = 0; i < K; i++) {
				int n = sc.nextInt();
				if (n == 0) { // 0 이면 pop
					// 0일 경우에 지울 수 있는 수가 있다고 보장 -> 비었는지 확인 불필요
					stack.pop();
				} else { // 아니면 push
					stack.push(n);
				}
			}
			// 스택 내 숫자 합 도출
			for (int i = 0; i < stack.size(); i++) {
				res += stack.get(i);
			}
			System.out.println("#" + tc + " " + res);
		}
	}
}
