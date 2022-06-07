public class MaximumSubarray {
  
  // assert at least one positive value in the array
  public static int maxSubArrayLinear(int[] nums) {
    int max = nums[0];
    int curmax = 0;
    for (int i = 0; i < nums.length; i++) {
      curmax += nums[i];

      // break the chain and restart
      if (curmax < 0) {
        curmax = 0;
      } else {
        max = Math.max(max, curmax);
      }
    }

    return max;
  }

  public static int maxSubArrayDivideIndex(int[] nums) {
    return maxSubArrayDivideIndex(nums, 0, nums.length);
  }

  public static int maxSubArrayDivideIndex(int[] nums, int start, int end) {

    if (start == end) {
      return Integer.MIN_VALUE;
    }

    if (start + 1 == end) {
      return nums[start];
    }

    int middle = start + (end - start) / 2;

    int bestLeftSum = maxSubArrayDivideIndex(nums, start, middle);
    int bestRightSum = maxSubArrayDivideIndex(nums, middle, end);

    int bestMergedSum = maxMergedSumIndex(middle, nums, start, end);

    return Math.max(bestMergedSum, Math.max(bestLeftSum, bestRightSum));
  }

  // get best sum with the the index included
  public static int maxMergedSumIndex(int index, int[] nums, int start, int end) {
    int leftSum = nums[index];
    // most of the time right side is not touched
    int rightSum = 0;
    int curSum = 0;

    for (int i = index; i >= start; i--) {
      curSum += nums[i];
      leftSum = Math.max(curSum, leftSum);
    }

    curSum = 0;

    for (int i = index + 1; i < end; i++) {
      curSum += nums[i];
      rightSum = Math.max(curSum, rightSum);
    }
    
    return leftSum + rightSum;
  }
}