package 프로그래머스.카카오기출.카카오2023.택배배달과수거하기;

import java.util.ArrayList;

class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().solution(4, 5, new int[]{1, 0, 3, 1, 2}, new int[]{0, 3, 0, 4, 0}));
    }


    class Home {
        int deliverBox;
        int pickUpBox;

        public Home(int deliverBox, int pickUpBox) {
            this.deliverBox = deliverBox;
            this.pickUpBox = pickUpBox;
        }
    }

    class Truck {
        int cap;
        int deliverBox;

        public Truck(int cap, int deliverBox) {
            this.cap = cap;
            this.deliverBox = deliverBox;
        }

        public int getEmptyBox() {
            return cap - deliverBox;
        }
    }

    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;

        // 택배싣고 - 최대한 많이 실기

        ArrayList<Home> homes = new ArrayList<>();
        int firstVisit = deliveries.length - 1;

        // 제일 끝의 박스가 택배 수용 용량보다 큰 경우
        int box = deliveries[firstVisit] > cap ? cap : deliveries[firstVisit];

        Truck truck = new Truck(cap, box);

        for (int i = 0; i < deliveries.length; i++) {
            homes.add(new Home(deliveries[i], pickups[i]));
        }

        // 갔다가 - 택배 주기
        if (homes.get(firstVisit).deliverBox <= box) { // 택배 수거
            homes.get(firstVisit).deliverBox = 0;
        } else {
            homes.get(firstVisit).deliverBox -= box;
        }

        // 돌아오기 - 택배 수거
        if (homes.get(firstVisit).pickUpBox <= box) {
            for (int i = homes.size() - 1; i >= 0; i--) {
                if (truck.getEmptyBox() >= homes.get(firstVisit).pickUpBox) {
                    homes.get(firstVisit).pickUpBox = 0;
                    break;
                } else {
                    homes.get(firstVisit).pickUpBox -= box;
                }
            }
        }

        if (homes.get(firstVisit).deliverBox == 0 && homes.get(firstVisit).pickUpBox == 0) {
            homes.remove(firstVisit);
        }

        answer += 2 * (firstVisit + 1);

        // 비어있는지 확인

        return answer;
    }
}
