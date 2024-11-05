package 백준.큐빙;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static char[][] up;
    public static char[][] down;
    public static char[][] front;
    public static char[][] back;
    public static char[][] left;
    public static char[][] right;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            String[] data = br.readLine().split(" ");
            up = new char[][]{{'w', 'w', 'w'}, {'w', 'w', 'w'}, {'w', 'w', 'w'}};
            down = new char[][]{{'y', 'y', 'y'}, {'y', 'y', 'y'}, {'y', 'y', 'y'}};
            front = new char[][]{{'r', 'r', 'r'}, {'r', 'r', 'r'}, {'r', 'r', 'r'}};
            back = new char[][]{{'o', 'o', 'o'}, {'o', 'o', 'o'}, {'o', 'o', 'o'}};
            left = new char[][]{{'g', 'g', 'g'}, {'g', 'g', 'g'}, {'g', 'g', 'g'}};
            right = new char[][]{{'b', 'b', 'b'}, {'b', 'b', 'b'}, {'b', 'b', 'b'}};

            for (int j = 0; j < n; j++) {
                String str = data[i];
                char move = str.charAt(0);
                char dir = str.charAt(1);

                if (move == 'U') {

                } else if (move == 'D') {

                } else if (move == 'F') {

                } else if (move == 'B') {

                } else if (move == 'L') {

                } else if (move == 'R') {

                }
            }
        }
    }

    public static void rotateU(char dir) {
        if (dir == '+') {
            up = rotateClock(up);
            char[] temp = back[0];
            back[0] = left[0];
            left[0] = front[0];
            front[0] = right[0];
            right[0] = temp;
        } else if (dir == '-') {
            up = rotateNotClock(up);
            char[] temp = back[0].clone();
            back[0] = right[0].clone();
            right[0] = front[0].clone();
            front[0] = left[0].clone();
            left[0] = temp;
        }
    }

    public static void rotateD(char dir) {
        if (dir == '+') {
            down = rotateClock(down);

            char[] temp = back[2].clone();
            back[2] = right[2].clone();
            right[2] = front[2].clone();
            front[2] = left[2].clone();
            left[2] = temp;
        } else {
            down = rotateNotClock(down);

            char[] temp = back[2].clone();
            back[2] = left[2].clone();
            left[2] = front[2].clone();
            front[2] = right[2].clone();
            right[2] = temp;
        }
    }

    public static void rotate_F(char dir) {
        if (dir == '+') {
            front = rotateClock(front);
            // 윗 - 오 - 바 - 왼 - 윗
            char[] temp = new char[3];
            for (int i = 0; i < 3; i++) {
                temp[i] = up[2][i];
            }

            for (int i = 0; i < 3; i++) {
                up[2][i] = left[2 - i][2];
            }

            for (int i = 0; i < 3; i++) {
                left[i][2] = down[2][2 - i];
            }

            for (int i = 0; i < 3; i++) {
                down[2][i] = right[i][0];
            }

            for (int i = 0; i < 3; i++) {
                right[i][0] = temp[i];
            }


        } else {
            front = rotateNotClock(front);
            // 윗 - 왼 - 바 - 오 - 윗
            char[] temp = new char[3];
            for (int i = 0; i < 3; i++) {
                temp[i] = up[2][2 - i];
            }

            for (int i = 0; i < 3; i++) {
                up[2][i] = right[i][0];
            }

            for (int i = 0; i < 3; i++) {
                right[i][0] = down[2][i];
            }

            for (int i = 0; i < 3; i++) {
                down[2][i] = left[2 - i][2];
            }

            for (int i = 0; i < 3; i++) {
                left[i][2] = temp[i];
            }

        }
    }


    // 시계 방향 회전
    public static char[][] rotateClock(char[][] arr) {
        char[][] rotate = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                rotate[i][j] = arr[3 - 1 - j][i];
            }
        }

        return rotate;
    }

    // 반시계 방향으로 90도 회전
    public static char[][] rotateNotClock(char[][] arr) {
        char[][] rotate = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) { // 0, 1, 2
                rotate[i][j] = arr[j][3 - 1 - i];
            }
        }

        return rotate;
    }
}
