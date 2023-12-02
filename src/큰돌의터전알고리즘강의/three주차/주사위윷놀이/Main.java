package 큰돌의터전알고리즘강의.three주차.주사위윷놀이;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static ArrayList<ArrayList<Integer>> map = new ArrayList<>();
    public static int[] v = new int[104];
    public static int[] a = new int[14];
    public static int[] mal = new int[4];
    public static int answer = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        for (int i = 0; i < 10; i++) {
            int value = Integer.parseInt(stk.nextToken());
            a[i] = value;
        }

        setMap();

        // 어떤 말을 움직일까? -> 완전탐색
        int answer = go(0);
        System.out.println(answer);
    }

    public static int move(int here, int cnt) {
        if (here == 100) {
            return 100;
        }
        if (map.get(here).size() >= 2) {
            here = map.get(here).get(1);
            cnt--;
        }

        if (cnt > 0) {
            Queue<Integer> queue = new LinkedList<>();
            queue.add(here);
            int there = 0;
            while (!queue.isEmpty()) {
                int x = queue.poll();
                there = map.get(x).get(0);
                queue.add(there);
                if (there == 100) {
                    break;
                }
                cnt--;
                if (cnt == 0) {
                    break;
                }
            }
            return there;
        } else {
            return here;
        }
    }

    public static boolean isMal(int mal_idx, int idx) {
        if (mal_idx == 100) {
            return false;
        }
        for (int i = 0; i < 4; i++) {
            if (i == idx) {
                continue;
            }
            if (mal[i] == mal_idx) {
                return true;
            }
        }
        return false;
    }

    public static int go(int here) {
        if (here == 10) {
            return 0;
        }
        int ret = 0;
        for (int i = 0; i < 4; i++) {
            int temp_idx = mal[i];
            int mal_idx = move(temp_idx, a[here]);
            if (isMal(mal_idx, i)) {
                continue;
            }
            mal[i] = mal_idx;
            ret = Math.max(ret, go(here + 1) + v[mal_idx]);
            mal[i] = temp_idx;
        }
        return ret;
    }

    // 인접 리스트 - 단방향
    private static void setMap() {
        for (int i = 0; i < 32; i++) {
            map.add(new ArrayList<>());
        }

        for (int i = 0; i <= 19; i++) {
            add(i, i + 1);
        }

        // 연결
        add(5, 21);
        add(21, 22);
        add(22, 23);
        add(23, 24);
        add(24, 25);
        add(25, 26);
        add(26, 20);
        add(10, 27);
        add(27, 28);
        add(28, 24);
        add(15, 29);
        add(29, 30);
        add(30, 31);
        add(31, 24);
        add(20, 100);

        // 값 추가
        for (int i = 0; i <= 20; i++) {
            v[i] = i * 2;
        }

        v[21] = 13;
        v[22] = 16;
        v[23] = 19;
        v[24] = 25;
        v[25] = 30;
        v[26] = 35;
        v[27] = 22;
        v[28] = 24;
        v[29] = 28;
        v[30] = 27;
        v[31] = 26;
    }

    private static void add(int here, int there) {
        map.get(here).add(there);
    }
}
