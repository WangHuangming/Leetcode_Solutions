package AddTwoNumber;

public class Driver {
    public static void main(String[] args) {
        /* 
        ListNode k6=new ListNode(9);
        ListNode k5=new ListNode(9,k6);
        ListNode k4=new ListNode(9,k5);
        ListNode k3=new ListNode(9,k4);
        ListNode k2=new ListNode(9,k3);
        ListNode k1=new ListNode(9,k2);
        */
        ListNode l1=new ListNode(9);

        /* */
        ListNode n9=new ListNode(9);
        ListNode n8=new ListNode(9,n9);
        ListNode n7=new ListNode(9,n8);
        ListNode n6=new ListNode(9,n7);
        ListNode n5=new ListNode(9,n6);
        ListNode n4=new ListNode(9,n5);
        ListNode n3=new ListNode(9,n4);
        ListNode n2=new ListNode(9,n3);
        ListNode n1=new ListNode(9,n2);
        ListNode l2=new ListNode(1,n1);

        Solution a1=new Solution();
        
        ListNode output=a1.addTwoNumbers(l1, l2);
        ListNode target=output;
        
        
        System.out.print(target.val+" ");
        while(target.next!=null){
            System.out.print(target.next.val+" ");
            target=target.next;
        }
    }
}
