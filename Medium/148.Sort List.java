/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode sortList(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }
        ListNode middle = getMiddle(head);
        return mergeSort(sortList(head),sortList(middle));
    }
    
    public ListNode getMiddle(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        ListNode pre = null;
        while(fast!=null&&fast.next!=null){
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        pre.next = null;
        return slow;
    }
    
    public ListNode mergeSort(ListNode a, ListNode b){
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while(a!=null&&b!=null){
            if(a.val>b.val){
                cur.next = b;
                b = b.next;
            }else{
                cur.next = a;
                a = a.next;
            }
            cur = cur.next;
        }
        cur.next = a==null? b : a;
        return dummy.next;
    }
}