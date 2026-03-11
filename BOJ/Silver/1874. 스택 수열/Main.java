import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		Stack<Integer> stack = new Stack<>();
		List<Integer> list = new ArrayList<>();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			int num = arr[i];
			if (stack.empty()) {
				for (int j = 1; j <= num; j++) {
					list.add(j);
					stack.push(j);
					sb.append("+\n");

				}
			}
			if (stack.peek() < num) {
				for (int j = stack.peek(); j <= num; j++) {
					if (!list.contains(j)) {
						list.add(j);
						stack.push(j);
						sb.append("+\n");
					}
				}
			}

			if (stack.peek() == num) {
				stack.pop();
				sb.append("-\n");
			}

		}
		if (!stack.empty()) {
			System.out.println("NO");
		}

		else {
			System.out.println(sb.toString());
		}
	}
}
