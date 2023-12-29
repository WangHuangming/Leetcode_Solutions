package LongestSubStringNoRepeating;

import java.util.ArrayList;

public class Solution {

    public int lengthOfLongestSubstring(String s){
        //create a arraylist that stores the longest substring
        ArrayList<Character> subString=new ArrayList<Character>();
        
        //create a length to store the curr length and max length
        int currLength=0;
        int maxLength=0;

        for(int i=0;i<s.length();i++){
            Character newCharacter=s.charAt(i);
            if(subString.contains(newCharacter)){
                int position=subString.indexOf(newCharacter);
                for(int k=position;k>=0;k--){
                    subString.remove(k);
                    currLength--;
                }
            }
            subString.add(newCharacter);
            currLength++;
            //upload maxlength if needed
            if(currLength>maxLength){
                maxLength=currLength;
            }
        }
        return maxLength;
    }
}
