import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        while (true) {
            String s = sc.nextLine();
            if (s.equals("*"))
                break;

            boolean isOkay = true;
            for (int i = 0; i < 26; i++) {
                if (!s.contains(Character.toString('a' + i))) {
                    isOkay = false;
                }
            }

            if (isOkay) {
                System.out.println("Y");
            } else {
                System.out.println("N");
            }

        }
    }
}