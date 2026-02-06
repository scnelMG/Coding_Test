import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

class Solution {
	public static void main(String args[]) throws Exception {

		Scanner sc = new Scanner(System.in);
		Map<Character, Integer> prior = new HashMap<>();
		prior.put('(', 0);
		prior.put('+', 1);
		prior.put('*', 2);

		for (int test_case = 1; test_case <= 10; test_case++) {

			int N = sc.nextInt();
			String input = sc.next();

			// 후위 표기식으로 바꾼 결과 저장
			StringBuilder res = new StringBuilder();
			// 연산자 저장 스택
			Stack<Character> stack = new Stack<>();

			for (int i = 0; i < input.length(); i++) {
				char tmp = input.charAt(i); // 인풋되는 값

				// 숫자일 경우
				if (tmp >= '0' && tmp <= '9') {
					res.append(tmp);
				}

				// 여는 괄호일 경우
				else if (tmp == '(')
					stack.push(tmp);

				// 닫는 괄호일 경우
				else if (tmp == ')') {
					while (stack.peek() != '(') { // 여는 괄호가 나올 때 까지 연산자를 결과에 저장
						res.append(stack.pop());
					}
					stack.pop(); // 여는 괄호 스택에서 제거
				} else {
					if (stack.isEmpty()) // 스택이 비어 있으면 바로 넣기
						stack.push(tmp);
					else {
						// 스택이 비어있지 않고, 스택 top 연산자가 인풋된 연산자보다 우선순위가 높거나 같을 동안
						// 스택이 비어있거나, 스택 top 연산자가 인풋된 연산자보다 우선순위가 낮으면 중단
						while (!stack.isEmpty() && prior.get(stack.peek()) >= prior.get(tmp)) {
							res.append(stack.pop()); // top 연산자를 결과에 저장
						}
						stack.push(tmp); // 인풋된 연산자를 스택에 저장
					}
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
				} else if (tmp == '*') { // * 면 스택 속 값 2개 빼와서, 곱한 값 다시 넣기
					int v1 = resStack.pop();
					int v2 = resStack.pop();
					resStack.push(v1 * v2);
				} else {
					resStack.push(tmp - '0'); // 그냥 숫자면 스택에 그 값 그대로 넣기
				}

			}
			System.out.println("#" + test_case + " " + resStack.pop());

		}
	}
}