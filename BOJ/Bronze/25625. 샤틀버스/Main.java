import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		java.util.Scanner sc = new Scanner(System.in);
		int x = sc.nextInt(); // 입구 <-> 2 소요 시간
		int y = sc.nextInt(); // 해당 시간 후에 2에 도착
		int res = 0;
		if (x > y)
			res = (x + y);
		else
			res = (y - x);

		System.out.println(res);
	}
}
