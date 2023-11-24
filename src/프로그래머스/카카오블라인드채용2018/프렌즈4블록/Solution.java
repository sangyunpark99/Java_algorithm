package 프로그래머스.카카오블라인드채용2018.프렌즈4블록;

import java.util.ArrayList;
import java.util.List;

class Solution {

    char[][] block;

    public int solution(int m, int n, String[] board) {
        int answer = 0;

        init(m, n, board);

        List<Node> removeList = new ArrayList<>();

        while (true) {

            removeList = remove(m, n, block);

            update(removeList);

            arrangeBoard(m, n);

            if (removeList.size() == 0) {
                break;
            }

            answer += removeList.size();

        }

        return answer;
    }

    public void init(int m, int n, String[] board) { // init

        block = new char[m][n];

        for (int i = 0; i < m; i++) {
            block[i] = board[i].toCharArray();
        }
    }

    public void update(List<Node> removeList) {

        for (int i = 0; i < removeList.size(); i++) { // 한 사이클
            Node cur = removeList.get(i);
            block[cur.y][cur.x] = '@';
        }
    }

    public void arrangeBoard(int m, int n) { // 한 줄마다 변경

        ArrayList<String> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                list.add(String.valueOf(block[j][i]));
            }

            int rmCnt = 0;

            for (int k = 0; k < list.size(); k++) {
                if (list.get(k).equals("@")) {
                    list.remove(k);
                    rmCnt++;
                    k--;
                }
            }

            for (int l = 0; l < rmCnt; l++) {
                list.add(0, "@");
            }

            for (int k = 0; k < list.size(); k++) {
                block[k][i] = list.get(k).charAt(0);
            }

            list.clear();
            rmCnt = 0;
        }
    }

    public List<Node> remove(int m, int n, char[][] block) { // 한사이클 제거

        List<Node> list = new ArrayList<>();
        boolean[][] checks = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (block[i][j] != '@' && check(i, j, n, m)) { // 2x2 묶음
                    // 제거할 좌표 저장
                    checks[i][j] = true;
                    checks[i][j + 1] = true;
                    checks[i + 1][j + 1] = true;
                    checks[i + 1][j] = true;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (checks[i][j]) {
                    list.add(new Node(j, i));
                }
            }
        }

        return list;
    }

    public boolean check(int y, int x, int n, int m) {
        char value = block[y][x];
        int[] dx = {1, 1, 0};
        int[] dy = {0, 1, 1};

        for (int i = 0; i < 3; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                return false;
            }
            if (block[ny][nx] != value) {
                return false;
            }
        }

        return true;
    }

    class Node {
        int x;
        int y;

        Node(int x, int y) {
            this.y = y;
            this.x = x;
        }
    }

}