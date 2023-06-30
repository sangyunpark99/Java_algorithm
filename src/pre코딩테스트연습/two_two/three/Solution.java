package pre코딩테스트연습.two_two.three;

class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().solution(1));
    }

    public long solution(int n) {
        long answer = Integer.MIN_VALUE;

        for (int i = 1; i <=n; i++) {
            if(Math.pow(i,3) <= n){
              answer = (int) Math.pow(i,3);
            }
        }

        return answer;
    }
}
