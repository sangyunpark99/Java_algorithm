package 카카오2024인턴쉽.three;

import java.util.ArrayList;

// 1 ~ n 카드가 적힌 카드 뭉치, 동전 coin개 이용한 게임
// 1. 카드 뭉치에서 n/3장을 뽑아 모두 가진다. - 카드와 교환 가능한 동전 coin개
// 2. 라운드 시작시 카드 2장 뽑기, 카드뭉치에 남은 카드 x 게임 종료 뽑은 카드는 카드 한 장당 동전 하나를 소모해 가짐, 소모하지 않고 버림
// 3. 카드의 적힌 수의 합이 n+1이 되도록 카드 두 장을 내고 다음 라운드로 진행, 카드 두 장을 낼 수 없다면 게임 종료
// 4.

class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().solution(3, new int[]{1, 2, 3, 4, 5, 6, 7, 9, 10, 11, 12}));
    }

    public int solution(int coin, int[] cards) {
        int answer = 1;

        // 카드의 적힌 수의 합 n+1 :
        int sum = cards.length + 1;

        // 맨 처음 뽑은 카드
        ArrayList<Integer> initCard = new ArrayList<>();
        int nextCardIdx = 0;
        for (int i = 0; i < cards.length / 3; i++) {
            initCard.add(cards[i]);
            nextCardIdx++;
        }

        // 카드 뽑기 진행 2장씩
        for (int i = nextCardIdx; i < cards.length; i += 2) {
            int firstCard = cards[i];
            int secondCard = cards[i + 1];

            // sum 만들기 - 코인 갯수
            int value = check(initCard, firstCard, secondCard, coin, sum);

            if (initCard.size() == 0) {
                break;
            }

            if (value >= 0) {
                answer++;
            } else {
                break;
            }

        }

        return answer;
    }

    int check(ArrayList<Integer> initCard, int firstCard, int secondCard, int coin, int sum) {

        // 뽑으려는 두 카드와 자신이 갖고 있는 카드가 모두 짝이 있는 경우

        // 카드를 2장 뽑아
        // 1. 내카드 한장이랑 뽑은 카드 한장이 짝인 경우 - 1번째 뽑은 카드, 2번째 뽑은 카드, 카드뽑아서 내고 진행
        // 2. 내카드 두장다 뽑은 카드랑 짝을 가진 경우 - 아무거나 내고, 다음 라운드 진행
        // 3. 내카드는 짝이 없지만 뽑은 카드의 합이 맞는 경우 - 둘다 뽑고, 바로 내고 다음라운드 진행
        // 4. 내가 가지고 있는 카드로 충분히 짝을 만들 수 있는 경우

        if (coin == 1) { // 코인이 한개만 남은 경우
            for (int i = 0; i < initCard.size(); i++) { // 1.
                if (initCard.get(i) + firstCard == sum) {
                    initCard.remove(i); // 손에 쥐고 있는 카드 버리기
                    return coin - 1;
                }

                if (initCard.get(i) + secondCard == sum) {
                    initCard.remove(i); // 손에 쥐고 있는 카드 버리기
                    return coin - 1;
                }
            }
        }

        if (coin >= 2) { // 코인이 2개보다 많은 경우, 무조건 2장 사

            if (initCard.contains(sum - firstCard) && initCard.contains(sum - secondCard)) {

                initCard.remove(initCard.indexOf(sum - firstCard)); // 한장 소비

                return coin - 2;
            }
        }

        return -1;
    }
}
