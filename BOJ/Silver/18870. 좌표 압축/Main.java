package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int[] arr = new int[N];
		int[] arrSort = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			arrSort[i] = arr[i];
		}
		Arrays.sort(arrSort);

		Map<Integer, Integer> map = new HashMap<>();
		int rank = 0;
		for (int i = 0; i < N; i++) {
			if (!map.containsKey(arrSort[i])) {
				map.put(arrSort[i], rank++);
			}
		}

		for (int i = 0; i < N; i++) {
			System.out.print(map.get(arr[i]) + " ");
		}

	}

}
