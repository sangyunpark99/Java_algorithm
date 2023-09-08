package 큰돌의터전알고리즘강의.three주차.완전이진트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    public static int k;
    public static ArrayList<ArrayList<Integer>> ans;
    public static int[] numbers;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        k = Integer.parseInt(br.readLine());

        ans = new ArrayList<>();
        numbers = new int[1030];

        StringTokenizer st = new StringTokenizer(br.readLine());

        int idx = 0;
        while(st.hasMoreTokens()){
            numbers[idx] = Integer.parseInt(st.nextToken());
            idx++;
        }

        for (int i = 0; i < k; i++) { // 빈 배열 추가하기
            ans.add(new ArrayList<Integer>());
        }

        dfs(0,(int) Math.pow(2,k)-2,0); // 배열 인덱스는 0부터 시작 : 주의


        for (int i = 0; i < ans.size(); i++) {
            for (int j = 0; j < ans.get(i).size(); j++) {
                System.out.print(ans.get(i).get(j) + " ");
            }
            System.out.println();
        }


    }

    public static void dfs(int start, int end, int level){
        if(start > end){ // 큰 경우 무조건 return
            return;
        }

        if(start == end){ // 같은경우
            ans.get(level).add(numbers[start]);
            return;
        }

        int mid = (start + end) / 2;
        ans.get(level).add(numbers[mid]); // 중앙값 넣고
        dfs(start,mid-1,level+1); // 중앙 이전 범위
        dfs(mid+1, end, level+1); // 중앙 이후 범위
    }
}