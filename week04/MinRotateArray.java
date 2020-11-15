package com.most.av.videoapp.algorithm;

public class MinRotateArray {


    public int findMin(int[] nums) {
        int min = -1;
        if (nums != null && nums.length > 0) {
            min = nums[0];
            int left = 0, right = nums.length - 1;
            while (left <= right) {
                int middle = (left + right) / 2;
                if (nums[left] <= nums[middle]) {//left - middle有序
                    min = Math.min(nums[left], min);
                    left = middle + 1;
                } else {//middle-right有序
                    min = Math.min(nums[middle], min);
                    right = middle - 1;

                }
            }
        }
        return min;
    }
}

