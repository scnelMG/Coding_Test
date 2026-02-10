package 박민규.CodeTree.좌우로움직이는로봇;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();

		int[] aList = new int[1000001];
		int[] bList = new int[1000001];

		int aTime = 1;
		int aPos = 0;

		for (int i = 0; i < N; i++) {
			int t = sc.nextInt();
			String d = sc.next();
			for (int j = 0; j < t; j++) {
				if (d.equals("L"))
					aPos--;
				else
					aPos++;
				aList[aTime++] = aPos;
			}
		}

		int bTime = 1;
		int bPos = 0;

		for (int i = 0; i < M; i++) {
			int t = sc.nextInt();
			String d = sc.next();
			for (int j = 0; j < t; j++) {
				if (d.equals("L"))
					bPos--;
				else
					bPos++;
				bList[bTime++] = bPos;
			}
		}

		int maxTime = Math.max(aTime, bTime);
		if (aTime < maxTime) {
			for (int i = aTime; i < maxTime; i++) {
				aList[i] = aList[aTime - 1];
			}
		}
		if (bTime < maxTime) {
			for (int i = bTime; i < maxTime; i++) {
				bList[i] = bList[bTime - 1];
			}
		}

		int res = 0;
		for (int i = 1; i < maxTime - 1; i++) {
			if (aList[i] != bList[i] && aList[i + 1] == bList[i + 1]) {
				res++;
			}
		}

		System.out.println(res);

	}
}
