package RegularExpressionMatching;

public class Solution {
    public boolean isMatch(String s, String p) {
        int indexS=s.length()-1;
        int indexP=p.length()-1;
        return isMatch(s, p, indexS, indexP);
    }

    public boolean isMatch(String s, String p, int indexS, int indexP) {
        // base cases
        if (indexS == -1 && indexP ==-1) {
            return true;
        }
        if (indexS != -1 && indexP ==-1) {
            return false;
        }
        if( indexS == -1 && indexP !=-1) {
            if (p.charAt(indexP) == '*') {
                return isMatch(s, p, indexS, indexP - 2);
            } else {
                return false;
            }
        }

        if(s.charAt(indexS) == p.charAt(indexP) || p.charAt(indexP) == '.'){
            return isMatch(s, p, indexS - 1, indexP - 1);
        } else if(p.charAt(indexP) == '*'){
            if(s.charAt(indexS) == p.charAt(indexP - 1) || p.charAt(indexP - 1) == '.'){
                return isMatch(s, p, indexS, indexP - 2) || isMatch(s, p, indexS - 1, indexP);
            }
            return isMatch(s, p, indexS, indexP - 2);
        }else{
            return false;
        }
    }
}