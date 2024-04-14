package StringToIntegerAtoi;

public class Driver{
    public static void main(String[] args) {
        Solution text=new Solution();
        String str1="-498 is my answer";
        String textTrim="- 992wjei";
        System.out.println(textTrim.trim());
        int result=text.myAtoi(str1);
        System.out.println(result);
    }
}