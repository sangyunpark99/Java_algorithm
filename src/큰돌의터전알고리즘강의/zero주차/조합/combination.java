package 큰돌의터전알고리즘강의.zero주차.조합;

public class combination {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        boolean[] visited = {false, false, false, false};

        combination(arr,visited,0,4,3);
    }

    public static void combination(int[] arr, boolean[] visited, int depth, int n, int r){
        if(r == 0){
            for (int i = 0; i < n; i++) {
                if(visited[i]){
                    System.out.print(arr[i] + " ");
                }
            }
            System.out.println();
            return;
        }

        if(depth == n){
            return;
        }

        visited[depth] = true;
        combination(arr, visited, depth + 1, n, r-1);

        visited[depth] = false;
        combination(arr, visited, depth + 1, n, r);

    }
}
