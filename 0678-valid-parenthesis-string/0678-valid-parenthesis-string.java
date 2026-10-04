class Solution {
    public boolean checkValidString(String s) {
        int n= s.length();
        int [][] memo= new int [n+1][n+1];
        for(int i=0;i<=n;i++)Arrays.fill(memo[i],-1);

        return solve(0,0,memo,s);
    }
    boolean solve(int id, int open , int [][] memo, String s){
        if(id>=s.length())return open==0;
        if(memo[id][open]!=-1)return memo[id][open]==1?true:false;

        boolean valid =false;
        if(s.charAt(id)=='('){
           valid = valid | solve(id+1,open+1,memo,s);
        }
        else if(s.charAt(id)==')'&&open>0){
              valid = valid | solve(id+1,open-1,memo,s);
        }
        else if(s.charAt(id)=='*'){
            valid = valid | solve(id+1,open+1,memo,s);  // (
            valid=  valid | solve(id+1,open, memo, s);  // ""
            if(open>0) valid = valid | solve (id+1,open-1, memo , s);
        }
        memo [id][open]=valid?1:0;
        return valid;
    }
}