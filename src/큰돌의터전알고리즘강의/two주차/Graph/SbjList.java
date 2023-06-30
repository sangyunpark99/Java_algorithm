package 큰돌의터전알고리즘강의.two주차.Graph;

import java.util.ArrayList;
import java.util.Arrays;

public class SbjList {

    public static ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();

    public static int[] visited = new int[10];

    public static void main(String[] args) {

        for (int i = 0; i < 10; i++) {
            list.add(new ArrayList<>());
        } // 각 노드

        Arrays.fill(visited,0);

        list.get(1).add(2);
        list.get(2).add(1);
        list.get(1).add(3);
        list.get(3).add(1);
        list.get(3).add(4);

        System.out.println(list);

        // 출발점 찾기
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).size() > 0 && visited[i] == 0){ // 연결되어있는 정점이 있고, 해당 노드를 방문하지 않은 경우
                go(i);
            }
        }
    }

    public static void go(int from){
        System.out.println(from);
        visited[from] = 1;
        for (int i = 0; i < list.get(from).size(); i++) {
            if(visited[list.get(from).get(i)] == 0){ // 방문을 하지 않은 경우
                go(list.get(from).get(i));
            }
        }
        return;
    }
}
