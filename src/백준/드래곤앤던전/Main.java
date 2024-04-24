package 백준.드래곤앤던전;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    public static long[][] rooms;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        long atk = Long.parseLong(st.nextToken());

        rooms = new long[n][3];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            rooms[i][0] = Long.parseLong(st.nextToken());
            rooms[i][1] = Long.parseLong(st.nextToken());
            rooms[i][2] = Long.parseLong(st.nextToken());
        }

        bw.write(binarySearch(atk) + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    public static long binarySearch(long atk) {
        long start = 0;
        long end = (long) 1e18;

        while (start <= end) {
            long mid = (start + end) / 2;

            if (check(mid, atk)) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return start;
    }

    public static boolean check(long maxHP, long atk) {
        long hp = maxHP;

        for (long[] room : rooms) {
            long t = room[0];
            long a = room[1];
            long h = room[2];

            if (t == 1L) {
                if (h % atk == 0L) {
                    hp -= (h / atk - 1) * a;
                } else {
                    hp -= (h / atk) * a;
                }

                if (hp <= 0) {
                    return false;
                }
            } else if (t == 2L) {
                atk += a;
                hp = Math.min(maxHP, hp + h);
            }
        }

        return true;
    }
}