package 강의내용.집합;

import java.util.ArrayList;

class MySet {
    //ArrayList
    ArrayList<Integer> list;

    // 생성자 1
    MySet(){
        this.list = new ArrayList<Integer>();
    }

    // 생성자 2
    MySet(int[] array){
        this.list = new ArrayList<Integer>();

        for (int item : array) {
            this.list.add(item);
        }
    }

    // 원소 추가(중복 X)
    public void add(int x){
        for(int item : this.list){
            if(item == x){ // 같은 값이 존재하는 경우
                return;
            }
        }
        this.list.add(x); // 같은 값이 존재하지 않는 경우
    }

    // 교집합
    public MySet retainAll(MySet b){
        MySet result = new MySet();

        for(int itemA : this.list){
            for(int itemB : b.list){
                if(itemA == itemB){
                    result.add(itemA);
                }
            }
        }

        return result;
    }

    // 합집합
    public MySet addAll(MySet b){

        MySet result = new MySet();

        for (int itemA : this.list) { // itemA 넣기
            result.add(itemA);
        }

        for (int itemB : b.list) { // itemB 넣기
            result.add(itemB);
        }

        return result;
    }

    // 차집합
}

public class Practice {
    public static void main(String[] args) {
        // Test code
        MySet a = new MySet();
    }
}
