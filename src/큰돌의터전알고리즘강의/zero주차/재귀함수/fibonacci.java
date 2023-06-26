package 큰돌의터전알고리즘강의.zero주차.재귀함수;

public class fibonacci {
    public static void main(String[] args) {
        fibo(4);
    }

    public static int fibo(int n){

        System.out.println("fibo : " + n);

        if(n == 1 || n == 0){
            return 1;
        }

        return fibo(n-1) + fibo(n-2);
    }
}
