import java.util.Arrays;

public class Otherstuff {

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
