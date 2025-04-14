
import java.util.List;

public class Driver {
        public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = {8,7,10};
        // boolean check = sol.isPeak(nums, 2);
        // System.out.println("Is peak: " + check);
        int[][] queries = {{1,1,1}, {2,2,4},{1,0,1},{2,1,9},{1,0,2}};
        List<Integer> result = sol.countOfPeaks(nums, queries);
        System.out.println(result);
    }
}
