/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null)return head;
        ListNode next = head.next;
        head.next = null;
        return recursion(head, next);
    }
    
    public ListNode recursion(ListNode head, ListNode next) {
        if(next==null) return head;
        ListNode tmp = next.next;
        next.next = head;
        return recursion(next, tmp);
    }
}