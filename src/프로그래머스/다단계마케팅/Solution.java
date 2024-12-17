package 프로그래머스.다단계마케팅;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
//        System.out.println(Arrays.toString(solution(
//                new String[]{
//                        "john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"
//                },
//                new String[]{
//                        "-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"
//                },
//                new String[]{
//                        "young", "john", "tod", "emily", "mary"
//                },
//                new int[]{
//                        12, 4, 2, 5, 10
//                }
//        )));

//        System.out.println(Arrays.toString(solution(
//                new String[]{
//                        "john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"
//                },
//                new String[]{
//                        "-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"
//                },
//                new String[]{
//                        "sam", "emily", "jaimie", "edward"
//                },
//                new int[]{
//                        2, 3, 5, 4
//                }
//        )));

        System.out.println(Arrays.toString(solution(
                new String[]{
                        "john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"
                },
                new String[]{
                        "-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"
                },
                new String[]{
                        "sam", "emily", "jaimie", "edward"
                },
                new int[]{
                        1, 1, 1, 1
                }
        )));
    }

    public static int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = new int[enroll.length];

        // 트리 구조 그리기

        List<Node> workers = new ArrayList<>();
        Node root = new Node("-");
        workers.add(root); // 최상위 노드 추가

        HashMap<String, Node> match = new HashMap<>();
        match.put("-", root);

        for (int i = 0; i < enroll.length; i++) {
            String name = enroll[i];
            Node node = new Node(name);
            workers.add(node);
            match.put(name, node);
        }

        // 부모 추가
        int idx = 1;
        for (String parent : referral) { // 부모 추가
            Node worker = workers.get(idx);
            worker.addParent(match.get(parent)); // 최상위 말고 다음 부터
            idx++;
        }

        // 최상단 -> 아래로
        for (int i = 0; i < seller.length; i++) {
            int sellMoney = amount[i] * 100;
            Node man = match.get(seller[i]);
            updateMoney(man, sellMoney);
        }

        for (int i = 0; i < enroll.length; i++) {
            answer[i] = workers.get(i + 1).money;
        }

        return answer;
    }

    public static void updateMoney(Node node, int sellMoney) {

        Node curNode = node;
        int money = sellMoney;

        while (curNode.parent != null) { // 부모를 타고 가면서 수수료 더해주기
            int fee = money / 10;
            int income = money - fee;

            curNode.money += income;

            curNode = curNode.parent;
            money = fee;

            if (money < 1) { //
                break;
            }
        }
    }

    public static class Node {
        String name;
        Node parent = null; // 기본값은 null -> 최상단은 null
        int money; // 누적 수익

        public Node(String name) {
            this.name = name;
        }

        public void addParent(Node node) { // 부모 추가
            this.parent = node;
        }

        @Override
        public String toString() {
            return
                    "name='" + name + '\'' +
                            ", money=" + money;
        }
    }
}
