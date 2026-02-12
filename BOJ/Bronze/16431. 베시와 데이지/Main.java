import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int br = sc.nextInt();
        int bc = sc.nextInt();
        int dr = sc.nextInt();
        int dc = sc.nextInt();
        int jr = sc.nextInt();
        int jc = sc.nextInt();

        int disD = Math.abs(jr - dr) + Math.abs(jc - dc);
        double disB = Math.sqrt((jr - br) * (jr - br) + (jc - bc) * (jc - bc));
        if ((int) disB > disD)
            System.out.println("daisy");
        else if (disB == (double) disD) {
            System.out.println("tie");
        } else {
            System.out.println("bessie");
        }

    }
}