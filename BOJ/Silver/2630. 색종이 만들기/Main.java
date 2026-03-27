import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] grid;
    static int white = 0; // 0의 개수
    static int blue = 0;  // 1의 개수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        grid = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 전체 크기(N)에 대해 0,0 좌표부터 확인 시작
        divide(0, 0, N);

        System.out.println(white);
        System.out.println(blue);
    }

    static void divide(int row, int col, int size) {
        // 1. 현재 영역이 모두 같은 색인지 체크
        if (checkColor(row, col, size)) {
            if (grid[row][col] == 0) white++;
            else blue++;
            return; // 같은 색이면 더 이상 자를 필요 없음
        }

        // 2. 같은 색이 아니라면 4등분 (Size를 절반으로)
        int newSize = size / 2;
        
        divide(row, col, newSize);                         // 왼쪽 위
        divide(row, col + newSize, newSize);               // 오른쪽 위
        divide(row + newSize, col, newSize);               // 왼쪽 아래
        divide(row + newSize, col + newSize, newSize);     // 오른쪽 아래
    }

    // 영역 내 모든 칸이 같은 색인지 확인하는 함수
    static boolean checkColor(int row, int col, int size) {
        int color = grid[row][col]; // 첫 번째 칸 색깔 기준
        
        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                if (grid[i][j] != color) {
                    return false; // 하나라도 다르면 false
                }
            }
        }
        return true;
    }
}