package test.comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Node> list = new ArrayList<>();
        list.add(new Node("가"));
        list.add(new Node("나"));

        Collections.sort(list, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {

                System.out.println(o1.name);
                System.out.println(o2.name);

                return o1.name.compareTo(o2.name);
            }
        });
    }

    public static class Node {
        String name;

        Node(String name) {
            this.name = name;
        }
    }
}
