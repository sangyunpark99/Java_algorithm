package 강의내용.순열;

import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        // 1. 팩토리얼
        System.out.println("== 팩토리얼 ==");
        // 5!
        int n = 5;
        int result = 1;

        for (int i = 1; i <=n; i++) {
            result *= i;
        }
        System.out.println(result);

        System.out.println(IntStream.range(2,6).reduce(1,(x,y)->(x*y))); // 스트림 구현

        // 2. 순열
        System.out.println("== 순열 ==");
        // 5명을 3줄로 세우는 경우의 수
        n = 5;
        int r = 3;
        result = 1;

        for (int i = n; i >= n-r+1; i--) {
            result *= i;
        }


        // 3. 중복 순열
        // 서로 다른 4개의 수 중 2개를 뽑는 경우의 수 n^n
        n = 4;
        r = 2;
        result = 1;
        for (int i = 0; i < r; i++) {
            result *= n;
        }

        System.out.println("result = " + result);
        System.out.println(Math.pow(n,r)); // 제곱 

        // 4. 원 순열
        System.out.println("== 원 순열 ==");
        // 원 모양의 테이블에 3명을 앉히는 경우의 수
        // n!/n
        n = 3;
        result = 1;
        for(int i = 1; i < n; i++){
            result *= i;
        }
        System.out.println("result = " + result);
    }
}
