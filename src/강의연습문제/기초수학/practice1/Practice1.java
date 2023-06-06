package 강의연습문제.기초수학.practice1;

import java.util.ArrayList;

public class Practice1 {

    public static ArrayList<ArrayList<Integer>> solution(int numRows) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {
            ArrayList<Integer> list = new ArrayList<>();
            for (int j = 0; j < i+1; j++) {
                if(j == 0 || j == i){ // 외각 부분
                    list.add(1);
                }else{
                    int x = result.get(i-1).get(j-1);
                    int y = result.get(i-1).get(j);

                    list.add(x+y);
                }
            }
            result.add(list); // 한줄 넣어주기
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(solution(1));
        System.out.println(solution(2));
        System.out.println(solution(3));
        System.out.println(solution(4));
        System.out.println(solution(5));
    }
}
