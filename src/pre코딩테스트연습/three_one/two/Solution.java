package pre코딩테스트연습.three_one.two;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().solution(new int[]{0,0,0,0}));
    }

    public int solution(int[] arr) {
        int answer = 0;

        // A학점 최대 인원수 : 수강 인원의 50%
        // 50%의 경계에 걸쳐 동일한 점수를 받은 학생 : 동일한 학점 제공하기위해 50% 초과

        // 정렬
        Arrays.sort(arr);

        // 50% 컷할 수 있는 기준 점수 찾기
        int getNum = arr.length/2;
        int value = 0;
        int flag = 0;

        for (int i = arr.length - 1; i >=0; i--) {
            if(flag == 1){
                break;
            }
            int score = arr[i];
            int cnt = 0;
            for (int j = arr.length-1 ; j >= i; j--) {
                if(score <= arr[j]){
                    cnt++;
                }

                if(cnt == getNum){ // 길이
                    value = score;
                    flag = 1;
                    break;
                }
            }
        }

        for (int i = 0; i < arr.length; i++) {
            if(arr[i] >= value){
                answer++;
            }
        }

        return answer;
    }
}
