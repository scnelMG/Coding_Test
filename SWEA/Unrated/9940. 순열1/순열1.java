import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());

			// 중복이 없는지만 확인하면 순열 판단 가능
			// set을 이용해서 중복 존재 판단
			Set<Integer> set = new HashSet<>();
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				set.add(Integer.parseInt(st.nextToken()));
			}
			
			//set의 길이가 배열 길이가 같으면 -> 중복 없음 -> 순열임
			if (N == set.size()) {
				System.out.println("#" + tc + " Yes");
			} else { //set의 길이가 배열 길이가 다르면 -> 중복 존재 -> 순열이 아님
				System.out.println("#" + tc + " No");
			}

		}
	}
}
