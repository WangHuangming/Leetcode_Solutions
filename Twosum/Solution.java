package Twosum;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {

    public int[] twoSum(int[] nums, int target) {
        //stage 1: Dual-Pivot Quicksort
        int[] copy=nums.clone();
        Arrays.sort(copy);

        //stage 2: seperate to Gourp A and Gourp B
        //we can use the though of binary search to split them
        ArrayList<Integer> SetA=new ArrayList(); 
        ArrayList<Integer> SetB=new ArrayList();
        double newTarget=target/1.0;

        if(target%2==0){
            for (int i=0;i<copy.length;i++){
                //Group A contains all nums < target/2
                if(copy[i]<target/2){
                    SetA.add(copy[i]);
                }
                //Group B contains all nums > target/2
                else if(copy[i]>target/2){
                    SetB.add(copy[i]);
                }
                //special case that for num=target/2
                else{
                    List<Integer> SetC=Arrays.stream(nums).boxed().collect(Collectors.toList());
                    int result1=SetC.indexOf(target/2);
                    SetC.remove(result1);
                    if(SetC.contains(target/2)){
                        int[]output=new int[2];

                        nums[result1]=target-1;
                        
                        List<Integer> SetD=Arrays.stream(nums).boxed().collect(Collectors.toList());
                        
                        int result2=SetD.indexOf(target/2);

                        
                        //make the first occur position at the first of output
                        if(result1>result2){
                            output[0]=result2;
                            output[1]=result1;
                        }
                        else{
                            output[1]=result2;
                            output[0]=result1;
                        }
                        return output;
                    }
                }
            }
        }
        else{
            for (int i=0;i<copy.length;i++){
                if(copy[i]<newTarget/2){
                    SetA.add(copy[i]);
                }
                else{
                    SetB.add(copy[i]);
                }
            }
        }
        
        //stage 3: find the smaller set. num2=target-num1, we need to search num2 in large set for each number in smaller set(which is num1)
        int result=findTruePair(SetA, SetB, target);

        //stage 4: return the location of pair
        if(result==-1){
            System.out.println("Cannot find the solution");
            return null;
        }
        else{
            int[]output=new int[2];
            List<Integer> SetC=Arrays.stream(nums).boxed().collect(Collectors.toList());
            
            int result1=SetC.indexOf(result);
            int result2=SetC.indexOf(target-result);

            if(result1>result2){
                output[0]=result2;
                output[1]=result1;
            }
            else{
                output[1]=result2;
                output[0]=result1;
            }
            return output;
        }
    }
    
    public int findTruePair(ArrayList<Integer> SetA,ArrayList<Integer> SetB,int target){
        
        if(SetA.size()<SetB.size()){
            
            for(int i=0;i<SetA.size();i++){
                int finalTarget=target-SetA.get(i);
                if(SetB.contains(finalTarget)){
                    return finalTarget;
                }
            }
        }
        else{
            
            for(int i=0;i<SetB.size();i++){
                int finalTarget=target-SetB.get(i);
                if(SetA.contains(finalTarget)){
                    return finalTarget;
                    
                }
            }
        }
        return -1;
    }
}
