class Solution {
    public int search(int[] nums, int target) {
        int i=0;
        int j=nums.length-1;
        while(i<=j){
            int mid= i+(j-i)/2;
            if(nums[mid]==target)return mid;

            else if(nums[i]<=nums[mid]){
                if(nums[i]<=target&&target<nums[mid]){
                    j=mid-1;
                }
                else{
                    i=mid+1;;
                }
            }
            else {
                if(nums[mid]<target&&target<=nums[j]){
                    i=mid+1;
                }
                else {
                    j=mid-1;
                }

            }
        }
        return -1;
    }
}
// target =0;


// [4,5,6,7,0,1,2]
//  0 1 2 3 4 5 6 