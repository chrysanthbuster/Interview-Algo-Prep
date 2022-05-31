class Main {
  public static void main(String[] args) {

    System.out.println(maxSubArray(new int[] {5, 4, -1, 7, 8}));
  }


    public static int maxSubArray(int[] nums) {
      int start = 0;
      int size = 1;
      
      int sum = nums[0];
      int localsum = sum;

      System.out.println(nums[0]);
      for (int i = 1; i < nums.length; i++) {
        System.out.println(nums[i] + " " + sum + " " + localsum +  " " + nums[start] + " " + size);

        if (nums[i] > nums[start] || nums[i] >= 0) {
          System.out.println("add");
          localsum += nums[i];
          size ++;
        } else {
          System.out.println("break");
          for (int j = start; j < i; j++) {
            if (nums[j] < 0) {
              localsum -= nums[j];
              break;
            }
          }

          if (localsum > sum) {
            sum = localsum;
          }

          localsum = nums[i];
          size = 1;          
          start = i;
        }

      }

      if (localsum > sum) {
        sum = localsum;
      }
      
      return sum;
  }
}
