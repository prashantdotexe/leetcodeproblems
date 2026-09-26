class Solution {
    public int[] searchRange(int[] nums, int target) {
        if(nums.length==0)return new int []{-1,-1};
        return new int [] {findFirstIndex(nums,target),findLastIndex(nums,target)};
    }

    int findFirstIndex(int [] nums , int target){
        int i=0;
        int j= nums.length-1;
        while(i<j){
            int mid = i + (j-i)/2;
            if(nums[mid]>=target){
                j=mid;
            }
            else {
                i=mid+1;
            }
        }
        return i>=0&&nums[i]==target?i:-1;
    }
    int findLastIndex(int [] nums , int target){
        int i=0;
        int j= nums.length-1;
        while(i<j){
            int mid = i + (j-i+1)/2;
            if(nums[mid]<=target){
                i=mid;
            }
            else {
                j=mid-1;
            }
        }
        return i>=0&&nums[i]==target?i:-1;
    }

}