package 큰돌의터전알고리즘강의.one주차.일;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 모듈려 연산을 사용
// (a+b) % n = (a%n)+(b%n)%n
// (a*b) % n = ((a%n)*(b%n))%n
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s;

        while((s=br.readLine())!=null){

            int n = Integer.parseInt(s);

            long cnt = 1;
            long ret = 1;

            while(true){
                if(cnt % n == 0){
                    System.out.println(ret);
                    break;
                }else{
                    cnt = (cnt%n*10%n)+1%n;
                    // 중간 중간에서 모듈러 연산을 해준다. -> 시간 고려해주기
                    ret++;
                }
            }
        }
    }
}
