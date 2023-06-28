package 큰돌의터전알고리즘강의.one주차.곱셈;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        // 수가 크므로 long으로 해주어야 한다.

        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        long c = Long.parseLong(st.nextToken());

        System.out.println(divideConquer(a,b,c));
    }

    // (a*b)%c = (a%c * b%c) %c

    public static long divideConquer(long a, long b, long c){
        if(b == 0){
            return 1;
        }

        if(b%2 == 1){
            return (a * divideConquer(a,b-1,c))%c;
        }

        long k = divideConquer(a,b/2,c) % c;

        return k*k%c;
    }
}
