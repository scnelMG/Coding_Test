import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][] arr = new int[2][10];
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 10; j++) {
				arr[i][j] = sc.nextInt();
			}
		}

		int cntA = 0;
		int cntB = 0;
		for (int i = 0; i < 10; i++) {
			if (arr[0][i] > arr[1][i])
				cntA++;
			else if (arr[0][i] < arr[1][i])
				cntB++;
		}

		if (cntA > cntB)
			System.out.println("A");
		else if (cntA < cntB)
			System.out.println("B");
		else
			System.out.println("D");

	}

}
