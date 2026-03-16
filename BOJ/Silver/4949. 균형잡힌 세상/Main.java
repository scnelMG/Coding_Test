import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			String s = br.readLine();
			if (s.equals("."))
				break;

			Stack<Character> stack = new Stack<>();
			boolean isGood = true;
			for (int i = 0; i < s.length(); i++) {
				char tmp = s.charAt(i);
				if (tmp == '(' || tmp == '[')
					stack.push(tmp);
				if (tmp == ')') {
					if (stack.isEmpty() || stack.pop() != '(')
						isGood = false;
				}
				if (tmp == ']') {
					if (stack.isEmpty() || stack.pop() != '[')
						isGood = false;
				}

			}
			if (!stack.isEmpty())
				isGood = false;

			if (isGood)
				System.out.println("yes");
			else {
				System.out.println("no");
			}
		}

	}
}