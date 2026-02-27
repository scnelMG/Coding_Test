package 박민규.CodeTree.이상한진수2;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		char[] arr = s.toCharArray();
		boolean isTry = false;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == '0') {
				arr[i] = '1';
				isTry = true;
				break;
			}
		}
		if (!isTry) {
			arr[arr.length-1] = '0';
		}

		int res = 0;
		for (int i = 0; i < arr.length; i++) {
			int num = arr[arr.length - 1 - i] - '0';
			res += num * Math.pow(2, i);
		}
		System.out.println(res);

	}

}