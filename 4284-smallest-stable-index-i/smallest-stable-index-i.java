class Solution {
    public int firstStableIndex(int[] nums, int k) {
        //Nivas
        int a = nums.length;
        int max[] = new int[a];
        int min[] = new int[a];
        int dif[] = new int[a];

        for (int i = 0; i < a; i ++) {
            int currmax = nums[0];
            for (int j = 0; j <=i; j ++) {
                if (nums[j] > currmax) {
                    currmax = nums[j];
                }
            }
            max[i] = currmax;
        }
        for (int i = nums.length-1; i >= 0; i --) {
            int currmin = nums[i];
            for (int j = i; j < a; j ++) {
                if (nums[j] < currmin) {
                    currmin = nums[j];
                }
            }
            min[i] = currmin;
        }
        for ( int i = 0; i < max.length; i ++) {
            dif[i] = max[i] - min[i];
            if (dif[i] <= k) {
                return i;
            }
        }
        return -1;
    }
}