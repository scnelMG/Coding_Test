
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Solution {
    static int[][] tree;
    static int res;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            int nodeA = Integer.parseInt(st.nextToken());
            int nodeB = Integer.parseInt(st.nextToken());
            tree = new int[V + 1][3];
            res = 0;

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < E; i++) {
                int nodeP = Integer.parseInt(st.nextToken());
                int nodeC = Integer.parseInt(st.nextToken());
                if (tree[nodeP][0] == 0) {
                    tree[nodeP][0] = nodeC;
                } else {
                    tree[nodeP][1] = nodeC;
                }
                tree[nodeC][2] = nodeP;
            }
            int commonP = findCommonP(nodeA, nodeB);

            subtreeSize(commonP);
            System.out.println("#" + tc + " " + commonP + " " + res);

        }
    }

    static int findCommonP(int nodeA, int nodeB) {
        List<Integer> lstA = new ArrayList<>();
        int p = nodeA;
        while (p != 1) {
            p = tree[p][2];
            lstA.add(p);
        }

        int commonP = nodeB;
        while (true) {
            commonP = tree[commonP][2];
            if (lstA.contains(commonP)) {
                break;
            }
        }

        return commonP;
    }

    static void subtreeSize(int node) {
        if (node == 0) {
            return;
        }
        subtreeSize(tree[node][0]);
        res++;
        subtreeSize(tree[node][1]);
    }

}