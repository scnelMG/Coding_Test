
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));        int x = Integer.parseInt(br.readLine());
        int y = Integer.parseInt(br.readLine());

        if (x > 0 & y > 0) System.out.println(1);
        if (x < 0 & y > 0) System.out.println(2);
        if (x < 0 & y < 0) System.out.println(3);
        if (x > 0 & y < 0) System.out.println(4);

    }
}