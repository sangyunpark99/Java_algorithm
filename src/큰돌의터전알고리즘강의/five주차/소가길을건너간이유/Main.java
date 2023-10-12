package 큰돌의터전알고리즘강의.five주차.소가길을건너간이유;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        List<cow> list = new ArrayList<>();

        for (int i = 0; i < n ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int startTime = Integer.parseInt(st.nextToken());
            int doTime = Integer.parseInt(st.nextToken());

            list.add(new cow(startTime, doTime));
        }

        // 시작 시간 기준으로 정렬

        list.sort(new Comparator<cow>() {
            @Override
            public int compare(cow o1, cow o2) {
                return o1.startTime - o2.startTime;
            }
        });

        int endTime = list.get(0).getEndTime();

        for (int i = 1; i < list.size(); i++) {

            int curStartTime = list.get(i).startTime;

            if(endTime < curStartTime){
                endTime = list.get(i).getEndTime();
            }else if(endTime >= curStartTime){
                endTime += list.get(i).doTime;
            }
        }

        System.out.println(endTime);
    }

    public static class cow {
        int startTime;
        int doTime;

        public cow(int startTime, int doTime){
            this.startTime = startTime;
            this.doTime = doTime;
        }

        public int  getEndTime(){
            return startTime + doTime;
        }
    }
}
