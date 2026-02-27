package 박민규.CodeTree.씨오더블유2;

//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//
//public class Main {
//	public static void main(String[] args) throws NumberFormatException, IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		int N = Integer.parseInt(br.readLine());
//		String s = br.readLine();
//		int cnt = 0;
//		for (int i = 0; i < s.length() - 2; i++) {
//			if (s.charAt(i) == 'C') {
//				for (int j = i + 1; j < s.length() - 1; j++) {
//					if (s.charAt(j) == 'O') {
//						for (int k = j + 1; k < s.length(); k++) {
//							if (s.charAt(k) == 'W') {
//								cnt++;
//							}
//						}
//					}
//				}
//			}
//		}
//		
//		System.out.println(cnt);
//	}
//}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // N은 입력받지만 사실 문자열 순회 시 s.length()를 써도 무방합니다.
        int N = Integer.parseInt(br.readLine());
        String s = br.readLine();
        
        long cCnt = 0;   // 'C'의 개수
        long coCnt = 0;  // 'CO' 조합의 개수
        long cowCnt = 0; // 'COW' 조합의 개수 (최종 결과)
        
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            
            if (cur == 'C') {
                // 'C'를 발견하면 카운트 증가
                cCnt++;
            } else if (cur == 'O') {
                // 'O'를 발견하면, 지금까지 나온 'C'의 개수만큼 'CO' 조합이 가능해짐
                coCnt += cCnt;
            } else if (cur == 'W') {
                // 'W'를 발견하면, 지금까지 만들어진 'CO' 조합의 개수만큼 'COW' 완성
                cowCnt += coCnt;
            }
        }
        
        System.out.println(cowCnt);
    }
}