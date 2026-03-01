
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Deque<Integer> q = new LinkedList<>();
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            String command = br.readLine();
            if (command.contains("push")) {
                StringTokenizer st = new StringTokenizer(command);
                st.nextToken();
                q.add(Integer.parseInt(st.nextToken()));

            } else if (command.contains("pop")) {
                if (q.isEmpty()) {
                    sb.append(-1);
                } else {
                    sb.append(q.pop());
                }
                sb.append("\n");

            } else if (command.contains("size")) {
                sb.append(q.size());
                sb.append("\n");

            } else if (command.contains("empty")) {
                if (q.isEmpty()) {
                    sb.append(1);
                } else {
                    sb.append(0);
                }
                sb.append("\n");
            } else if (command.contains("front")) {
                if (q.peekFirst() == null) {
                    sb.append(-1);
                } else {
                    sb.append(q.peekFirst());
                }
                sb.append("\n");

            } else if (command.contains("back")) {
                if (q.peekLast() == null) {
                    sb.append(-1);
                } else {
                    sb.append(q.peekLast());
                }
                sb.append("\n");
            }

        }

        System.out.println(sb.toString());

    }
}
