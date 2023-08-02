package 프로그래머스.숫자의표현;

public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().solution(15));
    }

    public int solution(int n) {
        int answer = 0;

        for (int k = 1; k <=n/2; k++) { // 절반 이상의 큰 수는 연속된 합이 주어진 수를 만족시킬 수 없다.
            int i = k;
            int sum = 0;

            while(sum < n){
                sum += i++;
            }

            if(sum == n){
                answer++;
            }
        }

        answer+=1; // 자기자신 더해주기

        return answer;
    }
}
