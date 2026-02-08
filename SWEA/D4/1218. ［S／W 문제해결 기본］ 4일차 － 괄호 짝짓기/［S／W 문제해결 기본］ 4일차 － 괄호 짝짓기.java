import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;
 
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
 
        for (int tc = 1; tc <= 10; tc++) {
            int N = sc.nextInt();
            int isGood = 1; // 유효 여부
            String input = sc.next();
            Stack<Character> stack = new Stack<>();
 
            for (int i = 0; i < N; i++) {
                char ch = input.charAt(i); // 대상 문자 하나
 
                if (ch == '(' || ch == '[' || ch == '{' || ch == '<') { // 여는 문자 -> push
                    stack.push(ch);
                } else { // 닫는 문자의 경우
                    if (stack.isEmpty()) { // 비었는데 닫는 문자 -> 유효X -> break
                        isGood = 0;
                        break;
                    }
 
                    // 괄호 짝인지 확인
                    char top = stack.peek();
                    if ((ch == ')' && top == '(') || (ch == ']' && top == '[') || (ch == '}' && top == '{')
                            || (ch == '>' && top == '<')) {
                        stack.pop();
                    } else {
                        isGood = 0;
                        break;
                    }
 
                } // 닫는 문자 if 문
            }
 
            if (!stack.isEmpty()) { // 전체 다 돌고 스택 비었는지 확인
                isGood = 0;
            }
 
            System.out.println("#" + tc + " " + isGood);
 
        }
    }
}