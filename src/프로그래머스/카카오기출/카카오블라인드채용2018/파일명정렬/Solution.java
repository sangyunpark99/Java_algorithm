package 프로그래머스.카카오기출.카카오블라인드채용2018.파일명정렬;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Solution {

    class File {
        String fileName;
        String head;
        int number;

        File(String fileName, String head, String number) {
            this.fileName = fileName;
            this.head = head;
            this.number = Integer.parseInt(number);
        }
    }

    public String[] solution(String[] files) {
        String[] answer = new String[files.length];

        List<File> list = new ArrayList<>();

        for (int i = 0; i < files.length; i++) {
            String[] value = split(files[i]);
            list.add(new File(value[2], value[0], value[1]));
        }

        Collections.sort(list, new Comparator<File>() {
            @Override
            public int compare(File o1, File o2) {
                if (o1.head.equals(o2.head)) {
                    return o1.number - o2.number;
                }

                return o1.head.compareTo(o2.head);
            }
        });

        for (int i = 0; i < files.length; i++) {
            answer[i] = list.get(i).fileName;
        }

        return answer;
    }


    public String[] split(String s) {

        String head = "";
        String number = "";
        String name = s;

        boolean isMatchNumber = false;

        for (int i = 0; i < s.length(); i++) {

            char value = s.charAt(i);

            if (isMatchNumber && (value == '.' || value == '-' || value == ' ')) {
                break;
            }

            if (Character.isDigit(value)) {
                number += value;
                isMatchNumber = true;
            } else {
                head += value;
            }

        }

        return new String[]{head.toLowerCase(), number, name};
    }
}
