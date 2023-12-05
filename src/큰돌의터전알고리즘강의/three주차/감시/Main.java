package 큰돌의터전알고리즘강의.three주차.감시;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static int N;
    public static int M;
    public static char[][] map;
    public static List<CCTV> cctvs;
    public static int ret;

    public static int[] dy = {-1, 0, 1, 0};
    public static int[] dx = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        // cctv 경우의 수 선택
        // 색칠하기
        // 수를 센후 제일 큰값일 경우 그대로 유

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        cctvs = new ArrayList<>();
        ret = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = st.nextToken().charAt(0);
                if (map[i][j] != '0' && map[i][j] != '6') {
                    cctvs.add(new CCTV(i, j));
                }
            }
        }

        dfs(0);

        System.out.println(ret);
    }

    public static void dfs(int here) {
        if (here == cctvs.size()) { // cctv 갯수
            int cnt = 0;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (map[i][j] == '0') {
                        cnt++;
                    }
                }
            }

            ret = Math.min(cnt, ret);
            return;
        }

        for (int i = 0; i < 4; i++) { // 완탐
            List<CCTV> list = go(here, i);
            dfs(here + 1);
            clear(list);
        }
    }

    public static void clear(List<CCTV> list) {
        for (int i = 0; i < list.size(); i++) {
            CCTV cctv = list.get(i);
            map[cctv.y][cctv.x] = '0';
        }
    }

    public static List<CCTV> go(int here, int dir) { // here cctv 갯수
        List<CCTV> list = new ArrayList<>();

        int x = cctvs.get(here).x;
        int y = cctvs.get(here).y;

        if (map[y][x] == '1') { // 1인 경우
            while (true) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];

                if (ny >= 0 && ny < N && nx >= 0 && nx < M && map[ny][nx] != '6') {
                    if (map[ny][nx] == '0') {
                        map[ny][nx] = '#';
                        list.add(new CCTV(ny, nx));
                    }

                    x = nx;
                    y = ny;

                } else {
                    break;
                }
            }
        } else if (map[y][x] == '2') { // 2인 경우

            for (int i = 0; i <= 2; i += 2) { // 2씩 증가
                int _y = y;
                int _x = x;

                while (true) {
                    int ny = _y + dy[(dir + i) % 4];
                    int nx = _x + dx[(dir + i) % 4];

                    if (ny >= 0 && ny < N && nx >= 0 && nx < M && map[ny][nx] != '6') {
                        if (map[ny][nx] == '0') {
                            map[ny][nx] = '#';
                            list.add(new CCTV(ny, nx));
                        }

                        _y = ny;
                        _x = nx;

                    } else {
                        break;
                    }
                }
            }
        } else if (map[y][x] == '3') {
            for (int i = 0; i <= 1; i++) { // 2씩 증가
                int _y = y;
                int _x = x;

                while (true) {
                    int ny = _y + dy[(dir + i) % 4];
                    int nx = _x + dx[(dir + i) % 4];

                    if (ny >= 0 && ny < N && nx >= 0 && nx < M && map[ny][nx] != '6') {
                        if (map[ny][nx] == '0') {
                            map[ny][nx] = '#';
                            list.add(new CCTV(ny, nx));
                        }

                        _y = ny;
                        _x = nx;

                    } else {
                        break;
                    }
                }
            }
        } else if (map[y][x] == '4') {
            for (int i = 0; i <= 2; i++) {
                int _y = y;
                int _x = x;

                while (true) {
                    int ny = _y + dy[(dir + i) % 4];
                    int nx = _x + dx[(dir + i) % 4];

                    if (ny >= 0 && ny < N && nx >= 0 && nx < M && map[ny][nx] != '6') {
                        if (map[ny][nx] == '0') {
                            map[ny][nx] = '#';
                            list.add(new CCTV(ny, nx));
                        }

                        _y = ny;
                        _x = nx;

                    } else {
                        break;
                    }
                }
            }
        } else if (map[y][x] == '5') {
            for (int i = 0; i <= 3; i++) {
                int _y = y;
                int _x = x;

                while (true) {
                    int ny = _y + dy[(dir + i) % 4];
                    int nx = _x + dx[(dir + i) % 4];

                    if (ny >= 0 && ny < N && nx >= 0 && nx < M && map[ny][nx] != '6') {
                        if (map[ny][nx] == '0') {
                            map[ny][nx] = '#';
                            list.add(new CCTV(ny, nx));
                        }

                        _y = ny;
                        _x = nx;

                    } else {
                        break;
                    }
                }
            }
        }

        return list;
    }

    public static class CCTV {
        int y;
        int x;

        public CCTV(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
