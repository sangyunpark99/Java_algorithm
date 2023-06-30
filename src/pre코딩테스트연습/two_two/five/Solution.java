package pre코딩테스트연습.two_two.five;

public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().solution(-12000223));
    }

    public int solution(int num) {
        int answer = 0;

        boolean isMinus = false;

        StringBuilder sb = new StringBuilder();
        sb.append(num);

        sb.reverse(); // 반대로 뒤집기

        if(sb.indexOf("-")>0){ // - 를 포함한경우
            isMinus = true;
            sb.deleteCharAt(sb.length()-1); // - 제거
        }

        int number = Integer.parseInt(String.valueOf(sb));
        answer = isMinus? number*-1: number;

        if(answer >= 100000 || answer <= -100000){
            answer = 0;
        }

        return answer;
    }
}
