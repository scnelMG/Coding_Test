import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String s = "UOS";
		System.out.println(s.charAt(n % 3 - 1));
	}

}
