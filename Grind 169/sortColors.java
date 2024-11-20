class Solution {
    public void sortColors(int[] nums) {
        int n = nums.length;
        if (n <= 1)
            return;
        int low = 0, mid = 0, high = n - 1;
        while (mid <= high) {
            switch (nums[mid]) {
                case 0:
                    if (nums[low] != nums[mid]) {
                        nums[low] = nums[low] ^ nums[mid];
                        nums[mid] = nums[low] ^ nums[mid];
                        nums[low] = nums[low] ^ nums[mid];
                    }
                    low++;
                    mid++;
                    break;
                case 1:
                    mid++;
                    break;
                case 2:
                    if (nums[mid] != nums[high]) {
                        nums[mid] = nums[mid] ^ nums[high];
                        nums[high] = nums[mid] ^ nums[high];
                        nums[mid] = nums[mid] ^ nums[high];
                    }
                    high--;
                    break;
            }
        }
    }
}