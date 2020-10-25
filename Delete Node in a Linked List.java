//https://leetcode.com/problems/delete-node-in-a-linked-list/submissions/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
        while (node.next != null) {
            node.val = node.next.val;
            ListNode prev = node;
            node = node.next;
            if (node.next == null)
                prev.next = null;
        }
            
    }
}