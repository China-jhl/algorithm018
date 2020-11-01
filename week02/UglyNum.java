package com.most.av.videoapp.algorithm;

import java.util.HashSet;
import java.util.PriorityQueue;

public class UglyNum {
    public int nthUglyNumber(int n) {
        int[] primes = new int[]{2, 3, 5};
        PriorityQueue<Long> littleHeap = new PriorityQueue<>();
        HashSet<Long> uglied = new HashSet<>();
        littleHeap.add(1L);
        uglied.add(1L);
        int count = 0;
        long result = 0;
        while (count < n) {
            result = littleHeap.poll();
            count++;
            for (int p : primes) {
                if (!uglied.contains(result * p)) {
                    littleHeap.add(result * p);
                    uglied.add(result * p);
                }
            }
        }
        return (int) result;
    }
}
