import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> countOfPeaks(int[] nums, int[][] queries) {
        // prepare a List<Integer> to store the result and a peaks array
        List<Integer> result = new ArrayList<>();
        int[] peaks = new int[nums.length];
        for(int index=1; index < nums.length - 1; index++) {
            peaks[index]= isPeak(nums,index) ? 1 : 0;
        }
        // printIntArray(nums);
        // printIntArray(peaks);
        // read queries
        for(int[] query: queries){
            switch (query[0]) {
                case 1 -> {
                    // count peaks in the range
                    int count = 0;
                    for (int i = query[1]+1; i < query[2]; i++) {
                        if (peaks[i] == 1) {
                            count++;
                        }
                    }
                    result.add(count);
                }
                case 2 -> {
                    update(nums, peaks, query[1], query[2]);
                    printIntArray(nums);
                    printIntArray(peaks);
                }
                default -> System.err.println("Invalid query type: " + query[0]);
            }
        }
        return result;
    }

    public boolean isPeak(int[] nums, int index) {
       if(index == 0 || index == nums.length - 1) {
            return false;
        }
        return nums[index] > nums[index - 1] && nums[index] > nums[index + 1];
    }

    public void update(int[] nums, int[] peaks, int index, int newValue) {
        int oldValue = nums[index];
        nums[index] = newValue;

        System.out.println("Updating peak at index: " + index);
        System.out.println("oldValue: " + oldValue);
        System.out.println("newValue: " + newValue);

        if(oldValue == newValue) {
            System.out.println("No update needed");
            return;
        }
        if(index == 0) {
            peaks[index+1] = isPeak(nums, index+1) ? 1 : 0;
            System.out.println("Updated peaks: " + (index+1) + ":"+ peaks[index+1]);
            return;
        }
        if(index == nums.length - 1) {
            peaks[index-1] = isPeak(nums, index-1) ? 1 : 0;
            System.out.println("Updated peaks: " + (index-1) + ":"+ peaks[index-1]);
            return;
        }
        if(peaks[index]==1 && newValue < oldValue) {
            peaks[index] = isPeak(nums, index) ? 1 : 0;
            peaks[index-1] = isPeak(nums, index-1) ? 1 : 0;
            peaks[index+1] = isPeak(nums, index+1) ? 1 : 0;
            System.out.println("No1");
            System.out.println("Updated peaks: " + peaks[index] + " " + peaks[index-1] + " " + peaks[index+1]);
        }
        else if(peaks[index]==0 && newValue > oldValue) {
            peaks[index] = isPeak(nums, index) ? 1 : 0;
            peaks[index-1] = isPeak(nums, index-1) ? 1 : 0;
            peaks[index+1] = isPeak(nums, index+1) ? 1 : 0;
            System.out.println("No2");
            System.out.println("Updated peaks: " + peaks[index] + " " + peaks[index-1] + " " + peaks[index+1]);
        }
        else if(peaks[index]==0 && newValue < oldValue) {
            peaks[index-1] = isPeak(nums, index-1) ? 1 : 0;
            peaks[index+1] = isPeak(nums, index+1) ? 1 : 0;
            System.out.println("No3");
            System.out.println("Updated peaks: " + peaks[index] + " " + peaks[index-1] + " " + peaks[index+1]);
        }
        else{
            System.out.println("Didn't update peaks");
        }
    }

    public void printIntArray(int[] peaks) {
        for (int i = 0; i < peaks.length; i++) {
            System.out.print(peaks[i] + " ");
        }
        System.out.println();
    }
}