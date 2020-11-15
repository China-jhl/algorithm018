package com.most.av.videoapp.algorithm;

public class SearchRotateArray {

    public int search(int[] nums, int target) {
        int result = -1;
        if (nums != null) {
            int left = 0, right = nums.length - 1;
            while (left <= right) {
                int middle = (left + right) / 2;
                if (nums[middle] == target) {
                    result = middle;
                    break;
                } else if (nums[left] <= nums[middle]) {
                    if (nums[left] <= target && target < nums[middle]) {
                        right = middle - 1;
                    } else {
                        left = middle + 1;
                    }
                } else {
                    if (target > nums[middle] && target <= nums[right]) {
                        left = middle + 1;
                    } else {
                        right = middle - 1;
                    }
                }
            }
        }
        return result;
    }
}

