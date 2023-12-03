package 큰돌의터전알고리즘강의.two주차.원상복구노드;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static ArrayList<ArrayList<Integer>> list;
    public static List<Integer> answer;
    public static boolean[] visited;

    public static void main(String[] args) {
        list = new ArrayList<>();
        visited = new boolean[4];
        answer = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            list.add(new ArrayList<>());
        }

        list.get(0).add(1);
        list.get(1).add(0);

        list.get(1).add(2);
        list.get(2).add(1);

        list.get(1).add(3);
        list.get(3).add(1);

        visited[0] = true;

        answer = new ArrayList<>();
        answer.add(0);
        go(0);
    }

    public static void go(int here) {
        if (answer.size() == 3) {
            System.out.println(answer);
            return;
        }

        for (int there : list.get(here)) {
            if (visited[there]) {
                continue;
            }
            visited[there] = true;
            answer.add(there);
            go(there);
            visited[there] = false;
            answer.remove(answer.indexOf(there));
        }
    }
}
