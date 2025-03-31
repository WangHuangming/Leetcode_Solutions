class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result=new ArrayList<Integer>();
        if(root==null){
            return result;
        }
        List<Integer> left=inorderTraversal(root.left);
        if(!left.isEmpty()){
            result.addAll(left);
        }
        
        result.add(root.val);
        
        List<Integer> right=inorderTraversal(root.right);
        if(!right.isEmpty()){
            result.addAll(right);
        }
        return result;
    }
}