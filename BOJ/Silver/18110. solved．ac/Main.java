import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(arr);
		int cutNum = (int) Math.round(((double) N / 100) * 15);

		int res = 0;
		for (int i = cutNum; i < arr.length - cutNum; i++) {
			res += arr[i];
		}
		res = (int) Math.round((double)res / (arr.length - 2 * cutNum));
		System.out.println(res);

	}
}