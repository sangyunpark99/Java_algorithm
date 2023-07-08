package pre코딩테스트연습.three_one.five;

public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().solution(20,5));
    }

    public int solution(int n, int price) {
        int answer = 0;

        // 총 몇번을 구매해야 하는가?
        int cnt = n/11;
        int rest = n%11;

        answer = (cnt*10)*price + rest*price;

        return answer;
    }
}
