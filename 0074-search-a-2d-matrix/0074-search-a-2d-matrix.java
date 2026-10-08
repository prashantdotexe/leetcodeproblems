class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m=matrix.length;
        int n=matrix[0].length;
        int low=0;
        int high = m-1;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(target==matrix[mid][0]){
                return true;
            }
            else  if(target<matrix[mid][0]){
               if(mid>0&&matrix[mid-1][0]<=target){
                return searchInRow(matrix,mid-1,target);
               }
               else 
               high=mid-1;
            }
            else if(target>matrix[mid][0]) {
                if(matrix[mid][n-1]>=target){
                    return searchInRow(matrix,mid,target);
                }
                else {
                    low=mid+1;
                }
            }
        }
        return false;
    }
    boolean searchInRow(int [][] matrix, int row , int target){
        int low=0;
        int high=matrix[0].length-1;
        while(low<=high){
           // System.out.println("reached herem"+low +" "+high);
            int mid=low+(high-low)/2;
            if(matrix[row][mid]==target)return true;
            else if(target>matrix[row][mid])low=mid+1;
            else high=mid-1;
        }
        return false;
    }
}