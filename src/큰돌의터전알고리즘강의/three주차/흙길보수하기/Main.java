package 큰돌의터전알고리즘강의.three주차.흙길보수하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static int N;
    public static int L;
    public static List<Puddle> puddles;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(br.readLine());

        N = Integer.parseInt(stk.nextToken());
        L = Integer.parseInt(stk.nextToken());
        puddles = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            stk = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(stk.nextToken());
            int end = Integer.parseInt(stk.nextToken());
            puddles.add(new Puddle(start, end));
        }

        Collections.sort(puddles, new Comparator<Puddle>() {
            @Override
            public int compare(Puddle o1, Puddle o2) {

                if (o1.start == o2.start) {
                    return o1.end - o2.end;
                }

                return o1.start - o2.start;
            }
        });

        int res = 0;
        int count = 0;
        int idx = 0; // 널빤지 끝부분의 위치
        for (int i = 0; i < N; i++) {
            Puddle cur = puddles.get(i);
            int start = cur.start;
            int end = cur.end;

            if (end <= idx) {
                continue; // 이미 다 채운 경우
            }
            if (idx < start) { // 웅덩이 시작전
                count = ((end - start) / L) + ((end - start) % L > 0 ? 1 : 0);
                idx = start + count * L;
            } else { // 웅덩이가 전 널빤지에 겹치는 경우 - 겹치는 부분제거
                count = ((end - idx) / L) + ((end - idx) % L > 0 ? 1 : 0);
                idx = idx + count * L;
            }

            res += count;
        }

        System.out.println(res);
    }

    public static class Puddle {
        int start;
        int end;

        Puddle(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
