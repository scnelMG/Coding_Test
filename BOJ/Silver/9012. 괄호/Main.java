import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			String S = sc.next();
			Stack<Character> stack = new Stack<>();
			boolean isOkay = true;

			for (int i = 0; i < S.length(); i++) {
				char c = S.charAt(i);
				if (c == '(') {
					stack.push(c);
				}

				if (c == ')') {
					if (stack.size() == 0) {
						isOkay = false;
						break;
					} else {
						stack.pop();
					}
				}
			}

			if (stack.size() != 0)
				isOkay = false;
			if (isOkay)
				System.out.println("YES");
			else {
				System.out.println("NO");
			}
		}
	}
}
