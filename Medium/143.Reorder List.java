public class Solution {
    public void reorderList(ListNode head) {
        if(head==null) return;
            ListNode slow = head, fast = head;
            while(fast!=null && fast.next!=null){
                slow = slow.next;
                fast = fast.next.next;
            }
            ListNode mid = slow, cur = slow.next;
            if(cur!=null){
                ListNode tmp = cur.next;
                cur.next = null;
                cur = tmp;
            }
            while(cur!=null){
                ListNode tmp = cur.next;
                cur.next = mid.next;
                mid.next = cur;
                cur = tmp;
            }
            ListNode left = head, right = mid.next;
            while(right!=null){
                mid.next = right.next;
                right.next = left.next;
                left.next = right;
                left = right.next;
                right = mid.next;
            }
    }
}