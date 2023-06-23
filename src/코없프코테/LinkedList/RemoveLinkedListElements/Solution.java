package 코없프코테.LinkedList.RemoveLinkedListElements;

public class Solution {

    public class ListNode{
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(-1); // 맨 앞에 더미로 하나 추가하기

        dummy.next = head; // 순서 이어주기

        ListNode cur = dummy; // 현재 Node는 더미 선택

        while(cur.next != null){ // next 돌려 (없을 때까지)
            if(cur.next.val == val){ // 찾고자 하는 값이 존재하는 경우
                cur.next = cur.next.next; // 다음값 뛰어 넘기
            }else{ // 그렇지 않은 경우 cur.next
                cur = cur.next;
            }
        }

        return dummy.next;
    }
}
