import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		Deque<Integer> d = new LinkedList<>();
		for (int i = 1; i <= N; i++) {
			d.addLast(i);
		}
		while (d.size() > 1) {
			d.pollFirst();
			int tmp = d.pollFirst();
			d.offerLast(tmp);
		}
		System.out.println(d.poll());
	}
}
