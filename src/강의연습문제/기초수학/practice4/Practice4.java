package 강의연습문제.기초수학.practice4;

import java.util.HashSet;

public class Practice4 {

    public static boolean solution(int n){

        HashSet<Integer> set = new HashSet<>();

        while(set.add(n)){ // 중복되는 수 찾기
            int squareSum = 0;

            while(n > 0){
                int remain = n % 10;

                squareSum += remain * remain;
                n /= 10; // 그다음 자릿수
            }

            if(squareSum == 1){
                return true;
            }else {
                n = squareSum;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(solution(19));
        System.out.println(solution(6));
        System.out.println(solution(21));
    }
}
