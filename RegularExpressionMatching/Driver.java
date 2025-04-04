package RegularExpressionMatching;

public class Driver {
    public static void main(String[] args) {
        Solution test=new Solution();
        String s1="mississipp";
        String p1="mis*is*ip*";
        if(test.isMatch(s1, p1)){
            System.out.println("true");

        }
        else {
            System.out.println("false");
        }
    }
}
