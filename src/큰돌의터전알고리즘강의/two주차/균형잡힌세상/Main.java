package 큰돌의터전알고리즘강의.two주차.균형잡힌세상;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

// 괄호 짝 : stack
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true){
            String s = br.readLine();

            Stack<String> stack = new Stack<>(); // 새로운 stack을 정의

            boolean answer = true;

            if(s.equals(".")){
                break;
            }

            for (int i = 0; i < s.length(); i++) {

                String a = String.valueOf(s.charAt(i));

                if(a.equals("(") || a.equals("[")){
                    stack.push(a);
                }else if(a.equals(")")){
                    if(stack.size()>0 && stack.peek().equals("(")){
                        stack.pop();
                    }else{
                        answer = false;
                        break;
                    }
                } else if(a.equals("]")){
                    if(stack.size()>0 && stack.peek().equals("[")){
                        stack.pop();
                    }else{
                        answer = false;
                        break;
                    }
                }
            }
            if(stack.size()==0 && answer){
                System.out.println("yes");
            }else{
                System.out.println("no");
            }
        }
    }
}
