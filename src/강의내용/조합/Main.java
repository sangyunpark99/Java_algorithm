package 강의내용.조합;

public class Main {

    static int getcombination(int n, int r){
        int pResult = 1;
        for (int i = n; i >= n-r+1; i--) { // nPr
            pResult *= i;
        }

        //r!
        int rResult = 1;
        for (int i = 1; i <= r; i++) {
            rResult *= i;
        }

        return pResult / rResult;
    }

    public static void main(String[] args) {
        // 1.조합
        System.out.println("== 조합 ==");
        // 서로 다른 4명 중 주번 2명을 봅는 경우의 수
        int n =4;
        int r = 2;

        int pResult = 1;
        for (int i = n; i >= n-r+1; i--) { // nPr
            pResult *= i;
        }

        //r!
        int rResult = 1;
        for (int i = 1; i <= r; i++) {
            rResult *= i;
        }
        System.out.println("결과 : " + pResult/rResult);

        // 2. 중복 조합
        System.out.println("== 중복 조합 ==");
        n = 2;
        r = 3;

        System.out.println("결과 : " + getcombination(n+r-1,r));
    }
}
