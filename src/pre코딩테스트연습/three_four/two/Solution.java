package pre코딩테스트연습.three_four.two;

public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().solution(new int[] {1,2,3}));
    }

    public int solution(int[] A) {
        int answer = Integer.MIN_VALUE;

        int sub = 1;

        //1자리인 경우
        if(A.length == 1){
            answer = Math.max(answer, A[0]);
        }

        while(sub<=A.length){

            int sum = 0;

            for (int i = 0; i < A.length; i++) {

                sum += A[i];

                if(i >= sub){ // 맨 앞의 값 빼주기
                    sum -= A[i - sub];
                }

                answer = Math.max(answer,sum);
            }

            sub++;
        }
        
        return answer < 0 ? 0 : answer;
    }
}
