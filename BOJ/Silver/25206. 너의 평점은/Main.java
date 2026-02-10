import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double score = 0;
		int classNum = 0;
		for (int i = 0; i < 20; i++) {

			String name = sc.next();
			double num = sc.nextDouble();
			String grade = sc.next();

			switch (grade) {
			case "A+": {
				classNum += num;
				score += 4.5 * num;
				break;
			}

			case "A0": {
				classNum += num;
				score += 4.0 * num;
				break;
			}
			case "B+": {
				classNum += num;
				score += 3.5 * num;
				break;
			}
			case "B0": {
				classNum += num;
				score += 3.0 * num;
				break;
			}
			case "C+": {
				classNum += num;
				score += 2.5 * num;
				break;
			}
			case "C0": {
				classNum += num;
				score += 2.0 * num;
				break;
			}
			case "D+": {
				classNum += num;
				score += 1.5 * num;
				break;
			}
			case "D0": {
				classNum += num;
				score += 1.0 * num;
				break;
			}
			case "F": {
				classNum += num;
				score += 0.0 * num;
				break;
			}
			case "P": {

				break;
			}
			}
		}
		System.out.println(score / classNum);

	}
}
