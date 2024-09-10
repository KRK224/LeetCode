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
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        // initialized
        ListNode ln = new ListNode(head.val);
        ListNode c_ln = ln;

        while(head !=null) {
            if(head.next == null)
                break;
            ListNode gcd = new ListNode(getGCD(head.val, head.next.val));
            c_ln.next = gcd;
            // gcd.next = head.next
            // will loop forever, cause c_ln.next sets head.next
            gcd.next = new ListNode(head.next.val);
            head = head.next;
            c_ln = gcd.next;
        }
        return ln;
    }

    public int getGCD(int a, int b) {
        // base
        if(a%b == 0) {
            return b;
        } else {
            return getGCD(b, a%b);
        }
    }
}