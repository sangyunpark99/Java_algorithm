package 강의내용.스택;

import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        Stack stack = new Stack();

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        System.out.println(stack);

        stack.pop();
        System.out.println(stack);

        System.out.println(stack.peek()); // stack의 가장 마지막에 들어가있는 값을

        System.out.println(stack.contains(1)); // 1의 데이터가 존재하는지 물어봄

        System.out.println(stack.size());

        stack.clear();
        System.out.println(stack);
    }
}
