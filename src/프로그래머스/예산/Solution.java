package 프로그래머스.예산;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        System.out.println(solution(new int[]{2,2,3,3}, 10));
    }

    public static int solution(int[] d, int budget){
        int answer = 0;
        int result = 0;

        Arrays.sort(d); // 오름차순 정렬

        // 1, 2, 3, 4, 5 | 최대 갯수 이므로
        for (int i = 0; i < d.length; i++) {
            result += d[i];
            if(result > budget){ // 총 합계가 예산 보다 큰경우
                answer = i; // 인덱스는 이미 1개를 제외하게 됨
                break;
            }
        }

        answer = d.length;

        return answer;
    }
}
