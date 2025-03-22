package LinkedListCycle;

import java.util.Set;

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

 //first trail: using hashset to store the nodes
 //time complexity: O(n)
 //space complexity: O(n)
// class Solution {
//     public boolean hasCycle(ListNode head) {
//         Set<ListNode> nodes = new HashSet<>();
//         ListNode curr = head;
//         while(curr!=null){
//             if(nodes.contains(curr)){
//                 return true;
//             }
//             nodes.add(curr);
//             curr=curr.next;
//         }
//         return false;
//     }
// }

//second trail: using two pointers
//time complexity: O(n)
//space complexity: O(1)
class Solution {
    public boolean hasCycle(ListNode head) {
        if(head==null){
            return false;
        }
        ListNode slow=head;
        ListNode fast=head.next;
        while(slow!=fast){
            if(fast==null||fast.next==null){
                return false;
            }
            slow=slow.next;
            fast=fast.next.next;
        }
        return true;
    }
}