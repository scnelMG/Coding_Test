import java.util.Scanner;
import java.util.Stack;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Integer> stack = new Stack<>();

        int N = sc.nextInt();
        for (int i = 0; i < N; i++) {
            String tmp = sc.next();
            if (tmp.equals("push")) {
                stack.push(sc.nextInt());
            } else if (tmp.equals("pop")) {
                if (stack.isEmpty())
                    System.out.println(-1);
                else {
                    System.out.println(stack.pop());
                }

            } else if (tmp.equals("size")) {
                System.out.println(stack.size());
            } else if (tmp.equals("empty")) {
                if (stack.isEmpty())
                    System.out.println(1);
                else
                    System.out.println(0);
            } else if (tmp.equals("top")) {
                if (stack.isEmpty())
                    System.out.println(-1);
                else {
                    System.out.println(stack.peek());
                }
            }
        }

    }
}
