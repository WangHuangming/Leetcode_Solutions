package LongestPalindromicSubString;

public class Solution {
    public String longestPalindrome(String s){
        String finalResult="";      //the longest Palindrome
        int Maxlength=0;        //the length of this Palindrome
        if(s.length()==1){
            return s;
        }
        //for each a char, find another same char(this is the basic of Palindrome)
        //this part can be improve
        for(int i=0;i<s.length();i++){
            for(int k=s.length()-1;k>=i;k--){
                if(s.charAt(i)==s.charAt(k)){
                    String temp=s.substring(i, k+1);
                    if(is_Palincromic(temp) && temp.length()>Maxlength){
                        finalResult=temp;
                        Maxlength=temp.length();
                    }
                }
            }
        }
        return finalResult;
    }
    //determine whether is a palindrome or not
    public boolean is_Palincromic(String s){
        for(int i=0; i<s.length()/2;i++){
            if(s.charAt(i)!=s.charAt(s.length()-1-i)){
                return false;
            }
        }
        return true;
    }
}
