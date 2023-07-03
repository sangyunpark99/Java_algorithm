package 큰돌의터전알고리즘강의.two주차.사과담기게임;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        int j = Integer.parseInt(br.readLine());

        int res = 0;
        int l = 1; // 맨 왼쪽
        for (int i = 0; i < j; i++) {
            int temp = Integer.parseInt(br.readLine()); // l과 r사이에 있어야 함
            int r = l + m - 1; // r기준 재정립

            if(temp >= l && temp <= r) continue; // 사이에 값이 있는 경우
            else{
                if(temp < l){
                    res += (l - temp);
                    l = temp;
                }else{
                    res += (temp - r); // 뒤에 값 기준
                    l += (temp - r); // 칸 크기 맞게 움직여!
                }
            }
        }

        System.out.println(res);
    }
}
