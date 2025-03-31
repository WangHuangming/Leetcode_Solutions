class Solution {
    public int myAtoi(String s) {
        // Check for leading whitespace
        s = s.trim();
        if (s.isEmpty()) {
            return 0;
        }
        boolean isPositive = true;
        int i=0;
        long result = 0;
        
        // Check for sign
        if(s.charAt(i)=='-'){
            isPositive = false;
            i++;
        }else if(s.charAt(i)=='+'){
            i++;
        }

        // remove leading zeros
        while(i < s.length() && s.charAt(i) == '0'){
            i++;
        }
        // Convert string to integer
        while(i < s.length() && Character.isDigit(s.charAt(i))) {
            result = result * 10 + (s.charAt(i) - '0');
            i++;
            if (result-1 > Integer.MAX_VALUE) {
                break; // Break if result exceeds Integer.MAX_VALUE
            }
        }
        
        // Apply sign
        result = isPositive ? result : -result;

        // Check for overflow and underflow
        return (int)Math.max((long)Integer.MIN_VALUE, Math.min(result, (long)Integer.MAX_VALUE));
    }
}