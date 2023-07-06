package 큰돌의터전알고리즘강의.two주차.트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

// 트리 : 루트 노드에서부터 탐색을 하자
public class Main {

    public static int n;
    public static int num;
    public static int[] arr;
    public static ArrayList<Integer>[] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = Arrays.stream(br.readLine().split( " ")).mapToInt(Integer::parseInt).toArray();
        num = Integer.parseInt(br.readLine());

        int root = 0;

        tree = new ArrayList[n]; // 이런식도 가능하다.

        for (int i = 0; i < n; i++) { // 미리 추가
            tree[i] = new ArrayList<>();
        }

        for (int i = 0; i < arr.length; i++) {

            if(arr[i] == -1){ // -1인경우, root
                root = i;
            }else{
                tree[arr[i]].add(i);
            }
        }

        if(num == root){ // 루트 노드가 삭제되는 경우
            System.out.println(0);
        }else{
            System.out.println(dfs(root)); // 그렇지 않은 경우
        }
    }

    public static int dfs(int here){
        int ret = 0;
        int child = 0;
        for(int there : tree[here]){ // 연결된 노드 탐색
            if(there == num){ // 삭제하려는 노드와 같은경우 탐색 x
                continue;
            }

            ret += dfs(there); // 더해준다.
            child++; // 자식 노드 더해줌
        }

        if(child == 0) return 1; // child가 0인경우 -> 맨끝 노드 1 반환 -> 자기 자신
        return ret;
    }
}
