class Solution {
    public int minimumSize(int[] nums, int maxOperations) {
        long lo=1;
        long hi=0;
        for(int num:nums)hi= Math.max(hi,num);
        
        long ans=hi;

        while(lo<=hi){
            long mid=lo+(hi-lo)/2;
            if(isPossibleToObtainMidPaneltyWithinGivenOperations(mid,nums,maxOperations)){
                ans=mid;
                hi=mid-1;
            }
            else lo=mid+1;
        }
        return (int)ans;
    }
    boolean isPossibleToObtainMidPaneltyWithinGivenOperations(long mid, int [] nums , int maxOperations){
        long currentOperations=0;
        for(int num:nums){
            if(num<=mid)continue;
            if(num%mid==0)currentOperations+=num/mid -1;
            else currentOperations+=num/mid;
        }
        return currentOperations<=maxOperations;
    }
}