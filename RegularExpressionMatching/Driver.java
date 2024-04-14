package RegularExpressionMatching;

public class Driver {
    public static void main(String[] args) {
        Solution test=new Solution();
        String s1="aaba";
        String pattern="a.*b";
        if(test.isMatch(s1, pattern)){
            System.out.println("true");

        }
        else {
            System.out.println("false");
        }
    }
}
