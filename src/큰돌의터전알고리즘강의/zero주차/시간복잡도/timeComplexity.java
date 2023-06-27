package 큰돌의터전알고리즘강의.zero주차.시간복잡도;

public class timeComplexity {
    public static void main(String[] args) {
        solve(10);
    }

    public static void solve(int N){
        int a = 0;
        int i = N;
        int cnt = 0;

        while(i > 0){
            a += i;
            i /= 2;
            cnt++;
        }

        System.out.println(a);
    }
}
