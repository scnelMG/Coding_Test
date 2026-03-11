import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        int current = 1; // 스택에 넣을 차례인 다음 숫자를 기억하는 변수

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());

            // 1. 입력받은 숫자(num)에 도달할 때까지 오름차순으로 스택에 push
            while (current <= num) {
                stack.push(current);
                sb.append("+\n");
                current++; // 다음 숫자를 위해 1 증가
            }

            // 2. 스택의 맨 위 숫자가 입력받은 숫자와 일치하는지 확인
            if (stack.peek() == num) {
                stack.pop();
                sb.append("-\n");
            } else {
                // 맨 위 숫자가 num과 다르다면(num보다 크다면) 불가능한 수열!
                System.out.println("NO");
                return; // 더 이상 진행할 필요 없이 프로그램 즉시 종료
            }
        }

        // 3. 끝까지 통과했다면 저장해둔 +, - 기호들 출력
        System.out.println(sb.toString());
    }
}