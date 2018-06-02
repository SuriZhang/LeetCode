class Solution {
    public int divide(int dividend, int divisor) {
        boolean neg = (dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0);
        long ldvd = Math.abs((long) dividend);
        long ldvs = Math.abs((long) divisor);

        if(ldvd == 0 || ldvd < ldvs) return 0;
        if(ldvd == 0) return Integer.MAX_VALUE;

        long lrst = ldiv(ldvd, ldvs); 

        int rst;
        if(lrst > Integer.MAX_VALUE)
            if(neg) rst = Integer.MIN_VALUE;
            else rst = Integer.MAX_VALUE;
        else
            if(neg) rst = (int) (-1 * lrst);
            else rst = (int) lrst;

        return rst;	
    }

    private long ldiv(long ldvd, long ldvs){
        if(ldvd < ldvs) return 0;
        
        long sum = ldvs;
        long times = 1;
        while(sum+sum < ldvd){
            sum += sum;
            times += times;
        }

        return times + ldiv(ldvd-sum, ldvs);
    }
}
