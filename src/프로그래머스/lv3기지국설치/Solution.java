package 프로그래머스.lv3기지국설치;

public class Solution {

    public static void main(String[] args) {
        System.out.println(solution(11, new int[]{4, 11}, 1));
        System.out.println(solution(16, new int[]{9}, 2));
    }

    public static int solution(int n, int[] stations, int w) {
        int answer = 0;

        int curIdx = 1; // 기준점

        double gap = 0;
        int leftRange = 0;
        int rightRange = 0;
        for (int i = 0; i < stations.length; i++) { // 기지국을 돌면서
            int station = stations[i];
            leftRange = station - w;
            rightRange = station + w;

            // 기준점으로부터 기지국의 공백
            if (curIdx < leftRange) { // 커버가 불가능한 경우
                gap = leftRange - curIdx; // 공백
                answer += Math.ceil(gap / (2 * w + 1)); // 기지국 세우기
            }

            curIdx = rightRange + 1; // 지속적으로 갱신
        }

        // 마지막 기지국 범위
        if (rightRange < n) { // 범위가 더 작은 경우
            gap = n - rightRange;
            answer += Math.ceil(gap / (2 * w + 1));
        }

        // 기지국이 존재하지 않는 부분
        return answer;
    }
}