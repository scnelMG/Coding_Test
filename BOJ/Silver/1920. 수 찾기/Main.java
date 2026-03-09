import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		// 1. 배열 대신 HashSet을 만듭니다.
		HashSet<Integer> set = new HashSet<>(); 
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			// 2. 입력받은 숫자를 Set에 그냥 훅훅 던져 넣습니다.
			set.add(Integer.parseInt(st.nextToken()));
		}
		
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < M; i++) {
			int targetNum = Integer.parseInt(st.nextToken());
			
			// 3. Set 안에 숫자가 있는지 확인 (for문 돌릴 필요 없이 한 줄로 끝!)
			if (set.contains(targetNum)) { 
				sb.append("1\n");
			} else {
				sb.append("0\n");
			}
		}
		System.out.println(sb.toString());
	}
}