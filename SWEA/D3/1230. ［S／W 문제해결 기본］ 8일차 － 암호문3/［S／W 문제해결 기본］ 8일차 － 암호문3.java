
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int tc = 1; tc <= 10; tc++) {
            int N = Integer.parseInt(br.readLine());
            LinkedList<Integer> ll = new LinkedList<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                ll.add(Integer.parseInt(st.nextToken()));
            }

            int M = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                String order = st.nextToken();
                if (order.equals("I")) {
                    int x = Integer.parseInt(st.nextToken());
                    int y = Integer.parseInt(st.nextToken());
                    for (int j = 0; j < y; j++) {
                        ll.add(x + j, Integer.parseInt(st.nextToken()));
                    }

                }
                if (order.equals("D")) {
                    int x = Integer.parseInt(st.nextToken());
                    int y = Integer.parseInt(st.nextToken());
                    for (int j = 0; j < y; j++) {
                        ll.remove(x);
                    }

                }
                if (order.equals("A")) {
                    int y = Integer.parseInt(st.nextToken());
                    for (int j = 0; j < y; j++) {
                        ll.addLast(Integer.parseInt(st.nextToken()));
                    }
                }
            }
            System.out.print("#" + tc + " ");
            for (int i = 0; i < 10; i++) {
                System.out.print(ll.get(i) + " ");
            }
            System.out.println();

        }

    }
}