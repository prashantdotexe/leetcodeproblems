class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        int [] pre = new int [s.length()+1];
        for(int i=1;i<=s.length();i++){
            pre[i]= pre[i-1]+Math.abs(s.charAt(i-1)-t.charAt(i-1));
        }
        int ans=0;
        int i=0;
        int j=s.length();
        while(i<=j){
            int mid=i+(j-i)/2;
            if(isPossible(maxCost,pre,mid)){
                ans=mid;
                i=mid+1;
            }
            else j=mid-1;
        }
        return ans;
    }
    boolean isPossible(int maxCost, int [] pre, int mid){
        int i=0;
        int j=mid;
        while(j<pre.length){
            if(pre[j]-pre[i]<=maxCost)return true;
            i++;
            j++;
        }
        return false;
    }
}