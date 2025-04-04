import java.util.Arrays;

public class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if(nums.length == 0) return null;

        int max=-1;
        int maxIndex = -1;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > max){
                max = nums[i];
                maxIndex = i;
            }
        }
        TreeNode root = new TreeNode();
        root.val = max;
        
        if(maxIndex == 0){
            root.left = null;
        }else{
            int[] left = Arrays.copyOfRange(nums, 0, maxIndex);
            root.left = constructMaximumBinaryTree(left);
        }

        if(maxIndex == nums.length - 1){
            root.right = null;
        } else{
            int[] right = Arrays.copyOfRange(nums, maxIndex + 1, nums.length);
            root.right = constructMaximumBinaryTree(right);
        }
        
        return root;
    }
}
