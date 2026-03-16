import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cnt = 0;
		while (true) {
			String s = br.readLine();
			if (s.equals("0")) {
				break;
			}
			System.out.println("Case " + (++cnt) + ": Sorting... done!");
		}
	}
}
