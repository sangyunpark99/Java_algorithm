package 백준.대칭차집합다른풀이;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    public static int A;
    public static int B;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        HashMap<Integer, Integer> aMap = new HashMap<>();
        HashMap<Integer, Integer> bMap = new HashMap<>();

        int[] aArray = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] bArray = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        // 초기화
        for (int value : aArray) {
            aMap.put(value, aMap.getOrDefault(value, 0) + 1);
        }

        for (int value : bArray) {
            bMap.put(value, bMap.getOrDefault(value, 0) + 1);
        }

        // 찾기
        for (int value : aArray) {
            if (bMap.get(value) != null) {
                bMap.put(value, bMap.get(value) - 1);
            }
        }
        for (int value : bArray) {
            if (aMap.get(value) != null) {
                aMap.put(value, aMap.get(value) - 1);
            }
        }

        int res = 0;

        int aCnt = 0;
        for (Map.Entry<Integer, Integer> map : aMap.entrySet()) {
            if (map.getValue() != 0) {
                aCnt++;
            }
        }

        int bCnt = 0;
        for (Map.Entry<Integer, Integer> map : bMap.entrySet()) {
            if (map.getValue() != 0) {
                bCnt++;
            }
        }

        res = aCnt + bCnt;
        bw.write(res + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
