
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {
    static int[][] tree;
    static char[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int tc = 1; tc <= 10; tc++) {
            int N = Integer.parseInt(br.readLine());
            tree = new int[N + 1][2];
            arr = new char[N + 1];
            for (int i = 0; i < N; i++) {
                String[] s = br.readLine().split(" ");
                int node = Integer.parseInt(s[0]);
                char value = s[1].charAt(0);
                arr[node] = value;
                if (s.length == 4) {
                    int left = Integer.parseInt(s[2]);
                    int right = Integer.parseInt(s[3]);
                    tree[node][0] = left;
                    tree[node][1] = right;

                }
                if (s.length == 3) {
                    arr[node] = value;
                    int left = Integer.parseInt(s[2]);
                    tree[node][0] = left;
                }

            }
            System.out.println("#" + tc + " ");
            inorder(1);
            System.out.println();

        }

    }

    static void inorder(int idx) {
        if (idx == 0) {
            return;
        }
        inorder(tree[idx][0]);
        System.out.print(arr[idx]);
        inorder(tree[idx][1]);

    }
}