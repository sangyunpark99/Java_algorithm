package 실험실.chatper01;

public class TimeComplexity01 {
    public static void main(String[] args) {
        test1();
    }

    public static void test1() {
        int n = 4;
        int a = 0;
        int cnt = 0;
        for (int i = 0; i < n; i++) { // 1 ~ n을 더한 수
            for (int j = 0; j < i; j++) {
                a += i + j;
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}
