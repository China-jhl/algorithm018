package com.most.av.videoapp.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permute2 {
    //nums = [1,1,2]
    //[[1,1,2],[1,2,1],[2,1,1]]
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        boolean[] visited = new boolean[nums.length];//标记元素是否被访问
        List<Integer> out = new ArrayList<>();//存放每组结果
        backtrackUnique(0, nums.length, out, result, visited, nums);
        return result;
    }

    private void backtrackUnique(int level, int n, List<Integer> out, List<List<Integer>> result, boolean[] visited, int[] nums) {
        if (level == n) {
            result.add(new ArrayList<Integer>(out));
            return;
        }
        for (int i = 0; i < n; i++) {
            if (visited[i] ||
                    (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1])) {
                //1当前元素已被访问，跳过
                //2两个相同元素挨着，前一个还没有被访问过，避免这种情况，跳过
                //因为前一个元素在当前level的时候，已经遍历包含了当前元素位于当前
                //level的所有情况
                continue;
            }
            out.add(nums[i]);
            visited[i] = true;
            backtrackUnique(level + 1, n, out, result, visited, nums);
            visited[i] = false;
            out.remove(level);
        }
    }

}
