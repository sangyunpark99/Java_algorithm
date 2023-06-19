package 강의내용.알고리즘.그리디;


import java.util.ArrayList;
import java.util.Collections;

class Activity {
    String name;
    int start;
    int end;

    public Activity(String name, int start, int end){
        this.name = name;
        this.start = start;
        this.end = end;
    }
}

public class Main {
    public static void main(String[] args) {

        ArrayList<Activity> list = new ArrayList<>();
        list.add(new Activity("A", 1, 5));
        list.add(new Activity("B", 4, 5));
        list.add(new Activity("C", 2, 3));
        list.add(new Activity("D", 4, 7));
        list.add(new Activity("E", 6, 10));
        selectActivity(list);
    }

    public static void selectActivity(ArrayList<Activity> list){
        Collections.sort(list, (x1,x2) -> x1.end - x2.end); // 오름 차순 정렬 - 끝나는 시간 기준으로

        int currentTime = 0;
        ArrayList<String> result = new ArrayList<>();

        for (Activity activity : list) {
            if(currentTime <= activity.start){
                result.add(activity.name);
                currentTime = activity.end;
            }
        }

        for (String s : result) {
            System.out.print(s + " ");
        }
    }
}
