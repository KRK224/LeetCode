/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode middleNode(ListNode head) {
        
        ListNode iter = head;
        ListNode answer = iter;
        int midIdx = 1;
        int currentIdx = 1;
        while(iter.next != null) {
            iter = iter.next;
            currentIdx++;
            while(midIdx <= currentIdx / 2) {
                answer = answer.next;
                midIdx++;
            }
        }
        return answer;
    }
}