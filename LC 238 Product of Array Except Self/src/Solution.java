public class Solution {
    public int[] productExceptSelf(int[] nums) {
        //first, calculate the left product excluding the index
        //second, calcualte the right product exluding the index
        //time complexity: O(n)
        //space complexity: O(2n) = O(n)
        int size = nums.length;
        int [] left = new int [size];
        left[0] = 1;
        for (int i = 1; i < size; i++) {
            left[i] = left[i - 1] * nums[i - 1];
        }
        int [] right = new int [size];
        right[size - 1] = 1;
        for (int i = size - 2; i >= 0 ; i--) {
            right[i] = right[i + 1] * nums[i + 1];
        }
        for (int i = 0; i < size; i++) {
            right[i] = right[i] * left[i];
        }

        return right;
    }
    public int[] productExceptSelfConstSpace(int[] nums) {
        boolean zero = false;
        int numOfZero = 0;
        int size = nums.length;
        int product = 1;
        int[] ans = new int[size];
        for (int num: nums) {
            if (num == 0) {
                zero = true;
                numOfZero += 1;
            } else {
                product *= num;
            }
        }
        for (int i = 0; i < size; i++) {
            if (zero == false) {
                ans[i] = product / nums[i];
            } else if (zero == true && numOfZero == 1) {
                if (nums[i] == 0) {
                    ans[i] = product;
                }
            }
        }
        return ans;
    }
}
