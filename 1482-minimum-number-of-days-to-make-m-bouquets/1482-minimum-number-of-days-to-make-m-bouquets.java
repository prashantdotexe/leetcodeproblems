class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int max=Integer.MIN_VALUE;
        int min= Integer.MAX_VALUE;

        for(int num:bloomDay){
            min=Math.min(num,min);
            max=Math.max(num,max);
        }

        int lo= min;
        int hi= max;

        int ans=Integer.MAX_VALUE;
        while(lo<=hi){
            int mid = lo+(hi-lo)/2;
            if(isPossible(bloomDay, mid,m ,k)){
                ans=mid;
                hi=mid-1;
            }
            else {
                lo= mid+1;
            }
        }
        return ans==Integer.MAX_VALUE?-1:ans;
    }
    boolean isPossible(int [] bloomDay, int mid , int m , int k){
        int flowerCount=0;
        int bouquetCount=0;
        for(int i=0;i<bloomDay.length;i++){
            if(bloomDay[i]<=mid){
                flowerCount++;
            }
            else {
                flowerCount=0;
            }
            if(flowerCount==k){
                bouquetCount++;
                flowerCount=0;
            }
        }
        return bouquetCount>=m;
    }
}