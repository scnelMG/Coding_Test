import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Solution {
	static int cnt = 0; // 서브 트리 크기 구하는 변수

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt(); // 테스트 케이스 개수
		for (int tc = 1; tc <= T; tc++) {
			cnt = 0; // 서브 트리 크기 초기화
			int V = sc.nextInt(); // 노드 개수
			int E = sc.nextInt(); // 간선 개수
			int a = sc.nextInt(); // 공통 찾을 대상1
			int b = sc.nextInt(); // 공통 찾을 대상2

			int[][] tree = new int[V + 1][3]; // 트리 정보 넣을 배열
			for (int i = 0; i < E; i++) {
				int p = sc.nextInt(); // 부모 노드
				int c = sc.nextInt(); // 자식 노드
				if (tree[p][0] == 0) // 왼쪽에 없으면 왼쪽에 넣기
					tree[p][0] = c;
				else // 왼쪽에 있으면 오른쪽에 넣기
					tree[p][1] = c;
				tree[c][2] = p; // 부모 값 저장
			}
			int commonRoot = findCommon(a, b, tree); // a, b의 공통 조상 찾기
			findSize(commonRoot, tree); // 공통조상의 서브 트리 구하기
			System.out.println("#" + tc + " " + commonRoot + " " + cnt);
		}
	}

	public static int findCommon(int a, int b, int[][] tree) {
		List<Integer> lst = new ArrayList<>(); // 비교대상 1의 조상들 저장하는 리스트
		while (a != 1) { // 루트 만나면 반복 그만
			a = tree[a][2]; // 부모 값 찾고 리스트에 저장
			lst.add(a);
		}
		while (b != 1) { // 루투 만나면 반복 그만
			b = tree[b][2];
			if (lst.contains(b)) // 비교대상 1의 조상들 리스트에 b조상이 있으면 그만 -> 그게 공통된 조상
				break;
		}
		return b; // 공통된 조상 return
	}

	public static void findSize(int a, int[][] tree) { // 공통 조상의 서브 트리 크기 구하기
		// 그냥 순회하면서 개수 세자
		if (a <= 0 || a >= tree.length)
			return;
		cnt++;
		findSize(tree[a][0], tree);
		findSize(tree[a][1], tree);
	}
}
