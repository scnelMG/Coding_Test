import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int tc = 1; tc <= 10; tc++) {
			LinkedList<Integer> lst = new LinkedList<>(); // 링크드 리스트 생성
			int N = sc.nextInt(); // 원본 암호문 길이
			for (int i = 0; i < N; i++) { // 원본 암호문을 링크드리스트에 저장
				lst.add(sc.nextInt());
			}
			int M = sc.nextInt(); // 삽입 명령어 개수
			for (int i = 0; i < M; i++) {
				String tmp = sc.next(); // I 이거 처리
				int inputIdx = sc.nextInt(); // 삽입 시작 인덱스
				int inputN = sc.nextInt(); // 삽입 개수
				for (int j = 0; j < inputN; j++) {
					lst.add(inputIdx + j, sc.nextInt()); // 삽입 시작 인덱스 부터 삽입 개수 만큼 삽입
				}
			}

			System.out.print("#" + tc + " ");
			for (int i = 0; i < 10; i++) { // 링크드리스트의 앞에서 부터 10개만 출력
				System.out.print(lst.get(i) + " ");
			}
			System.out.println();
		}
	}

}
