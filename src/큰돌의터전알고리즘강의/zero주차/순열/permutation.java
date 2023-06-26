package 큰돌의터전알고리즘강의.zero주차.순열;

public class permutation {
    public static void main(String[] args) {

        int[] arr = {1,2,3};

        permutation(arr, 0, 3,3);
    }

    public static void permutation(int[] arr, int depth, int n, int r){
        if(depth == r){
            for (int i = 0; i < r; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i = depth; i < n; i++) {
            swap(arr, depth, i);
            permutation(arr, depth+1, n, r);
            swap(arr, depth, i);
        }
    }

    public static void swap(int[] arr, int depth, int idx){ // swap
        int tmp = arr[depth];
        arr[depth] = arr[idx];
        arr[idx] = tmp;
    }
}
