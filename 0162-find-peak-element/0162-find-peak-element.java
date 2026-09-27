class Solution {
    public int findPeakElement(int[] nums) {
        int i=0;
        int j=nums.length-1;
        while(i<=j){
            int mid = i+(j-i)/2;
            if(mid+1<nums.length&&nums[mid]<nums[mid+1]){
                i=mid+1;
            }
            else if(mid-1>=0&&nums[mid]<nums[mid-1]){
                j=mid-1;
            }
            else {
                return mid;
            }
        }
        return i;
    }
}