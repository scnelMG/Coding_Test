import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        // key(앞 3개 코드) -> 곡명 or "?"(중복 표시)
        Map<String, String> map = new HashMap<>(N * 2);

        for (int i = 0; i < N; i++) {
            int T = sc.nextInt(); // 필요 없으면 안 써도 됨
            String song = sc.next();

            String c0 = sc.next();
            String c1 = sc.next();
            String c2 = sc.next();

            // 나머지 4개는 읽어서 버림 (입력 구조상 존재)
            for (int k = 0; k < 4; k++)
                sc.next();

            String key = c0 + "#" + c1 + "#" + c2;

            // 처음이면 곡명 저장, 이미 있으면 중복 처리("?")
            String prev = map.putIfAbsent(key, song);
            if (prev != null)
                map.put(key, "?");
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M; i++) {
            String key = sc.next() + "#" + sc.next() + "#" + sc.next();

            String val = map.get(key);
            if (val == null)
                sb.append("!\n");
            else
                sb.append(val).append('\n'); // 곡명 또는 "?"
        }

        System.out.print(sb.toString());
        sc.close();
    }
}
