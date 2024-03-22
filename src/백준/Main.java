package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws InterruptedException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("예쁜 사람을 검색해주는 프로그램입니다.");
        Thread.sleep(1000);
        System.out.println();
        System.out.println("검색 하시겠습니까?");

        System.out.println("1. 네   2. 아니오");
        System.out.printf("나의 선택 : ");
        int choice = Integer.parseInt(br.readLine());

        if (choice == 1) {
            System.out.println("검색중...");
            Thread.sleep(3000);
            System.out.println("검색 결과 : 심하은");
        }

        br.close();
    }
}
