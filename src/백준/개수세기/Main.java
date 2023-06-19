package 백준.개수세기;

import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.valueOf(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        HashMap<Integer, Integer> map = new HashMap<>();

        while(st.hasMoreTokens()){
            int value = Integer.parseInt(st.nextToken());
            map.put(value,map.getOrDefault(value,0)+1);
        }

        int v = Integer.valueOf(br.readLine());

        if(map.containsKey(v)){
            System.out.println(map.get(v));
        }else{
            System.out.println(0);
        }
    }
}
