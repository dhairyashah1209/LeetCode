/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class firstBadVersion extends VersionControl {
    public int firstBadVersion(int n) {
        int left = 1, right = n;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (isBadVersion(mid) == true) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}