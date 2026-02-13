import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int tc = 1; tc <= 10; tc++) {
			int N = Integer.parseInt(sc.nextLine()); // nextLine으로 불러오기
			// 그냥 sc.nextInt하면 오류 -> 숫자 뒤에 개행 문자(Enter)를 처리 안하기 때문
			String[] values = new String[N + 1];

			int[][] arr = new int[N + 1][2]; // 트리 정보 담든 int 배열
			for (int i = 1; i <= N; i++) {
				String[] parts = sc.nextLine().split(" "); // 입력되는 문자 개수가 다름 -> sc.next로 처리 힘듦
				// -> nextLine으로 처리 후 split
				// 배열 크기로 경우 나누기
				if (parts.length == 2) {
					values[i] = parts[1]; // 자기 값(연산자 or 숫자)
				} else {
					values[i] = parts[1]; // 자기 값(연산자 or 숫자)
					arr[i][0] = Integer.parseInt(parts[2]); // 왼쪽
					arr[i][1] = Integer.parseInt(parts[3]); // 오른쪽
				}
			}

			List<String> postifx = new ArrayList<>(); // 리스트에 후위표기식 저장
			postOrder(1, values, arr, postifx);

			int res = (int) evalStack(postifx); // 후위 표기식 계산 with Stack
			System.out.print("#" + tc + " ");
			System.out.println(res);

		}
	}

	public static void postOrder(int idx, String[] values, int[][] arr, List<String> list) {
		// 후위표기식 저장
		if (idx == 0) // 자식노드가 없으면
			return;
		postOrder(arr[idx][0], values, arr, list);
		postOrder(arr[idx][1], values, arr, list);
		list.add(values[idx]);
	}

	public static double evalStack(List<String> postfix) {
		Stack<Double> stack = new Stack<>();

		for (int i = 0; i < postfix.size(); i++) {
			String tmp = postfix.get(i);
			if (tmp.equals("+") || tmp.equals("-") || tmp.equals("*") || tmp.equals("/")) {
				double n1 = stack.pop();
				double n2 = stack.pop();

				switch (tmp) {
				case "+":
					stack.push(n2 + n1);
					break;
				case "-":
					stack.push(n2 - n1);
					break;
				case "*":
					stack.push(n2 * n1);
					break;
				case "/":
					stack.push(n2 / n1);
					break;
				}
			} else {
				stack.push(Double.parseDouble(tmp));
			}
		}
		return stack.pop();
	}
}
