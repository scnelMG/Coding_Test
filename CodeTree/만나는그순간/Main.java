package 박민규.CodeTree.만나는그순간;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();

		int[] aList = new int[10000001]; // 각 인덱스가 시간을 의미
		int[] bList = new int[10000001];

		int aTime = 1;
		int aPos = 0;
		for (int i = 0; i < N; i++) {
			String d = sc.next();
			int t = sc.nextInt();
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
			String d = sc.next();
			int t = sc.nextInt();
			for (int j = 0; j < t; j++) {
				if (d.equals("L"))
					bPos--;
				else
					bPos++;
				bList[bTime++] = bPos;
			}
		}

		for (int i = 1; i < aTime; i++) {
			if (aList[i] == bList[i]) {
				System.out.println(i);
				return;
			}
		}
		
		System.out.println(-1);

	}
}
