package 큰돌의터전알고리즘강의.five주차.멀티탭스케줄링;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        List<Integer> list = new ArrayList<>();
        List<Integer> arr = new ArrayList<>();

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < k; i++) {
            arr.add(Integer.parseInt(st.nextToken()));
        }

        int answer = 0;

        for (int i = 0; i < k; i++) {
            int electronic = arr.get(i);

            if(list.contains(electronic)) continue; // 이미 꼽혀있는 경우

            if(list.size() < n){ // 플러그 꼽기
                list.add(electronic);
            }else{ // 플러그를 빼야하는 경우
                // 재사용해야하는 플러그인은 꼽아놓기
                List<Integer> subList = arr.subList(i,i+n);
                for(int value : subList){
                    if(!list.contains(value)){
                        list.remove(value);
                        answer++; // 뺀횟수 체크
                        break;
                    }
                }

                list.add(electronic); // 빠진 플러그에 꼽기
            }

        }

        System.out.println(answer);
    }
}
