import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cnt = 1;
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			double d = Double.parseDouble(st.nextToken());
			int turn = Integer.parseInt(st.nextToken());
			double s = Double.parseDouble(st.nextToken());

			if (turn == 0) {
				break;
			}
			double dis = d * (3.1415927) * turn / 5280 / 12;
			double mph = dis / (s / 3600);

			System.out.printf("Trip #%d: %.02f %.02f\n", cnt++, dis, mph);

		}

	}
}
