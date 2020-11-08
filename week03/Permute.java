package com.most.av.videoapp.algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Permute {
    //全排列
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        List<Integer> out = new ArrayList<>();
        for (int num : nums) {
            out.add(num);
        }
        backTrack(nums.length, 0, out, result);
        return result;
    }

    private void backTrack(int n, int level, List<Integer> out, List<List<Integer>> result) {
        if (level == n) {
            result.add(new ArrayList<>(out));
            return;
        }
        for (int i = level; i < n; i++) {
            Collections.swap(out, level, i);
            backTrack(n, level + 1, out, result);
            Collections.swap(out, level, i);
        }
    }
    //全排列2
}
