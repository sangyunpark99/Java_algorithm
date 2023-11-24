package 프로그래머스.카카오기출.카카오개발자겨울인턴십2019.호텔방배정;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    Map<Long, Long> emptyRooms = new HashMap<>();

    public long[] solution(long k, long[] room_number) {
        long[] answer = new long[room_number.length];

        for (int i = 0; i < room_number.length; i++) {
            answer[i] = findRoom(room_number[i]);
        }

        return answer;
    }

    private long findRoom(long roomNumber) {
        if (!emptyRooms.containsKey(roomNumber)) {
            emptyRooms.put(roomNumber, roomNumber + 1);
            return roomNumber;
        }

        long emptyRoom = findRoom(emptyRooms.get(roomNumber));
        emptyRooms.put(roomNumber, emptyRoom);
        return emptyRoom;
    }
}