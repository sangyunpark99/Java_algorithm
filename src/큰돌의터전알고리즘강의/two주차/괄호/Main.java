package 큰돌의터전알고리즘강의.two주차.괄호;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) { // test 케이스
            StringTokenizer stk = new StringTokenizer(br.readLine());

            String[] arr = stk.nextToken().split("");

            Stack<String> stack = new Stack<>();

            int flag = 0;

            for (int j = 0; j < arr.length; j++) {
                if(arr[j].equals("(")){
                    stack.add("(");
                }else{
                    if(stack.size() > 0){
                        if(stack.peek().equals("(")){
                            stack.pop();
                        }
                    }else{
                        flag = 1;
                        System.out.println("NO");
                        break;
                    }
                }
            }

            if(flag == 0){
                if(stack.isEmpty()){
                    System.out.println("YES");
                }else{
                    System.out.println("NO");
                }
            }

            stack.clear();
        }

    }
}
