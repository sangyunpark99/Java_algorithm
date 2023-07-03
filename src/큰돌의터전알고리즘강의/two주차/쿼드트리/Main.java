package 큰돌의터전알고리즘강의.two주차.쿼드트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main { // 분할 정복
    public static int n;
    public static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            map[i] = Arrays.stream(stk.nextToken().split("")).mapToInt(Integer::parseInt).toArray();
        }

        System.out.println(solution(0,0,n).toString());

    }

    public static StringBuilder solution(int y, int x, int size){

        StringBuilder res = new StringBuilder();

        int value = map[y][x];

        if(size == 1){ // 기저 사례
            return res.append(value);
        }

        for (int i = y; i < y+size; i++) {
            for (int j = x; j < x+size; j++) {
                if(value != map[i][j]){ // 같지 않다면 4분할
                    int halfSize = size / 2;
                    res.append('(');
                    res.append(solution(y,x,halfSize)); // 왼쪽위
                    res.append(solution(y,x+halfSize, halfSize));// 오른쪽 위
                    res.append(solution(y+halfSize,x, halfSize));// 왼쪽 아래
                    res.append(solution(y+halfSize,x+halfSize, halfSize));// 오른쪽 아래
                    res.append(')');
                    return res;
                }
            }
        } // 다 같은 값인 경우

        return res.append(value);
    }
}
