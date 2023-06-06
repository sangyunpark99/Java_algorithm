package 강의내용.점화식고재귀함수;

public class Practice2 {

    static int gcd(int a, int b){ // 최대 골약수
        if(a % b == 0){
            return b;
        }

        return gcd(b, a % b);
    }

    public static void main(String[] args) {
        System.out.println(gcd(3,5));
        System.out.println(gcd(2,6));
        System.out.println(gcd(8,12));
    }
}
