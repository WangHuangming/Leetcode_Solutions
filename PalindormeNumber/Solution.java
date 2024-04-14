package PalindormeNumber;

public class Solution {
    
    public boolean isPalindrome(int x) {
    
        if(x<0){
            return false;
        }

        int n=x;
        long reversed=0;
        while(x!=0){
            reversed=reversed*10+x%10;;
            x/=10;
        }
        return (reversed==n)? true:false;
       /*    
        if(x<0){
           return false;
        }
       ArrayList<Integer> list=new ArrayList<Integer>();
       while(x!=0){
            list.add(x%10);
            x=x/10;
       }
       for(int i=0;i<list.size();i++){
            if(list.get(i)!=list.get(list.size()-1-i)){
                return false;
            }
       }
       return true;
    */
    }
    

}