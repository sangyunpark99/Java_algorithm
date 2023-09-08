package 큰돌의터전알고리즘강의.three주차.부등호;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static int k;
    public static char[] signs;
    public static int[] visited = new int[10];
    public static ArrayList<String> answer = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        k = sc.nextInt();
        signs = new char[k];

        for (int i = 0; i < k; i++) {
            signs[i] = sc.next().charAt(0);
        }

        dfs(0, "");

        Collections.sort(answer); // 정렬

        System.out.println(answer.get(answer.size()-1));
        System.out.println(answer.get(0));
    }

    public static boolean check(char x, char y, char op){

        if(x < y && op == '<') return true;
        return x > y && op == '>';
    }

    // 10팩토리얼 : 360만
    // 완전 탐색은 인덱스가 기준
    public static void dfs(int idx, String num){
        if(idx == k+1){
            answer.add(num);
            return;
        }

        for (int i = 0; i <=9; i++) {
            if(visited[i] > 0) continue;
            if(idx == 0 || check(num.charAt(idx-1),(char)(i+'0'),signs[idx-1])){ // index가 0인 경우
                visited[i] = 1;
                dfs(idx+1, num + i);
                visited[i] = 0; // 원상복구를 해줘야한다.
            }
        }
    }
}
