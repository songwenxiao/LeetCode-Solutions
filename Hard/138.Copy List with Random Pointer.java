/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) return null;
        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        
        RandomListNode newHead = new RandomListNode(head.label);
        map.put(head, newHead);
        RandomListNode next = head, newNext = newHead;
        while (next.next != null) {
            newNext.next = new RandomListNode(next.next.label);
            map.put(next.next, newNext.next);
            next = next.next;
            newNext = newNext.next;
        }
        next = head;
        newNext = newHead;
        while (next != null) {
            if (next.random != null) 
                newNext.random = map.get(next.random);
            next = next.next;
            newNext = newNext.next;
        }
        return newHead;
    }
}