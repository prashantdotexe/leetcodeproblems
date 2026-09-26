class Solution {
    public boolean search(int[] nums, int target) {
        int i=0;
        int j=nums.length-1;
        while(i<=j){
            int mid = i+ (j-i)/2;
            if(nums[mid]==target){
                return true;
            }
            else if(nums[mid]==nums[i]&&nums[mid]==nums[j]){
                i++;
                j--;
            }
            else if(nums[i]<=nums[mid]){
                if(nums[i]<=target&&target<=nums[mid]){
                    if(nums[i]==target||nums[mid]==target)return true;
                    j=mid-1;
                }
                else {
                    i=mid+1;
                }
            }
            else if(nums[j]>=nums[mid]){
                if(nums[mid]<=target&&target<=nums[j]){
                    if(nums[mid]==target||nums[j]==target)return true;
                    i=mid+1;
                }
                else {
                    j=mid-1;
                }

            }
        }
        return false;
    }
}