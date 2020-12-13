package com.most.av.videoapp.algorithm;

public class ReversePairs {
    public int reversePairs(int[] nums) {
        if (nums == null || nums.length <= 0) return 0;
        return mergeSort(nums, 0, nums.length - 1);
    }

    private int mergeSort(int[] nums, int left, int right) {
        if (left >= right) return 0;

        int result = 0;

        int middle = (left + right) / 2;
        result += mergeSort(nums, left, middle);
        result += mergeSort(nums, middle + 1, right);

        int p = left, q = middle + 1;
        while (p <= middle) {
            while (q <= right && (long) nums[p] > 2 * (long) nums[q]) {
                q++;
            }
            result += q - middle - 1;
            p++;
        }

        int[] temp = new int[right - left + 1];
        int i = left, j = middle + 1, k = 0;
        while (i <= middle && j <= right) {
            if (nums[i] > nums[j]) {
                temp[k++] = nums[j++];
            } else {
                temp[k++] = nums[i++];
            }
        }
        while (i <= middle) temp[k++] = nums[i++];
        while (j <= right) temp[k++] = nums[j++];
        System.arraycopy(temp, 0, nums, left, temp.length);

        return result;
    }
}
