import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		Map<Integer, String> major = new HashMap<>();

		int max_year = 0;
		for (int i = 0; i < N; i++) {
			String s = sc.next();
			int year = sc.nextInt();
			major.put(year, s);
			if (year > max_year)
				max_year = year;

		}
		System.out.println(major.get(max_year));
	}
}
