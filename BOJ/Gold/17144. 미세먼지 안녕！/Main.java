import java.util.Scanner;



class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int R = sc.nextInt();

        int C = sc.nextInt();

        int T = sc.nextInt();



        int[] dr = { -1, 1, 0, 0 }; // 상하좌우

        int[] dc = { 0, 0, -1, 1 };



        int[][] grid = new int[R][C];

        for (int i = 0; i < R; i++) {

            for (int j = 0; j < C; j++) {

                grid[i][j] = sc.nextInt();

            }

        }



        int[][] grid2 = new int[R][C];

        for (int i = 0; i < R; i++) {

            grid2[i][0] = grid[i][0];

        }



        for (int t = 0; t < T; t++) {

            // 미세먼지 확산

            for (int i = 0; i < R; i++) {

                for (int j = 0; j < C; j++) {

                    if (grid[i][j] > 0) { // 미세먼지가 있으면 4방향 탐색

                        int cnt = 4;

                        for (int d = 0; d < 4; d++) {

                            if (i + dr[d] < 0 || i + dr[d] >= R || j + dc[d] < 0 || j + dc[d] >= C) {

                                cnt--;

                            } else if (grid[i + dr[d]][j + dc[d]] == -1) {

                                cnt--;

                            } else {

                                grid2[i + dr[d]][j + dc[d]] += grid[i][j] / 5;

                            }

                        }

                        grid2[i][j] += (grid[i][j] - (cnt * (grid[i][j] / 5)));

                    }

                }

            }

            boolean isFirst = true;

            for (int i = 0; i < R; i++) {

                if (grid2[i][0] == -1 && isFirst) { // 거꾸로 돌면서 이동시키기

                    // 왼쪽 위로

                    for (int k = i; k > 0; k--) {

                        grid2[k][0] = grid2[k - 1][0];

                    }

                    grid2[i][0] = -1; // 먼지 제거



                    // 위 오른쪽

                    for (int j = 0; j < C - 1; j++) {

                        grid2[0][j] = grid2[0][j + 1];

                    }



                    // 오른쪽 아래

                    for (int k = 0; k < i; k++) {

                        grid2[k][C - 1] = grid2[k + 1][C - 1];

                    }



                    // 아래 왼쪽

                    for (int j = C - 1; j > 1; j--) {

                        grid2[i][j] = grid2[i][j - 1];

                    }

                    grid2[i][1] = 0;

                    isFirst = false;

                } else if (grid2[i][0] == -1 && !isFirst) {

                    // 왼쪽 아래로

                    for (int k = i; k < R - 1; k++) {

                        grid2[k][0] = grid2[k + 1][0];

                    }

                    grid2[i][0] = -1; // 먼지 제거



                    // 아래 오른쪽

                    for (int j = 0; j < C - 1; j++) {

                        grid2[R - 1][j] = grid2[R - 1][j + 1];

                    }



                    // 오른쪽 위

                    for (int k = R - 1; k > i; k--) {

                        grid2[k][C - 1] = grid2[k - 1][C - 1];

                    }



                    // 위 왼쪽

                    for (int j = C - 1; j > 1; j--) {

                        grid2[i][j] = grid2[i][j - 1];

                    }

                    grid2[i][1] = 0;

                }

            }



            int[][] tmp = grid;

            grid = grid2;

            grid2 = tmp;



            grid2 = new int[R][C];

            for (int i = 0; i < R; i++) {

                grid2[i][0] = grid[i][0];

            }



        }



        for (int i = 0; i < R; i++) {

            for (int j = 0; j < C; j++) {

                System.out.print(grid[i][j] + " ");

            }

            System.out.println();

        }



        int res = 2; // -1이 2개인거 처리

        for (int i = 0; i < R; i++) {

            for (int j = 0; j < C; j++) {

                res += grid[i][j];

            }

        }

        System.out.println(res);



    }

}

