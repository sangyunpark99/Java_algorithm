package 큰돌의터전알고리즘강의.one주차.한국이그리울땐서버에접속하자;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


// substring 사용
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());

        String s = br.readLine();

        int starIndex = s.indexOf('*');

        String frontStar = s.substring(0,starIndex);
        String laterStar = s.substring(starIndex+1);

        for (int i = 0; i < num; i++) {
            String sc = br.readLine();

            if(sc.length() < frontStar.length() + laterStar.length()){ // 작으면 무조건 안도
                System.out.println("NE");
            }else{
                String first = sc.substring(0,frontStar.length());
                String last = sc.substring(sc.length()-laterStar.length());

                if(frontStar.equals(first) && laterStar.equals(last)){
                    System.out.println("DA");
                }else{
                    System.out.println("NE");
                }
            }
        }
    }
}
