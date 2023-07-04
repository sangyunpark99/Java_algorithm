package 큰돌의터전알고리즘강의.two주차.NBA농구;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 시,분이 나오는 경우 하나의 단위로 통일 -> 분,초인경우 초로!
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int aSum = 0;
        int bSum = 0;
        int A = 0;
        int B = 0;

        String prev ="00:00";
        for (int i = 0; i < n; i++) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            int team = Integer.parseInt(stk.nextToken());
            String time = stk.nextToken();

            if(A > B){
                aSum += go(time,prev); // 현재 시간에서 이전시간 빼줌
            }else if(B > A){ // 현재 시간에서 이전시간 빼줌
                bSum += go(time,prev);
            }

           if(team == 1){ // 1인경우
               A++;
           }else{
               B++;
           }

           prev = time; // prev 갱신
        }

        // 끝나기 전 시간
        if(A > B){
            aSum += go("48:00",prev);
        }else if(B > A){
            bSum += go("48:00",prev);
        }


        print(aSum);
        print(bSum);
    }

    public static void print(int sum){
        int minute = sum/60;
        int second = sum%60;

        System.out.printf("%02d:%02d\n",minute,second);
    }

    public static int go(String time, String prev){
        return changeMinuteToSecond(time) - changeMinuteToSecond(prev);
    }

    public static int changeMinuteToSecond(String time){
        int minute = Integer.parseInt(time.substring(0,2));
        int second = Integer.parseInt(time.substring(3,5));

        return minute*60 + second;
    }
}
