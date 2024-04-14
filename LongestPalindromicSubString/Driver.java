package LongestPalindromicSubString;

public class Driver {
    public static void main(String[] args) {
        String targetString="ac";
        String s2="1a1";
        Solution test=new Solution();
        /* 
        if(test.is_Palincromic(s2)){
            System.out.println("true");
        }
        else{
            System.out.println("false");
        }
        */

        String output=test.longestPalindrome(targetString);
        System.out.println(output);
    }
}
