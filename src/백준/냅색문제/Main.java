package 백준.냅색문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    private static long N;
    private static long C;
    private static int middleIndex;
    private static long[] weights;

    private static List<Long> leftList = new ArrayList<>();
    private static List<Long> rightList = new ArrayList<>();
    private static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        C = Long.parseLong(st.nextToken());

        weights = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();

        middleIndex = weights.length / 2;

        sum(leftList, 0L, 0, middleIndex); //
        sum(rightList, 0L, middleIndex, weights.length);

        Collections.sort(rightList); // 이분 탐색은 정렬

        for (long value : leftList) {
            binarySearch(C - value);
        }

        System.out.println(answer);
    }

    public static void sum(List<Long> sumList, Long weight, int curIdx, int endIndex) { // 나올 수 있는 합계의 모든 경우

        // 마지막 까지 더한 값을 추가
        if (curIdx == endIndex) {
            sumList.add(weight); // 중복이어도 추가
            return;
        }

        // 현재 값을 더하지 않는 경우
        sum(sumList, weight, curIdx + 1, endIndex);

        // 현재 값을 더하는 경우
        sum(sumList, weight + weights[curIdx], curIdx + 1, endIndex);
    }

    public static void binarySearch(long value) { // 탐색 뭘 탐색?
        int startIdx = 0;
        int endIdx = rightList.size() - 1;

        while (startIdx <= endIdx) {

            int middle = (startIdx + endIdx) / 2;

            if (rightList.get(middle) <= value) { // 더 작거나 같은 경우도 정답 포함
                answer += (middle - startIdx + 1); // 정렬된 상태이므로 이전의 값은 모두 만족
                startIdx = middle + 1; // 더 큰 값을 탐색
            } else {
                endIdx = middle - 1;
            }
        }
    }
}