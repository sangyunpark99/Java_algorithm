package 프로그래머스.행렬의곱셈;

public class Main {
    public static void main(String[] args) {

        int[][] arr1 = {{1, 4}, {3, 2}, {4, 1}};
        int[][] arr2 = {{3, 3}, {3, 3}};

        int[][] answer = new int[arr1.length][arr2[0].length];

        for (int i = 0; i < arr1.length; i++) { // 세로
            for (int j = 0; j < arr2[0].length; j++) { // 가로
                int tmp = 0;
                for (int k = 0; k < arr2.length; k++) { //
                    tmp += arr1[i][k] * arr2[k][j];
                }
                answer[i][j] = tmp;
            }
        }

        return;
    }
}
