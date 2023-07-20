package 큰돌의터전알고리즘강의.three주차.괄호추가하기;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;

public class Main {

    static ArrayList<Character> oper_str;
    static ArrayList<Integer> nums;

    static int N;

    static String s;

    static int res;

    // 완전탐색
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        s = br.readLine();

        res = Integer.MIN_VALUE;
        oper_str = new ArrayList<>();
        nums = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            if(i%2 == 0){
                nums.add(s.charAt(i)-'0'); //
            }else{
                oper_str.add(s.charAt(i));
            }
        }

        go(0,nums.get(0)); // 시작점
        bw.write(String.valueOf(res)+'\n');
        bw.flush();
        bw.close();
        br.close();
    }

    public static void go(int here, int num){ // index를 기준으로

        System.out.println(here + ":" + num);

        if(here == nums.size()-1){ // 끝까지 다 돈 경우
            res = Math.max(res,num);
            return;
        }

        // 앞의 값을 먼저 계산
        go(here + 1, oper(oper_str.get(here), num, nums.get(here+1)));

        if(here + 2 <= nums.size() - 1){ // 뒤에꺼 괄호해주기 - 오버플로우 체크
            int temp = oper(oper_str.get(here+1), nums.get(here+1),nums.get(here+2)); // 뒤에 값을 먼저 계산
            go(here+2, oper(oper_str.get(here), num, temp)); // 앞에 같이 계산한 값 더해주기
        }
    }

    public static int oper(char a, int b, int c){
        if(a == '+') return b + c;
        if(a == '-') return b - c;
        else return b*c;
    }
}
