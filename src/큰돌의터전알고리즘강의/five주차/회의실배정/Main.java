package 큰돌의터전알고리즘강의.five주차.회의실배정;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        int answer = 0;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;

        int N = Integer.parseInt(br.readLine());

        ArrayList<ArrayList<Integer>> list = new ArrayList<>();

        for (int i = 0; i < N; i++) { // 배열 받기
            stk = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(stk.nextToken());
            int second = Integer.parseInt(stk.nextToken());

            list.add(new ArrayList<>(List.of(first,second)));
        }

        // 두번째 값 기준으로 정렬하기 (끝나는시간 기준)
        Collections.sort(list, new Comparator<ArrayList<Integer>>() {
            @Override
            public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {

                if(Objects.equals(o1.get(1), o2.get(1))){
                    return o1.get(0) - o2.get(0);
                }

                return o1.get(1) - o2.get(1);
            }
        });

        int endTime = list.get(0).get(1);
        // 맨처음 회의
        answer++;

        for (int i = 1; i < list.size(); i++) {
            int nxtStartTime = list.get(i).get(0);
            int nxtEndTime = list.get(i).get(1);

            if(endTime <= nxtStartTime){ // 이전 회의가 끝나는 시간이랑 다음 회의 시작시간이 같거나 큰경우
                answer++; // 정답 추가
                endTime = nxtEndTime; // 시작시간을 다음회의 끝나는 시간으로 갱신
            }
        }

        System.out.println(answer);
    }
}
