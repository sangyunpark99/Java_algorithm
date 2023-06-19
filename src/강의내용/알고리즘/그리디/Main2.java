package 강의내용.알고리즘.그리디;

import java.util.HashMap;
import java.util.Map;

public class Main2 {
    public static void main(String[] args) {
        getChangeCoins(1000,100);
        getChangeCoins(1234, 500);


    }

    public static void getChangeCoins(int money, int price){
        int[] coins = {500, 100, 50, 10, 5, 1};

        int change = money - price;

        int cnt = 0;

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < coins.length; i++) {
            if(change < coins[i]){ // 거스름돈이 더 작은 액수로 남아있는 경우
                continue;
            }

            // 그렇지 않은 경우
            int num = change/coins[i]; // 동전 갯수
            change %= coins[i]; // 액수만큼 빼주기

            cnt += num;

            map.put(coins[i],map.getOrDefault(coins[i],0)+num); // 동전 갯수 만큼 더해줘
        }

        System.out.println(cnt);
    }
}
