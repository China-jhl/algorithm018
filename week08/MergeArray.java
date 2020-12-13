package com.most.av.videoapp.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeArray {
//    给出一个区间的集合，请合并所有重叠的区间。

//    输入: intervals = [[1,3],[2,6],[8,10],[15,18]]
//    输出: [[1,6],[8,10],[15,18]]
//    解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].


    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return null;
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        List<int[]> result = new ArrayList<>();
        for (int[] interval : intervals) {
            int l = interval[0], r = interval[1], rs = result.size();
            if (rs == 0 || result.get(rs - 1)[1] < l) {
                result.add(new int[]{l, r});
            } else {
                result.set(rs - 1, new int[]{result.get(rs - 1)[0], Math.max(result.get(rs - 1)[1], r)});
            }
        }
        return result.toArray(new int[result.size()][]);
    }
}
