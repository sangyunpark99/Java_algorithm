package 큰돌의터전알고리즘강의.five주차.문자열폭발;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String a = br.readLine();
        String b = br.readLine();

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < a.length(); i++) {
            sb.append(a.charAt(i));

            if(sb.length() >= b.length()){
                int start = sb.length()-1 - (b.length() - 1);
                int end = sb.length()-1;
                String sub = sb.substring(start,end+1);
                if(sub.equals(b)){
                    sb = sb.delete(start,end+1);
                }
            }
        }


        String answer = sb.toString();

        if(answer.length() == 0){
            answer = "FRULA";
        }

        bw.write(answer);
        bw.flush();
        bw.close();
        br.close();
    }
}
