import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int tc = 1; tc <= 10; tc++) {
			int N = Integer.parseInt(sc.nextLine()); // nextLine으로 불러오기
			// 그냥 sc.nextInt하면 오류 -> 숫자 뒤에 개행 문자(Enter)를 처리 안하기 때문
			String[] values = new String[N + 1]; // String 값 따로 저장하는 배열
			int[][] arr = new int[N + 1][2]; // 트리 정보 담든 int 배열
			for (int i = 1; i <= N; i++) {
				String[] parts = sc.nextLine().split(" "); // 입력되는 문자 개수가 다름 -> sc.next로 처리 힘듦
				// -> nextLine으로 처리 후 split
				// 배열 크기로 경우 나누기
				if (parts.length == 2) {
					values[i] = parts[1]; // 자기 값
				} else if (parts.length == 3) {
					values[i] = parts[1]; // 자기 값
					arr[i][0] = Integer.parseInt(parts[2]); // 왼쪽
				} else {
					values[i] = parts[1]; // 자기 값
					arr[i][0] = Integer.parseInt(parts[2]); // 왼쪽
					arr[i][1] = Integer.parseInt(parts[3]); // 오른쪽
				}
			}
			System.out.print("#" + tc + " ");
			inOrder(1, values, arr); // 중위 순회
			System.out.println();
		}
	}

	public static void inOrder(int idx, String[] values, int[][] arr) {
		if (idx == 0 || idx > values.length)
			return;
		inOrder(arr[idx][0], values, arr);
		System.out.print(values[idx]);
		inOrder(arr[idx][1], values, arr);
	}
}
