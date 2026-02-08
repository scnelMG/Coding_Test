import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[8];
        boolean asc = true;
        boolean only = true;
        for (int i = 0; i < 8; i++) {
            arr[i] = sc.nextInt();
        }

        if (arr[0] > arr[1])
            asc = false;
        for (int i = 1; i < 7; i++) {
            if ((asc && arr[i] > arr[i + 1]) || (!asc && arr[i] < arr[i + 1])) {
                only = false;
                break;
            }
        }
        if (!only)
            System.out.println("mixed");
        else if (asc)
            System.out.println("ascending");
        else
            System.out.println("descending");

    }
}
