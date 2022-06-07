public class Otherstuff {
      // assert at least one value in the array
  public static int maxSubArray(int[] nums) {
    return maxSubArrayHelper(nums, 0, nums.length);
  }

  public static int maxSubArrayHelper(int[] nums, int start, int end) {
    if (start == end) {
      // sum of 1 number is the number itself
      return nums[start];
    }

    // minimum integer
    int maxSum = Integer.MIN_VALUE;

    int mid = start + (start + end) / 2;
    System.out.println(mid);
    printArray(nums, start, mid);
    printArray(nums, mid, end);

    // int leftSum = maxSubArrayHelper(nums, start, mid);
    // int rightSum = maxSubArrayHelper(nums, mid, end);

    // System.out.println(leftSum + " " + rightSum + " " + (leftSum + rightSum));
    // System.out.println("-------------");

    // maxSum = Math.max(leftSum, maxSum);
    // maxSum = Math.max(rightSum, maxSum);
    // maxSum = Math.max(nums[mid] + nums[mid-1], maxSum);

    return maxSum;
  }

  // print array helper
  public static void printArray(int[] nums) {
    System.out.println(Arrays.toString(nums));
  }

  // print array range helper
  public static void printArray(int[] nums, int fromIndex, int toIndex) {
    for (int i = fromIndex; i < toIndex; i++) {
      System.out.print(nums[i] + " ");
    }

    System.out.println();
  }

  /**
   * split array helper
   * 
   * @return array with all nums[start] to nums[end] not including end
   */
  public static int[] splitArray(int[] nums, int start, int end) {
    int[] split = new int[end - start];

    for (int i = start; i < end; i++) {
      split[i - start] = nums[i];
    }

    return split;
  }

  // append two array together, no merging
  public static int[] appendArray(int[] numsLeft, int[] numsRight) {
    int[] result = new int[numsLeft.length + numsRight.length];

    for (int i = 0; i < numsLeft.length; i++) {
      result[i] = numsLeft[i];
    }

    for (int i = numsLeft.length; i < result.length; i++) {
      result[i] = numsRight[i - numsLeft.length];
    }

    return result;
  }



  // using divide and merge (with array splitting), fix this later
  public static int maxSubArrayDivide(int[] nums) {
    if (nums.length == 0) {
      return Integer.MIN_VALUE;
    }

    if (nums.length == 1) {
      return nums[0];
    }

    int middle = nums.length / 2;

    int bestLeftSum = maxSubArrayDivide(splitArray(nums, 0, middle));
    int bestRightSum = maxSubArrayDivide(splitArray(nums, middle, nums.length));
    int bestMergedSum = maxMergedSum(middle, nums);

    return Math.max(bestMergedSum, Math.max(bestLeftSum, bestRightSum));
  }

  // get best sum with the the index included
  public static int maxMergedSum(int index, int[] nums) {    
    int leftSum = Integer.MIN_VALUE;
    int rightSum = Integer.MIN_VALUE;
    int curSum = 0;

    for (int i = index; i >= 0; i--) {
      curSum += nums[i];
      leftSum = Math.max(curSum, leftSum);
    }

    curSum = 0;

    for (int i = index + 1; i < nums.length; i++) {
      curSum += nums[i];
      rightSum = Math.max(curSum, rightSum);
    }

    return leftSum + rightSum;
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
    int bestRightSum = maxSubArrayDivideIndex(nums, middle + 1, end);
    
    int bestMergedSum = maxMergedSumIndex(middle, nums, start, end);

    return Math.max(bestMergedSum, Math.max(bestLeftSum, bestRightSum));
  }

  // get best sum with the the index included
  public static int maxMergedSumIndex(int index, int[] nums, int start, int end) {    
    int leftSum = Integer.MIN_VALUE;
    int rightSum = Integer.MIN_VALUE;
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

  public static void printArrayLikeBinaryTree(int[] nums) {
    printArrayLikeBinaryTree(nums, 0, nums.length);
    System.out.println();
  }

  public static void printArrayLikeBinaryTree(int[] nums, int start, int end) {
    if (start + 1 == end) {
      System.out.print(nums[start] + ", ");
      return;
    }

    int middle = start + (end - start) / 2;

    printArrayLikeBinaryTree(nums, start, middle);
    printArrayLikeBinaryTree(nums, middle, end);
  }
}
