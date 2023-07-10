package pre코딩테스트연습.three_five.two;

public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().solution(-99,0));
    }

    public int solution(int N, int K) {
        int answer = 0;

        String a = String.valueOf(N);

        if(a.length()==1){
            a = a+K;
            return Integer.parseInt(a);
        }

        if(N>0){
            a = K+a;
        }else{
            a = a+K;
        }

        return Integer.parseInt(a);
    }
}
