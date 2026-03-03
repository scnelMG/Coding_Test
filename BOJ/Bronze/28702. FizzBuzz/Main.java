import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String s1 = sc.next();
		String s2 = sc.next();
		String s3 = sc.next();
		int cnt = 0;
		int res = 0;

		if (!s1.equals("Fizz") && !s1.equals("Buzz") && !s1.equals("FizzBuzz")) {
			cnt = 3;
			res = Integer.parseInt(s1) + cnt;
		}
		if (!s2.equals("Fizz") && !s2.equals("Buzz") && !s2.equals("FizzBuzz")) {
			cnt = 2;
			res = Integer.parseInt(s2) + cnt;
		}
		if (!s3.equals("Fizz") && !s3.equals("Buzz") && !s3.equals("FizzBuzz")) {
			cnt = 1;
			res = Integer.parseInt(s3) + cnt;
		}

		if (res % 15 == 0) {
			System.out.println("FizzBuzz");
		} else if (res % 3 == 0) {
			System.out.println("Fizz");
		} else if (res % 5 == 0) {
			System.out.println("Buzz");
		} else {
			System.out.println(res);
		}
	}
}
