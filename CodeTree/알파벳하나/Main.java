package 박민규.CodeTree.알파벳하나;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[26];

		for (int i = 0; i < N; i++) {
			String s = sc.next();
			for (int j = 0; j < N; j++) {
				arr[s.charAt(j) - 65]++;
			}
		}

		int max_v = -1;
		int maxIdx = -1;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > max_v) {
				max_v = arr[i];
				maxIdx = i;
			}

		}

		System.out.println(N * N - max_v + " " + (char) (maxIdx + 'A'));

	}
}