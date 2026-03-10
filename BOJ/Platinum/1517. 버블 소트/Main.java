import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] A, sorted;
    static long swapCount = 0; // 정답이 int 범위를 초과하므로 반드시 long 타입 사용

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        A = new int[N];
        sorted = new int[N]; // 병합 과정에서 사용할 임시 배열
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        
        mergeSort(0, N - 1);
        
        System.out.println(swapCount);
    }

    // 병합 정렬 수행
    static void mergeSort(int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(left, mid);
            mergeSort(mid + 1, right);
            merge(left, mid, right);
        }
    }

    // 두 부분 배열을 합치면서 교차점(Swap 횟수)을 계산
    static void merge(int left, int mid, int right) {
        int i = left;
        int j = mid + 1;
        int k = left;
        
        while (i <= mid && j <= right) {
            if (A[i] <= A[j]) {
                sorted[k++] = A[i++];
            } else {
                sorted[k++] = A[j++];
                // 뒤쪽 배열(j)의 원소가 더 작아서 먼저 배열에 들어갈 때,
                // 앞쪽 배열에 남아있는 원소의 개수(mid - i + 1)만큼 Swap 발생
                swapCount += (mid - i + 1);
            }
        }
        
        // 남아있는 앞쪽 배열 원소들 채워넣기
        while (i <= mid) {
            sorted[k++] = A[i++];
        }
        // 남아있는 뒤쪽 배열 원소들 채워넣기
        while (j <= right) {
            sorted[k++] = A[j++];
        }
        
        // 정렬된 결과를 원래 배열에 복사
        for (int l = left; l <= right; l++) {
            A[l] = sorted[l];
        }
    }
}