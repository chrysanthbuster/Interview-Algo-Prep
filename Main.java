import java.util.Arrays;

class Main {
  public static void main(String[] args) {

    int[] nums = new int[] { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
    int[] numshort = new int[] { -2, 1 };
    int[] somenums = new int[] { 9, -6, 10 };

    System.out.println(maxSubArrayLinear(numshort));
    System.out.println(maxSubArrayDivideIndex(numshort));
  }
  
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
