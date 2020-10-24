package com.most.av.videoapp.gallery;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Rain {
    public int trap(int[] height) {
        int totalWater = 0;
        if (height != null) {
            int current = 0;
            Deque<Integer> leftDeque = new LinkedList<>();
            while (current < height.length) {
                while (leftDeque.size() > 0 && height[current] > height[leftDeque.peek()]) {
                    int top = leftDeque.pop();
                    if (leftDeque.size() <= 0) {
                        continue;
                    }
                    int distance = current - leftDeque.peek() - 1;
                    int waterHeight = Math.min(height[current], height[leftDeque.peek()]) - height[top];
                    totalWater += distance * waterHeight;
                }
                leftDeque.push(current++);
            }
        }
        return totalWater;
    }
}
