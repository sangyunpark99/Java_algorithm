package 연습문제.practice2;

public class Solution {

    public static void main(String[] args) {
        System.out.println(solution("1101"));
    }

    public static int solution(String S){

        int number = 0;

        number = Integer.parseInt(S,2);

        int answer = 0;

        while(number!=0){
            if(number%2 == 0){
                number /=2;
            }else if(number%2 == 1){
                number -=1;
            }
            answer+=1;
        }

        return answer;
    }
}
