import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        char c = sc.next().charAt(0);
        switch (c) {
            case 'M':
                System.out.println("MatKor");
                break;
            case 'W':
                System.out.println("WiCys");
                break;
            case 'C':
                System.out.println("CyKor");
                break;
            case 'A':
                System.out.println("AlKor");
                break;
            case '$':
                System.out.println("$clear");
                break;
        }
    }
}