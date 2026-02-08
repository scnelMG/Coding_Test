import java.util.Scanner;
  
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
  
        for (int tc = 1; tc <= T; tc++) {
            String input = sc.next();
            int res = 0; // 조각 개수
            int cnt = 0; // 쌓인 막대 개수
            for (int i = 0; i < input.length(); i++) {
                if (input.charAt(i) == '(' && input.charAt(i + 1) == ')') { // 레이저 확인
                    i++; // 레이저는 2개짜리임으로 i 늘리기
                    res += cnt; // 쌓인 막대 개수 만큼 조각 개수 추가
                } else if (input.charAt(i) == '(') { // 레이저 아닌 ( 일 때
                    cnt++; // 쌓인 막대 개수 +1
                } else { // 레이저 아닌 ) 일때
                    cnt--; // 쌓인 막대 개수 -1
                    res++; // 조각 개수 +1
                }
            }
            System.out.println("#" + tc+ " " + res);
        }
    }
}