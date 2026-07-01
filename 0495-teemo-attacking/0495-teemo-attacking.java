class Solution {
    public int findPoisonedDuration(int[] timeSeries, int duration) {

        int total = 0;

        for (int i = 0; i < timeSeries.length - 1; i++) {

            int gap = timeSeries[i + 1] - timeSeries[i];

            if (gap >= duration) {
                total += duration;
            } else {
                total += gap;
            }
        }

        // Add poison time of the last attack
        total += duration;

        return total;
    }
}