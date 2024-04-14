package MedianOfTwoSortedArrays;

public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int totalLength=nums1.length+nums2.length;
        int flag=totalLength%2;
        
        int[]merged=merge(nums1, nums2);
        //return the median
        switch (flag) {
            case 0:
                return (merged[totalLength/2]+merged[totalLength/2-1])/2.0;
            default:
                return merged[(totalLength-1)/2];
        }
    }

    public int[] merge(int[] nums1,int[] nums2){
        int i=0;
        int j=0;
        int k=0;
        int[] result=new int[nums1.length+nums2.length];
        
        while(i<nums1.length && j<nums2.length){
            if(nums1[i]<nums2[j]){
                result[k]=nums1[i];
                i++;
            }
            else{
                result[k]=nums2[j];
                j++;
            }
            k++;
        }
        if(j==nums2.length){
            for(int x=i;x<nums1.length;x++){
                result[k]=nums1[x];
                k++;
            }
        }
        if(i==nums1.length){
            for(int x=j;x<nums2.length;x++){
                result[k]=nums2[x];
                k++;
            }
        }
        return result;
    }
}
