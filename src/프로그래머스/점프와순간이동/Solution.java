package 프로그래머스.점프와순간이동;

public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().solution(5000));
    }

    public int solution(int n) {
        int ans = 1;

        // K칸 점프 - K만큼의 건전지 사용량
        // 현재까지 온거리 * 2 - 순간이동 | 2의 배수
        // 최소공배수 ..?

        while(n != 1){
            if(n%2 == 1){
                n-=1;
                ans++;
            }else{
                n/=2;
            }
        }

        return ans;
    }
}
