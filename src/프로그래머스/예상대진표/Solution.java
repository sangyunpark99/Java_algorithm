package 프로그래머스.예상대진표;

public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().solution(8,4,7));
    }

    public int solution(int n, int a, int b)
    {
        int answer = 0;

        while(a!=b){ // 라운드 번호가 같기 전까지
            a = (a+1) / 2;
            b = (b+1) / 2;
            answer++;
        }

        return answer;
    }
}
