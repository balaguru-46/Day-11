/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) {
 *         this.val = val;
 *         this.next = next;
 *     }
 * }
 */
class Solution {
    public ListNode modifiedList(int[] nums, ListNode head) {
        HashSet<Integer> set = new HashSet<>();

        // Store all values from nums in the HashSet
        for (int num : nums) {
            set.add(num);
        }

        // Dummy node to simplify deletion
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prev = dummy;
        ListNode curr = head;

        while (curr != null) {
            if (set.contains(curr.val)) {
                prev.next = curr.next; // Remove current node
            } else {
                prev = curr; // Move prev only if node is kept
            }
            curr = curr.next;
        }

        return dummy.next;
    }
}