class Solution {
    public int findMaxLength(int[] nums) {
        int cntOne = 0, cntZero = 0;
        int ans = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                cntZero++;
            } else {
                cntOne++;
            }
            
            int diff = cntZero - cntOne;

            if (diff == 0) {
                ans = Math.max(ans, i + 1);
            }

            if (map.containsKey(diff)) {
                int idx = map.get(diff);
                int len = i - idx;
                ans = Math.max(len, ans);
            } else {
                map.put(diff, i);
            }
        }
        return ans;
    }
}
