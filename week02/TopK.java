package com.most.av.videoapp.algorithm;

import android.os.Build;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

import androidx.annotation.RequiresApi;

public class TopK {
    @RequiresApi(api = Build.VERSION_CODES.N)
    public int[] topKFrequent(int[] nums, int k) {
        int[] result = new int[k];
        if (nums != null) {
            HashMap<Integer, Integer> countMap = new HashMap<>();
            for (int i : nums) {
                Integer nc = countMap.get(i);
                if (nc == null) {
                    nc = 0;
                }
                countMap.put(i, ++nc);
            }
            PriorityQueue<int[]> topKHeap = new PriorityQueue<int[]>(new Comparator<int[]>() {
                @Override
                public int compare(int[] m, int[] n) {
                    return m[1] - n[1];
                }
            });
            Set<Map.Entry<Integer, Integer>> countSet = countMap.entrySet();
            int ik = 0;
            for (Map.Entry<Integer, Integer> num : countSet) {
                if (ik < k) {
                    topKHeap.add(new int[]{num.getKey(), num.getValue()});
                    ik++;
                    continue;
                }
                if (num.getValue() > topKHeap.peek()[1]) {
                    topKHeap.poll();
                    topKHeap.add(new int[]{num.getKey(), num.getValue()});
                }
            }
            for (int j = 0; j < k; j++) {
                result[j] = topKHeap.poll()[0];
            }
        }
        return result;
    }
}
