package MedianOfTwoSortedArrays;

public class Driver {
    public static void main(String[] args) {
        Solution test=new Solution();
        int[] l1={1,2};
        int[] l2={3,4};
        
        int[] output=test.merge(l1, l2);
        for(int i=0;i<output.length;i++){
            System.out.println(output[i]);
        }
        /* 
        double result=test.findMedianSortedArrays(l1, l2);
        System.out.println(result);
        */
    }
}
