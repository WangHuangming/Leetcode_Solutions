package Zigzag_Conversion;

public class Solution {
    public String convert(String s, int numRows){
        if(numRows==1){
            return s;
        }
        int a1=numRows*2-2;     //nums of char for each A group
        int a2=s.length()/a1;   //nums of group
        int a3=s.length()%a1;   //remain characters
        int a4=numRows-1;       //column of each group
        int column=a4*a2;       //the nums of column we need
        if(a3!=0){
            column++;           //we need one more column for those remain characters
            if(a3>numRows){
                column=column+(a3-numRows);     //need one extra column for each remain character if greater than numRows
            }
        }
        //make a char array
        char[] output=new char[column*numRows];

        //put the characters in to output
        int currCol=0;
        int currRow=0;
        int currCharater=0;
        int flag=0;     //0 means go down ward, 1 means go up ward
        
        //fill in the chracter to the char[]
        while(currCharater<s.length()){
            switch (flag) {
                case 0:
                    while (currRow<numRows && currCharater<s.length()) {
                        output[currCol+currRow*column]=s.charAt(currCharater);
                        currCharater++;
                        currRow++;
                    }
                    flag=1;
                    currCol++;
                    currRow=currRow-2;
                    break;
                case 1:
                    while (currRow>0 && currCharater<s.length()) {
                        output[currCol+currRow*column]=s.charAt(currCharater);
                        currCharater++;
                        currCol++;
                        currRow--;
                    }
                    flag=0;
                default:
                    break;
            }
        }
        //make the char[] to a String
        StringBuilder builder=new StringBuilder(column*numRows);
        for(int z=0;z<output.length;z++){
            if(output[z]!='\u0000')
            builder.append(output[z]);
        }
        return builder.toString();
    }
}
