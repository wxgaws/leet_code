package leetcode;

class LCP19 {
    public int minimumOperations(String leaves) {
        int N = leaves.length();
        int[] r = new int[N];//[0,i]红叶数量
        int[] f = new int[N];//f=i-2r[i]
        int[] minfi = new int[N];//[0,i]中f最小值
        int res = Integer.MAX_VALUE;//res=f[i]-f[j]-r[n-1]最小值

        if (N < 3) return 0;

        //i=0
        if (leaves.charAt(0) == 'r') {
            r[0] = 1;
        } else {
            r[0] = 0;
        }
        f[0] = 0 - 2 * r[0];
        minfi[0] = f[0];
        // System.out.printf("i=%d,r[i]=%d,f[i]=%d,minfi[i]=%d,res=%d\n",0,r[0],f[0],minfi[0],res);

        //i>0
        for (int i = 1; i < N; i++) {
            if (leaves.charAt(i) == 'r') {
                r[i] = r[i - 1] + 1;
            } else {
                r[i] = r[i - 1];
            }
            f[i] = i - 2 * r[i];
            if (f[i] < minfi[i - 1]) {
                minfi[i] = f[i];
            } else {
                minfi[i] = minfi[i - 1];
            }

            if (i < N - 1) {
                res = (minfi[i - 1] - f[i] < res) ? (minfi[i - 1] - f[i]) : res;
            }


        }

        res = res + N - r[N - 1];
        return res;
    }
}
