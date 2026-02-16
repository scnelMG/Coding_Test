import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        StringBuilder out = new StringBuilder();
        Stack<Character> st = new Stack<>();

        boolean inTag = false;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '<') {
                // 단어 끝났으니 뒤집어서 출력
                while (!st.isEmpty())
                    out.append(st.pop());

                inTag = true;
                out.append(ch);

            } else if (ch == '>') {
                inTag = false;
                out.append(ch);

            } else {
                if (inTag) {
                    // 태그 안은 그대로
                    out.append(ch);
                } else {
                    if (ch == ' ') {
                        // 단어 끝 → 뒤집기
                        while (!st.isEmpty())
                            out.append(st.pop());
                        out.append(' ');
                    } else {
                        st.push(ch);
                    }
                }
            }
        }

        // 마지막 단어 처리
        while (!st.isEmpty())
            out.append(st.pop());

        System.out.println(out);
    }
}
