package 박민규.CodeTree.왔다갔던구역2;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[2000 + 1];
		int now = 1000; // 현재 위치 인덱스

		for (int i = 0; i < N; i++) {
			int x = sc.nextInt();
			char dir = sc.next().charAt(0);

			if (dir == 'R') { // 오른쪽 이동
				for (int j = 0; j < x; j++) {
					arr[now]++;
					now++;
				}

			} else { // 왼쪽 이동
				for (int j = 0; j < x; j++) {
					now--;
					arr[now]++;
				}
			}
		}
		int cnt = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] >= 2)
				cnt++;
		}
		System.out.println(cnt);
	}
}