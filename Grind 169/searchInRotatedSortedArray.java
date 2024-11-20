class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int left = 0, right = n - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target)
                return mid;
            // Check if second half of the array is sorted
            if (nums[mid] < nums[right]) {
                // Check if target is in range of second half
                if (target > nums[mid] && target <= nums[right]) {
                    // Apply BS in second half
                    left = mid + 1;
                } else {
                    // Apply BS in first half
                    right = mid - 1;
                }
            } else {
                // Check if target is in range of first half
                if (target >= nums[left] && target < nums[mid]) {
                    // Apply BS in first half
                    right = mid - 1;
                } else {
                    // Apply BS in second half
                    left = mid + 1;
                }
            }
        }
        // Return -1 if target is not found in array
        return -1;
    }
}