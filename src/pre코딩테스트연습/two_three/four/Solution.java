package pre코딩테스트연습.two_three.four;

public class Solution {

    public static void main(String[] args) {

        System.out.println(new Solution().solution(29,15));
    }

    public int solution(int A, int B) {
        int answer = 0;

        String numA = Integer.toBinaryString(A);
        String numB = Integer.toBinaryString(B);

        for (int i = 0; i < numA.length() - numB.length(); i++) {
            numB = "0" + numB;
        }

        for (int i = 0; i < numA.length(); i++) {
            if(numA.charAt(i) != numB.charAt(i)){
                answer++;
            }
        }

        return answer;
    }
}
