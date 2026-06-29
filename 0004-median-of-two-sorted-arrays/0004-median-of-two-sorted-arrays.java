class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        // Binary Search hamesha chhoti array par lagayenge
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int x = nums1.length;
        int y = nums2.length;

        int low = 0;
        int high = x;

        while (low <= high) {

            // nums1 ka partition
            int partitionX = (low + high) / 2;

            // nums2 ka partition
            int partitionY = (x + y + 1) / 2 - partitionX;

            // Left side ke last elements
            int maxLeftX = (partitionX == 0)
                    ? Integer.MIN_VALUE
                    : nums1[partitionX - 1];

            int maxLeftY = (partitionY == 0)
                    ? Integer.MIN_VALUE
                    : nums2[partitionY - 1];

            // Right side ke first elements
            int minRightX = (partitionX == x)
                    ? Integer.MAX_VALUE
                    : nums1[partitionX];

            int minRightY = (partitionY == y)
                    ? Integer.MAX_VALUE
                    : nums2[partitionY];

            // Correct Partition
            if (maxLeftX <= minRightY && maxLeftY <= minRightX) {

                // Total elements even
                if ((x + y) % 2 == 0) {

                    return (Math.max(maxLeftX, maxLeftY)
                            + Math.min(minRightX, minRightY)) / 2.0;
                }

                // Total elements odd
                else {
                    return Math.max(maxLeftX, maxLeftY);
                }
            }

            // Partition bahut right hai
            else if (maxLeftX > minRightY) {
                high = partitionX - 1;
            }

            // Partition bahut left hai
            else {
                low = partitionX + 1;
            }
        }

        return 0.0;
    }
}