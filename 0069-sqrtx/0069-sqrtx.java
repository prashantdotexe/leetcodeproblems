class Solution {
    public int mySqrt(int x) {
        if(x<=1)return x;
        long i=1;
        long j=x/2;
        long ans=1;
        while(i<=j){
            long mid = i+(j-i)/2;
            if(mid*mid<=x){
                i=mid+1;
                ans=mid;
            }
            else {
                j=mid-1;
            }
        }
        return (int)ans;
    }
}