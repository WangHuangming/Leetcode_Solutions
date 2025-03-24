package isPalindrome;

import java.util.ArrayList;
import java.util.List;

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

// make LinkedList to Arraylist and compare the values from both ends
// class Solution {
//     public boolean isPalindrome(ListNode head) {
//         if (head == null || head.next == null) {
//             return true;
//         }

//         // Step 1: Store the values of the linked list in an ArrayList
//         List<Integer> values = new ArrayList<>();
//         ListNode current = head;
//         while (current != null) {
//             values.add(current.val);
//             current = current.next;
//         }

//         // Step 2: Use two pointers to compare the values from both ends
//         int left = 0;
//         int right = values.size() - 1;
//         while (left < right) {
//             if (!values.get(left).equals(values.get(right))) {
//                 return false;
//             }
//             left++;
//             right--;
//         }

//         return true;
//     }
// }

// Floyd's Tortoise and Hare (Cycle Detection)
class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        // Step 1: Find the middle of the linked list
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Step 2: Reverse the second half of the linked list
        ListNode prev = null;
        ListNode current = slow;
        while (current != null) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        // Step 3: Compare the first half and the reversed second half
        ListNode left = head;
        ListNode right = prev;
        while (right != null) {
            if (left.val != right.val) {
                return false;
            }
            left = left.next;
            right = right.next;
        }

        return true;
    }
}