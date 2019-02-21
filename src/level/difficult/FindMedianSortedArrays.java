package level.difficult;

import java.util.Arrays;

/**
 * @author lawrence
 * 2019.02.21
 * <p>
 * 4. 寻找两个有序数组的中位数
 * <p>
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
 * <p>
 * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 * <p>
 * 你可以假设 nums1 和 nums2 不会同时为空。
 * <p>
 * 示例 1:
 * <p>
 * nums1 = [1, 3]
 * nums2 = [2]
 * <p>
 * 则中位数是 2.0
 * 示例 2:
 * <p>
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * <p>
 * 则中位数是 (2 + 3)/2 = 2.5
 */
public class FindMedianSortedArrays {


    /**
     * 首先想到的最笨的办法就是将两个数组合二为一，然后求出中位数
     *
     * 但是题中的时间复杂度不符合
     *
     * @param nums1 数组一
     * @param nums2 数组二
     * @return 返回中位数
     */
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length1 = nums1.length;
        int length2 = nums2.length;

        int length3 = length1 + length2;
        int[] nums3 = new int[length3];
        int i = 0, j = 0, k = 0;
        while (i < length1 && j < length2) {
            if (nums1[i] < nums2[j]) {
                nums3[k++] = nums1[i++];
            } else {
                nums3[k++] = nums2[j++];
            }
        }

        while (i < length1) {
            nums3[k++] = nums1[i++];
        }

        while (j < length2) {
            nums3[k++] = nums2[j++];
        }

        if (length3 % 2 == 0) {
            return (nums3[length3 / 2] + nums3[length3 / 2 - 1]) / 2.0;
        } else {
            return nums3[length3 / 2];
        }


    }


    /**
     * 官方题解中 给出的答案是是利用递归调用
     *
     * 注意 一般递归的时间复杂度基本都为log级别的
     *
     *
     * TODO 待理解
     * @param A 数组一
     * @param B 数组二
     * @return 返回中位数
     */
    public static double findMedianSortedArrays2(int[] A, int[] B) {


        int m = A.length;
        int n = B.length;
        if (m > n) { // to ensure m<=n
            int[] temp = A; A = B; B = temp;
            int tmp = m; m = n; n = tmp;
        }
        int iMin = 0, iMax = m, halfLen = (m + n + 1) / 2;
        while (iMin <= iMax) {
            int i = (iMin + iMax) / 2;
            int j = halfLen - i;
            if (i < iMax && B[j-1] > A[i]){
                iMin = i + 1; // i is too small
            }
            else if (i > iMin && A[i-1] > B[j]) {
                iMax = i - 1; // i is too big
            }
            else { // i is perfect
                int maxLeft = 0;
                if (i == 0) { maxLeft = B[j-1]; }
                else if (j == 0) { maxLeft = A[i-1]; }
                else { maxLeft = Math.max(A[i-1], B[j-1]); }
                if ( (m + n) % 2 == 1 ) { return maxLeft; }

                int minRight = 0;
                if (i == m) { minRight = B[j]; }
                else if (j == n) { minRight = A[i]; }
                else { minRight = Math.min(B[j], A[i]); }

                return (maxLeft + minRight) / 2.0;
            }
        }
        return 0.0;


    }

    public static void main(String[] args) {

        System.out.println(findMedianSortedArrays(new int[]{1,2},new int[]{3,4}));


    }





}
