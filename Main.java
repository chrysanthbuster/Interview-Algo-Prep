import java.util.Arrays;

class Main {
  public static void main(String[] args) {

    int[] nums = new int[] { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
    int[] numshort = new int[] { -2, 1 };
    int[] somenums = new int[] { -2, -1 };

    // System.out.println(maxSubArrayLinear(somenums));
    System.out.println(maxSubArrayDivideIndex(nums));
    // System.out.println(maxSubArrayDivideIndex(somenums));
  }


}
