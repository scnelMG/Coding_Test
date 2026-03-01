
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Deque<Integer> q = new LinkedList<>();
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            String command = br.readLine();
            if (command.contains("push")) {
                StringTokenizer st = new StringTokenizer(command);
                st.nextToken();
                q.add(Integer.parseInt(st.nextToken()));

            } else if (command.contains("pop")) {
                if (q.isEmpty()) {
                    System.out.println(-1);
                } else {
                    System.out.println(q.pop());
                }

            } else if (command.contains("size")) {
                System.out.println(q.size());

            } else if (command.contains("empty")) {
                if (q.isEmpty()) {
                    System.out.println(1);
                } else {
                    System.out.println(0);
                }
            } else if (command.contains("front")) {
                if (q.peekFirst() == null) {
                    System.out.println(-1);
                } else {
                    System.out.println(q.peekFirst());
                }

            } else if (command.contains("back")) {
                if (q.peekLast() == null) {
                    System.out.println(-1);
                } else {
                    System.out.println(q.peekLast());
                }
            }
        }

    }
}
