package 큰돌의터전알고리즘강의.two주차.DFS;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    static int[] visited = new int[6];

    static ArrayList<ArrayList<Integer>> map = new ArrayList<ArrayList<Integer>>();

    public static void main(String[] args) {

        Arrays.fill(visited,0);

        for (int i = 0; i < 6; i++) {
            map.add(new ArrayList<>());
        }

        map.get(1).add(2);
        map.get(1).add(3);
        map.get(2).add(4);
        map.get(4).add(2);
        map.get(2).add(5);

        dfs(1);

    }

    public static void dfs(int from){
        visited[from] = 1;
        System.out.println(from);

        for (int i = 0; i < map.get(from).size(); i++) {
            if(visited[map.get(from).get(i)]== 0){
                dfs(map.get(from).get(i));
            }
        }
    }
}
