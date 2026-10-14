class Solution {
    public String maxSumOfSquares(int num, int sum) {
        if(9*num<sum)return "";
        StringBuilder sb= new StringBuilder();
        int nines=sum/9;
        for(int i=0;i<nines;i++)sb.append('9');
        if(sum%9>0)sb.append((char)('0'+(sum%9)));

        int zeros=num-sb.length();
        while(zeros-->0)sb.append('0');
        return sb.toString();
    }
}