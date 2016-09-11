23 Merge k Sorted Lists
public class Solution {
    public ListNode mergeKLists(List<ListNode> lists) {
        if (lists == null || lists.size() == 0) { return null; }
        int end = lists.size() - 1;
        while (end > 0) {
            int start = 0; 
            while (start < end) {
                lists.set(start, mergeTwoLists(lists.get(start), lists.get(end)));
                start++;
                end--;
            }
        }
        return lists.get(0);

    }
    
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode p = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                p.next = new ListNode(l2.val);
                l2 = l2.next;
            } else {
                p.next = new ListNode(l1.val);
                l1 = l1.next;
            }
            p = p.next;
        }
        if (l1 != null) {
            p.next = l1;
        }
        if (l2 != null) {
            p.next = l2;
        }
        return dummy.next;
    }
}
2) heap
public class Solution {
    public ListNode mergeKLists(List<ListNode> lists) {
        Queue<ListNode> heap = new PriorityQueue(new Comparator<ListNode>(){
            @Override public int compare(ListNode l1, ListNode l2) { 
                return l1.val - l2.val; 
            }
        });
        ListNode head = new ListNode(0), tail = head;
        for (ListNode node : lists) if (node != null) heap.offer(node);
        while (!heap.isEmpty()) {
            tail.next = heap.poll();
            tail = tail.next;
            if (tail.next != null) heap.offer(tail.next);
        }
        return head.next;
    }
}
