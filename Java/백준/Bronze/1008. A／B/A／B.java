// import java.util.Scanner;

// class Main{
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         double A = sc.nextDouble();
//         double B = sc.nextDouble();
//         // 자릿수 지정하기 -> printf 사용
//         System.out.println(A / B);
    
//     }
// }


// 방법 2-2
 
import java.io.*;
import java.util.StringTokenizer;
 
public class Main {
 
	public static void main(String[] args) throws IOException {
		     
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
        String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str," ");
		double a = Double.parseDouble(st.nextToken());
		double b = Double.parseDouble(st.nextToken());
		
		System.out.println(a/b);
 
	}
 
}