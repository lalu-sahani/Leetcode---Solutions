class Solution {
    public int findShortestSubArray(int[] nums) {

        HashMap<Integer, Integer> freq = new HashMap<>();
        HashMap<Integer, Integer> first = new HashMap<>();
        HashMap<Integer, Integer> last = new HashMap<>();

        int degree = 0;

        for (int i = 0; i < nums.length; i++) {

            if (!first.containsKey(nums[i])) {
                first.put(nums[i], i);
            }

            last.put(nums[i], i);

            freq.put(nums[i], freq.getOrDefault(nums[i], 0) + 1);

            degree = Math.max(degree, freq.get(nums[i]));
        }

        int ans = nums.length;

        for (int key : freq.keySet()) {
            if (freq.get(key) == degree) {
                ans = Math.min(ans, last.get(key) - first.get(key) + 1);
            }
        }

        return ans;
    }
}