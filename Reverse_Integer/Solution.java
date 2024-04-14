package Reverse_Integer;

import java.util.ArrayList;

public class Solution {
    public int reverse(int x) {
        //store the nums on each digits to the arraylist
        ArrayList<Integer> digits=new ArrayList<Integer>();
        while(x/10!=0){
            digits.add(0,(x%10));
            x=x/10;
        }
        digits.add(0,x);
        
        //check whether the reserve value exceed the range
        if(digits.size()==10){
            int valueOfFirstFive=0;
            int valueOfLastFive=0;
            for(int i=5;i<10;i++){
                valueOfLastFive=valueOfLastFive+digits.get(i)*(int)Math.pow(10, i-5);
            }
            for(int i=0;i<5;i++){
                valueOfFirstFive=valueOfFirstFive+digits.get(i)*(int)Math.pow(10, i);
            }
            if(valueOfLastFive>21474 || valueOfLastFive<-21474){
                return 0;
            }
            else if(valueOfLastFive==21474 && valueOfFirstFive>83647){
                return 0;
            }
            else if(valueOfLastFive==-21474 && valueOfFirstFive<-83647){
                return 0;
            }
        }

        //reserve the result
        int reserved=0;
        for(int i=0;i<digits.size();i++){
            reserved=reserved+digits.get(i)*(int)Math.pow(10, i);
        }
        return reserved;
    }
}