package com.most.av.videoapp.algorithm;

import android.os.Build;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import androidx.annotation.RequiresApi;

public class GroupAnagrams {
    @RequiresApi(api = Build.VERSION_CODES.N)
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs != null) {
            HashMap<String, List<String>> resultMap = new HashMap<>();
            int[] count = new int[26];
            for (String item : strs) {
                Arrays.fill(count, 0);
                char[] sLetters = item.toCharArray();
                for (char pl : sLetters) {
                    count[pl - 'a']++;
                }
                StringBuilder mapKey = new StringBuilder();
                for (int i = 0; i < 26; i++) {
                    mapKey.append("#");
                    mapKey.append(count[i]);
                }

                List<String> valueList = resultMap.get(mapKey.toString());
                if (valueList == null) {
                    valueList = new ArrayList<>();
                    resultMap.put(mapKey.toString(), valueList);
                }
                valueList.add(item);
            }
            return new ArrayList<>(resultMap.values());
        }
        return null;
    }
}
