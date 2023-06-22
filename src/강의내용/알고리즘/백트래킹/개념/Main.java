package 강의내용.알고리즘.백트래킹.개념;

// 모든 경우의 수를 탐색하며 최적해를 구하는 과정에서 유망하지 않은 쪽은 더 이상 구하지 않는 방법
// 돌다리 두드려보고 가는 느낌
// 용어
// - 유망(Promising) : 해가 도리 가능성이 있는 경우 유망하다고 함
// - 가지치기(Pruning) : 해가 될 가능성이 없는 경우 해당 노드를 제외 하는 것
// - 백 트래킹(Backtracking) : 유망하지 않은 쪽으로 가지 않고 되돌아 오는

// 백 트래킹 예시
// N - Queen 문제
// N x N 체스판에서 퀸 N개를 서로 공격할 수 없도록 배치하는 경우의 수
public class Main {

    static int n = 4;
    static int[] board = new int[n]; // 1차원 배열을 사용해서 행에 몇번째 열에 두었는지를 기록해준다.
    static int cnt;

    public static int nQueen(int row) {
        if(row == n){
            cnt++;
            for (int i = 0; i < n; i++) {
                System.out.print(board[i] + " ");
            }
            System.out.println();
            return cnt;
        }

        for (int i = 0; i < n; i++) {
            board[row] = i;

            // promising
            if(isPromising(row)){
                nQueen(row + 1);
            }
        }

        return cnt;
    }

    public static boolean isPromising(int row) {
        for (int i = 0; i < row; i++) {
            if(board[row] == board[i] || row - i == Math.abs(board[row] - board[i])){ // 같은 열, 대각선
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        // Test code
        System.out.println("경우의 수 : " + nQueen(0));
    }
}
