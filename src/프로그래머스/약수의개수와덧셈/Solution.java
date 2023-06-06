package 프로그래머스.약수의개수와덧셈;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().solution(13,17));
    }

    public int solution(int left, int right){

        int answer = 0;

        for(int i = left; i <= right; i++){
            int measure = findMeasure(i);
            if(measure % 2 == 0){
                answer += i;
            }else if(measure % 2 == 1){
                answer -= i;
            }
        }

        return answer;
    }

    public static int findMeasure(int n){
        int count = 0;

        for(int i = 1; i <= n/2; i++){
            if(n%i == 0){
                count++;
            }
        }

        return ++count;
    }
}
