package com.most.av.videoapp.gallery;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        //2 7 11 15   9
        if (nums != null) {
            Map<Integer, Integer> mm = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                if (mm.containsKey(target - nums[i])) {
                    return new int[]{i, mm.get(target - nums[i])};
                } else {
                    mm.put(nums[i], i);
                }
            }
        }
        return new int[0];
    }
}
