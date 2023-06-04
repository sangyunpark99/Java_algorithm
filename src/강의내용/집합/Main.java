package 강의내용.집합;

import java.util.Arrays;
import java.util.HashSet;

public class Main {
    // Set
    public static void main(String[] args) {
        // 1. 자바에서 집합 사용 - HashSet
        System.out.println("== HashSet ==");
        HashSet set1 = new HashSet();
        set1.add(1);
        set1.add(1);
        set1.add(1);
        System.out.println("set1 = " + set1); // 중복 허용 안됨

        set1.add(2);
        set1.add(3);
        System.out.println("set1 = " + set1);
        set1.remove(1);
        System.out.println("set1 = " + set1);
        System.out.println(set1.size());
        System.out.println(set1.contains(2)); // 데이터가 포함되어있는지 확인

        //2. 집합 연산
        System.out.println("== 집합 연산 ==");

        //2-1. 교집합
        HashSet a = new HashSet(Arrays.asList(1,2,3,4,5));
        // Arrays.asList : 일반 배열을 arrayList로 반환한다.
        HashSet b = new HashSet(Arrays.asList(2,4,6,8,10));
//        a.retainAll(b);
//        System.out.println("교집합: " + a);

        //2-2. 합집합
//        a.addAll(b);
//        System.out.println("합집합: " + a);

        //2-3. 차집합
        a.removeAll(b);
        System.out.println("차집합: " + a);
    }
}
