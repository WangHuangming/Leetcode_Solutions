import java.util.Arrays;

import javax.swing.tree.TreeNode;

public class Solution {
    // public TreeNode constructMaximumBinaryTree(int[] nums) {
    //     if(nums.length == 0) return null;

    //     int max=-1;
    //     int maxIndex = -1;
    //     for(int i = 0; i < nums.length; i++){
    //         if(nums[i] > max){
    //             max = nums[i];
    //             maxIndex = i;
    //         }
    //     }
    //     TreeNode root = new TreeNode(max);
        
    //     if(maxIndex == 0){
    //         root.left = null;
    //     }else{
    //         int[] left = Arrays.copyOfRange(nums, 0, maxIndex);
    //         root.left = constructMaximumBinaryTree(left);
    //     }

    //     if(maxIndex == nums.length - 1){
    //         root.right = null;
    //     } else{
    //         int[] right = Arrays.copyOfRange(nums, maxIndex + 1, nums.length);
    //         root.right = constructMaximumBinaryTree(right);
    //     }
        
    //     return root;
    // }
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return constructMaximumBinaryTree(nums,0,nums.length -1);
    }

    public TreeNode constructMaximumBinaryTree(int[] nums, int low, int high) {
        if (low > high) { 
            return null;
        }

    
        int curmax = low;
        for (int i = low + 1; i <= high; i++) {
            if (nums[i] > nums[curmax]) {
                curmax = i;
            }
        }
        TreeNode root = new TreeNode(nums[curmax]);
        root.left = constructMaximumBinaryTree(nums, low, curmax - 1);
        root.right = constructMaximumBinaryTree(nums, curmax + 1, high);

        return root;
    }
}
