import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int tc = 1; tc <= 10; tc++) {
			int N = Integer.parseInt(sc.nextLine()); // nextLine으로 불러오기
			// 그냥 sc.nextInt하면 오류 -> 숫자 뒤에 개행 문자(Enter)를 처리 안하기 때문
			String[] values = new String[N + 1];

			int[][] arr = new int[N + 1][2]; // 트리 정보 담든 int 배열
			for (int i = 1; i <= N; i++) {
				String[] parts = sc.nextLine().split(" "); // 입력되는 문자 개수가 다름 -> sc.next로 처리 힘듦
				// -> nextLine으로 처리 후 split
				// 배열 크기로 경우 나누기
				if (parts.length == 2) {
					values[i] = parts[1]; // 자기 값(연산자 or 숫자)
				} else {
					values[i] = parts[1]; // 자기 값(연산자 or 숫자)
					arr[i][0] = Integer.parseInt(parts[2]); // 왼쪽
					arr[i][1] = Integer.parseInt(parts[3]); // 오른쪽
				}
			}
			int res = (int) postOrder(1, values, arr);
			System.out.print("#" + tc + " ");
			System.out.println(res);

		}
	}

	public static double postOrder(int idx, String[] values, int[][] arr) {
		if (arr[idx][0] == 0 && arr[idx][1] == 0) {
			return Double.parseDouble(values[idx]); // 둘 다 자식이 없다 -> 숫자임
		}

		double left = postOrder(arr[idx][0], values, arr); // 왼쪽 값(얘는 숫자)
		double right = postOrder(arr[idx][1], values, arr); // 오른쪽 값(얘도 숫자)

		switch (values[idx]) { // 연산자 별 계산 결과 return
		case "+":
			return left + right;
		case "-":
			return left - right;
		case "*":
			return left * right;
		case "/":
			return left / right;
		default:
			return 0;
		}
	}
}
