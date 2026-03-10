
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        char[][] arr = new char[N][M];
        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine().toCharArray();
        }

        int res = 0;
        for (int i = 0; i < N; i++) {
            boolean isContinue = false;
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == '-') {
                    if (!isContinue) {
                        res++;
                    }
                    if (j < M - 1 && arr[i][j + 1] == '-') {
                        isContinue = true;
                    } else {
                        isContinue = false;
                    }
                }
            }
        }

        for (int j = 0; j < M; j++) {
            boolean isContinue = false;
            for (int i = 0; i < N; i++) {
                if (arr[i][j] == '|') {
                    if (!isContinue)
                        res++;

                    if (i < N - 1 && arr[i + 1][j] == '|') {
                        isContinue = true;
                    } else {
                        isContinue = false;
                    }
                }
            }
        }

        System.out.println(res);

    }
}