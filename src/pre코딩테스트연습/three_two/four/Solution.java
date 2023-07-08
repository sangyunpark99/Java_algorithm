package pre코딩테스트연습.three_two.four;

public class Solution {
    public boolean solution(boolean[][] matrix, boolean b) {
        boolean answer = true;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if(matrix[i][j] != b){
                    return false;
                }
            }
        }

        return answer;
    }
}
