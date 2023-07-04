package 큰돌의터전알고리즘강의.two주차.수학숙제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;

// 문자열로 제어하기
// 범위 100글자 : Long 안됨
// 자료형 주의
public class Main {
    public static ArrayList<BigInteger> res = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int m = Integer.parseInt(br.readLine());

        for (int i = 0; i < m; i++) {
            String s = br.readLine();

            // 정규표현식 추출
            String[] a = s.split("[^0-9]");

            for (int j = 0; j < a.length; j++) {
                if(!a[j].equals("")){
                    res.add(new BigInteger(a[j]));
                }
            }
        }

        Collections.sort(res); // 정렬

        for (int i = 0; i < res.size(); i++) {
            System.out.println(res.get(i));
        }
    }
}
