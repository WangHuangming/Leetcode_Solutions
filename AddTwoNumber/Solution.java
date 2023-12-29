package AddTwoNumber;

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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //determine which list is longer
        int flag=1;     //default is l1 longer
        if(countDigit(l1)-countDigit(l2)<=0){
            flag=2;     //l2 longer
        }

        //create an empty ListNode for the output
        ListNode output=new ListNode();

        //set up carry bit for calculation(addition)
        int carryBit=0;

        //set up accumulator
        int accumulator=0;

        //set up pointer to l1,l2,output to access them
        ListNode currL1=l1;
        ListNode currL2=l2;
        ListNode currResult=output;

        //calculate for the first digit
        accumulator=currL1.val+currL2.val+carryBit;
        if(accumulator>9){
            carryBit=1;
            accumulator=accumulator-10;
        }
        currResult.val=accumulator;

        
        //do addition when both list still have digit
        while(currL1.next!=null&&currL2.next!=null){
            //go to next digit
            currL1=currL1.next;
            currL2=currL2.next;

            //do addition
            accumulator=currL1.val+currL2.val+carryBit;
            carryBit=0;     //reset carry bit after use
            if(accumulator>9){
                carryBit=1;
                accumulator=accumulator-10;
            }
            addNode(currResult, accumulator);
            currResult=currResult.next;
        }
        //do for rest
        switch (flag) {
            case 1:
                while(currL1.next!=null){
                    //go next
                    currL1=currL1.next;

                    //do addition
                    accumulator=currL1.val+carryBit;
                    carryBit=0;     //reset carry bit after use
                    if(accumulator>9){
                        carryBit=1;
                        accumulator=accumulator-10;
                    }
                    addNode(currResult, accumulator);
                    currResult=currResult.next;
                }
                break;
            case 2:
                while(currL2.next!=null){
                    //go next
                    currL2=currL2.next;

                    //do addition
                    accumulator=currL2.val+carryBit;
                    carryBit=0;     //reset carry bit after use
                    if(accumulator>9){
                        carryBit=1;
                        accumulator=accumulator-10;
                    }
                    addNode(currResult, accumulator);
                    currResult=currResult.next;
                }
                break;
            default:
                break;
        }
        if(carryBit==1){
            addNode(currResult, 1);
        }
        return output;
    }

    public int countDigit(ListNode list){
        if(list.next==null){
            return 1;
        }
        else{
            return countDigit(list.next)+1;
        }
    }

    public void addNode(ListNode list, int value){
        ListNode a1=new ListNode(value);
        list.next=a1;
    }
}