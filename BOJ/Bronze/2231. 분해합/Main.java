import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		boolean isOkay = false;
		int res = 0;
		for (int i = 1; i<=N; i++) {
			int tmp = i;
			int total = tmp;
			while (tmp > 0) {
				total += tmp % 10;
				tmp /= 10;
			}
			
			if (N == (total)) {
				isOkay = true;
				res = i;
				break;
			}
		}
		if (isOkay) {
			System.out.println(res);
		}else {
			System.out.println(0);
		}
		
	}
}
