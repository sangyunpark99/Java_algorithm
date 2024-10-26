package SW.최대상금;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution {

    private static StringBuilder sb = new StringBuilder();
    private static int value = Integer.MIN_VALUE;

    private static Set<String> visited = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int n = Integer.parseInt(br.readLine());

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            int[] array = Arrays.stream(st.nextToken().split("")).mapToInt(Integer::parseInt).toArray();
            int cnt = Integer.parseInt(st.nextToken());

            solution(array, cnt);
            System.out.println("#" + i + " " + value);
            value = Integer.MIN_VALUE;
        }
    }

    private static void solution(int[] array, int cnt) { // 숫자 조합만
        if (cnt == 0) { // 바꿀 수 있는 횟수 전부 소진
            value = Math.max(value, convert(array));
            return;
        }

        String state = convert(array) + cnt + "";
        if (visited.contains(state)) { // 이미 방문한 경우 return -> 놓칠 수 있다
            return;
        }

        visited.add(state);

        for (int i = 0; i < array.length; i++) { // 탐색 -> 중복 선택 가능 (자기 자신 제외)
            for (int j = i + 1; j < array.length; j++) {
                swap(array, i, j); // 변경
                solution(array, cnt - 1);
                swap(array, i, j); // 원복
            }
        }
    }

    private static void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    private static int convert(int[] array) {
        for (int value : array) {
            sb.append(value);
        }

        String value = sb.toString();

        sb = new StringBuilder();

        return Integer.parseInt(value);
    }
}