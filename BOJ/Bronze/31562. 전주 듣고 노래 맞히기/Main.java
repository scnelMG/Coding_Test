import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		String[][] codes = new String[N][7];
		String[] names = new String[N];

		for (int tc = 0; tc < N; tc++) {
			int T = sc.nextInt();
			String song = sc.next();
			names[tc] = song;
			codes[tc] = new String[7];
			for (int i = 0; i < codes[0].length; i++) {
				codes[tc][i] = sc.next();
			}
		}
		boolean exist = false;
		int idx = -1;
		for (int tc = 0; tc < M; tc++) {
			String input1 = sc.next();
			String input2 = sc.next();
			String input3 = sc.next();
			for (int i = 0; i < N; i++) {
				if (codes[i][0].equals(input1) && codes[i][1].equals(input2) && codes[i][2].equals(input3)) {
					if (!exist) {
						idx = i;
						exist = true;
					} else {
						System.out.println("?");
						break;
					}
				}
			}

			if (exist) {
				System.out.println(names[idx]);
			} else {
				System.out.println("!");
			}

		}

	}
}