package level.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author lawrence
 * 2019.02.20
 * <p>
 * 1.两数之和
 * <p>
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * <p>
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 * <p>
 * <p>
 * 示例：
 *
 * <p>
 * 给定 nums = [2, 7, 11, 15], target = 9
 * <p>
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 */
public class TwoSum {


    /**
     * 考虑暴力求解
     * 两层循环 直接求出
     *
     * @param nums   目标数组
     * @param target 目标值
     * @return 返回下标数组
     */
    public static int[] twoSum(int[] nums, int target) {

        int length = nums.length;

        for (int i = 0; i < length; i++) {
            // 直接从下一位比较，前面不需要比较了
            for (int j = i + 1; j < length; j++) {
                //判断相等
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }

        return null;
    }


    /**
     * 官方解：一步hash（利用hashmap 空间换时间）
     * 利用map key-nums[i],value-i
     *
     * @param nums   目标数组
     * @param target 目标值
     * @return 返回下标数组
     */
    public static int[] twoSum2(int[] nums, int target) {

        Map<Integer, Integer> numMap = new HashMap<>();

        int length = nums.length;

        Integer j = 0;

        for (int i = 0; i < length; i++) {

            if ((j = numMap.get(target - nums[i])) != null) {
                return new int[]{i, j};
            }

            numMap.put(nums[i], i);

        }
        return null;
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;

        int[] resultArr = twoSum(nums, target);

        System.out.println(Arrays.toString(resultArr));

        int[] resultArr2 = twoSum2(nums, target);

        System.out.println(Arrays.toString(resultArr2));

    }


}
