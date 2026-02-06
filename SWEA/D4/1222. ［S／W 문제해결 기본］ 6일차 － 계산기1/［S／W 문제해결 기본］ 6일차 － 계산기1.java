import java.util.Scanner;
import java.util.Stack;

class Solution {
	public static void main(String args[]) throws Exception {

		Scanner sc = new Scanner(System.in);

		for (int test_case = 1; test_case <= 10; test_case++) {

			int N = sc.nextInt();
			String input = sc.next();

			// 후위 표기식으로 바꾼 결과 저장
			StringBuilder res = new StringBuilder();
			Stack<Character> stack = new Stack<>();

			for (int i = 0; i < input.length(); i++) {
				char tmp = input.charAt(i);
				if (tmp == '+') { // +가 들어오면
					if (!stack.isEmpty()) { // 스택 비어있지 않으면 결과에 저장 -> + + 끼리 비교니까 차피 결과에 들어감
						res.append(stack.pop());
					}
					stack.push(tmp); // 스택 비어있으면 + 연산자 넣기

				} else { // +가 아닌 숫자가 들어오면
					res.append(tmp); // 결과에 바로 저장
				}

			}
			while (!stack.isEmpty()) { // 스택에 연산자 남아있는거 다 결과에 저장
				res.append(stack.pop());
			}

			Stack<Integer> resStack = new Stack<>(); // 연산에 사용할 스택 생성
			for (int i = 0; i < res.length(); i++) {
				char tmp = res.charAt(i);
				if (tmp == '+') { // + 면 스택 속 값 2개 빼와서, 더한 값 다시 넣기
					int v1 = resStack.pop();
					int v2 = resStack.pop();
					resStack.push(v1 + v2);
				} else {
					resStack.push(tmp - '0'); // 그냥 숫자면 스택에 그 값 그대로 넣기
				}

			}
			System.out.println("#" + test_case + " " + resStack.pop());

		}
	}
}