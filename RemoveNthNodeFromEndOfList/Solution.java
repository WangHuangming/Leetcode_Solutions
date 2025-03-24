package RemoveNthNodeFromEndOfList;

public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int count = 0;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            count++;
        }
        //count total number of nodes
        int total;
        if (fast == null) {
            total = count * 2;

        } else {
            total = count * 2 + 1;
        }
        ListNode prev=null;
        ListNode curr=head;
        ListNode temp=head.next;
        while(total-n!=0){
            prev=curr;
            curr=curr.next;
            temp=temp.next;
            total--;
        }
        if(prev==null){
            return head.next;
        }else{
            prev.next=temp;
        }
        return head;
    }
}
