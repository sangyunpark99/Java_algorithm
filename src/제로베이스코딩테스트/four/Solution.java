package 제로베이스코딩테스트.four;

public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().solution(10,3,4,new int[]{3,3,4}));
    }

    public long solution(int N, int M, int K, int[] capacity) {
        long answer = 1;

        for (int i = 0; i < capacity.length; i++) {
            answer *= combi(N,capacity[i]);
            N = N - capacity[i];
        }
        
        long p = 1;

        for (int i = 0; i < capacity.length; i++) {
            p *= K;
            K-=1;
        }

        return answer*p;
    }

    public static int combi(int n, int r){
        if(r == 0 || n == r){
            return 1;
        } else{
            return combi(n-1,r-1) + combi(n-1,r);
        }
    }
}
