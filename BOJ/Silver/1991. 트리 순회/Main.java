import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[][] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        tree = new int[N + 1][2];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int idx = st.nextToken().charAt(0) - 'A' + 1;
            char tmp = st.nextToken().charAt(0);
            if (tmp != '.') {
                int left = tmp - 'A' + 1;
                tree[idx][0] = left;
            }

            tmp = st.nextToken().charAt(0);
            if (tmp != '.') {
                int right = tmp - 'A' + 1;
                tree[idx][1] = right;
            }

        }
        preOrder(1);
        System.out.println();
        inOrder(1);
        System.out.println();
        postOrder(1);
    }

    static void preOrder(int idx) {
        if (idx == 0)
            return;

        System.out.print((char) (idx - 1 + 'A'));
        preOrder(tree[idx][0]);
        preOrder(tree[idx][1]);

    }

    static void inOrder(int idx) {
        if (idx == 0)
            return;

        inOrder(tree[idx][0]);
        System.out.print((char) (idx - 1 + 'A'));
        inOrder(tree[idx][1]);
    }

    static void postOrder(int idx) {
        if (idx == 0)
            return;

        postOrder(tree[idx][0]);
        postOrder(tree[idx][1]);
        System.out.print((char) (idx - 1 + 'A'));
    }
}