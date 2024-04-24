package 백준.뮤탈리스크;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static int N;
    public static int[] scvs;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        scvs = new int[N];
        scvs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        // 어떤 SCV를 공격해야 할까?
        // 모든 경우를 탐색해야한다. 모든 경우를 탐색한다 = 순서를 랜덤하게 지정
        // 백트래킹을 사용해야 하는게 아닌가?
    }
}
