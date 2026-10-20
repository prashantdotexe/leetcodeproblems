class Solution {
    public int sortableIntegers(int[] nums) {
        int n= nums.length;
        int result=0;

        for(int k=1;k<=n;k++){
            if(n%k!=0)continue;

            boolean valid= true;

            int prev=Integer.MIN_VALUE;

            for(int i=0;i<n;i+=k){
                int j=i+k-1;

                int min=min(nums,i,j);
                int max=max(nums,i,j);

                if(prev>min|| !isRotatable(nums,i,j)){
                    valid=false;
                    break;
                }
                prev=max;
            }
            if(valid)result+=k;
        }
        return result;
    }
    int min(int [] nums , int i , int j){
        int  min=nums[i];
        for(int x=i+1;x<=j;x++)min=Math.min(min,nums[x]);
        return min;
    }
    int max(int [] nums , int i , int j){
        int  max=nums[i];
        for(int x=i+1;x<=j;x++)max=Math.max(max,nums[x]);
        return max;
    }
    boolean isRotatable(int [] nums , int i , int j){
        int drops=0;
        for(int x=i;x<j;x++){
            if(nums[x]>nums[x+1])drops++;
        }
        if(nums[j]>nums[i])drops++;
        
        return drops<=1;
    }
}