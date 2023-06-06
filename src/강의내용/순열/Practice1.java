package 강의내용.순열;

// Practice1
// 1, 2, 3, 4 를 이용하여 세자리 자연수를 만드는 방법(순서 0, 중복 x)의 각 결과를 출력
// 방법 1

public class Practice1 {
    void permutation(int[] arr, int depth, int n, int r){

        if(depth == r) { // 3자리 자연수 인경우
            for (int i = 0; i < r; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            return;
        }

        for(int i = depth; i < n; i++){
            swap(arr,depth,i);
            permutation(arr,depth + 1, n, r);
            swap(arr,depth,i);
        }
    }

    void swap(int[] arr, int depth, int idx){
        int tmp = arr[depth];
        arr[depth] = arr[idx];
        arr[idx] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4};

        Practice1 p = new Practice1();
        p.permutation(arr,0,4,3); // 3자리 자연수를 만드는 방법
    }
}
