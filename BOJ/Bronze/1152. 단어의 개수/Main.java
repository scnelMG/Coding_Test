import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String[] res = input.split(" ");
        int len = 0;
        for (int i = 0; i < res.length; i++) {
            if (!res[i].equals(""))
                len++;
        }
        System.out.println(len);

    }
}
