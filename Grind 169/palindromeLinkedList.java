/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        // If LL is empty, it is palindrome
        if (head == null) {
            return true;
        }

        // Get the middle element of linked list

        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Reverse the second half of linked list

        ListNode cur = null, head2 = slow.next;
        slow.next = null;
        while (head2 != null) {
            ListNode next = head2.next;
            head2.next = cur;
            cur = head2;
            head2 = next;
        }

        // Check if 1st half of LL & reversed 2nd half of LL is same

        ListNode h1 = head, h2 = cur;
        while (h2 != null) {
            if (h2.val != h1.val)
                return false;
            h1 = h1.next;
            h2 = h2.next;
        }
        return true;
    }
}