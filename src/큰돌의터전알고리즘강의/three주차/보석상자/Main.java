package 큰돌의터전알고리즘강의.three주차.보석상자;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static int N;
    public static int M;
    public static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[M];

        // 제일 많은 보석의 수 담기
        int end = Integer.MIN_VALUE;
        int start = 1;

        for (int i = 0; i < M; i++) { // 같은 색상
            arr[i] = Integer.parseInt(br.readLine());
            end = Math.max(end, arr[i]);
        }

        int answer = Integer.MAX_VALUE;

        while (start <= end) {
            int mid = (start + end) / 2;

            if (check(mid)) { // 인원수가 더 많네?
                answer = Math.min(answer, mid);
                end = mid - 1; // 갯수를 더 줄여서 나눠줘
            } else { // 인원수가 더 없네?
                start = mid + 1; // 갯수를 더 늘려서 나눠줘
            }
        }

        System.out.println(answer);
    }

    public static boolean check(int mid) {
        int num = 0;

        for (int i = 0; i < M; i++) {
            num += arr[i] / mid;

            if (arr[i] % mid > 0) {
                num++;
            }
        }

        return N >= num;
    }
}
