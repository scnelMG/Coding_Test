package 박민규.CodeTree.선두를지켜라;

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
			int v = sc.nextInt();
			int t = sc.nextInt();
			for (int j = 0; j < t; j++) {
				aPos += v;
				aList[aTime++] = aPos;
			}
		}

		int bTime = 1;
		int bPos = 0;

		for (int i = 0; i < M; i++) {
			int v = sc.nextInt();
			int t = sc.nextInt();
			for (int j = 0; j < t; j++) {
				bPos += v;
				bList[bTime++] = bPos;
			}
		}

		int res = 0;
		int bigA = -1;
		for (int i = 1; i < aTime - 1; i++) {
			if (bigA == 0 && aList[i] > bList[i]) { //
				bigA = 1;
				res++;
			} else if (bigA == 1 && aList[i] < bList[i]) {
				bigA = 0;
				res++;
			} else if (aList[i] > bList[i])
				bigA = 1;
			else if (aList[i] < bList[i])
				bigA = 0;
		}
		System.out.println(res);

	}
}
