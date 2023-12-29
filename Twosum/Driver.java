package Twosum;
public class Driver {
    public static void main(String[] args) {
        int[]nums=new int[]{1,6142,8192,10239};
        int target=18431;
        Solution a1=new Solution();
        int[]result=a1.twoSum(nums, target);
        System.out.println("["+result[0]+","+result[1]+"]");
    }
}
