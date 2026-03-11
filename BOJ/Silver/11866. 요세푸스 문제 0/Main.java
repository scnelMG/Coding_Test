import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();

		List<Integer> list = new ArrayList<>();
		for (int i = 1; i <= N; i++) {
			list.add(i);
		}
		int idx = 0;
		System.out.print("<");

		while (list.size() > 1) {
			idx = (idx + 2) % list.size();
			System.out.print(list.get(idx) + ", ");
			list.remove(idx);
		}
		System.out.println(list.get(0) + ">");
	}
}
