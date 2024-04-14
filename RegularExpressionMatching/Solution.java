package RegularExpressionMatching;

public class Solution {
    public boolean isMatch(String s, String p) {
        if(s.equals(p)){
            return true;
        }
        char a1='.';
        char a2='*';
        if(p.charAt(0)==a2){
            return false;
        }
        
        int i=0;
        int j=0;
        while(i<s.length() &&j<p.length()){
            if(s.charAt(i)!=p.charAt(j) && p.charAt(j)!=a1 && p.charAt(j)!=a2){
                return false;
            }
            else if(p.charAt(j)==a2){
                if(s.charAt(i)==p.charAt(j-1)||p.charAt(j-1)==a1){
                    j--;
                }
                else{
                    i--;
                }
            }
            i++;
            j++;
        }
        if(i<s.length()&& j>=p.length()){
            return false;
        }
        return true;
    }
}