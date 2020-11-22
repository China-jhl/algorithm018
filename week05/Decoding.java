package com.most.av.videoapp.algorithm;

import android.text.TextUtils;

public class Decoding {


    //f[i] 最后下标为i的字符串的编码次数
    //f[i] = f[i - 1] + f[i -2]  char[i]<='6'&&char[i-1]<='2'
    //f[i] = f[i -1]
    // f[i] =f[i-2]     char[i]=='0'
    // f[i] =f[i-1]     char[i-1]=='0'

//    public int numDecodings(String s) {
//        if (s == null || s.length() == 0 || s.charAt(0) == '0') return 0;
//        if (s.length() == 1) return 1;
//        char[] charArray = s.toCharArray();
//        int[] dp = new int[charArray.length];
//        dp[0] = 1;
//        if (charArray[0] <= '2' && charArray[1] <= '6' && charArray[1] != '0') {
//            dp[1] = 2;
//        } else {
//            dp[1] = 1;
//        }
//        for (int i = 2; i < charArray.length; i++) {
//            if ((charArray[i] == '0' && charArray[i - 1] == '0') || (charArray[i] == '0' && charArray[i - 1] > '2'))
//                return 0;
//            if (charArray[i] == '0') {
//                dp[i] = dp[i - 2];
//            } else if (charArray[i - 1] == '0') {
//                dp[i] = dp[i - 1];
//            } else if (charArray[i - 1] <= '2' && charArray[i] <= '6') {
//                dp[i] = dp[i - 1] + dp[i - 2];
//            } else {
//                dp[i] = dp[i - 1];
//            }
//        }
//        return dp[dp.length - 1];
//    }

    public int numDecodings(String s) {
        int len = s.length();
        if (len == 0) {
            return 0;
        }

        // dp[i] 以 s[i] 结尾的前缀子串有多少种解码方法
        // dp[i] = dp[i - 1] * 1 if s[i] != '0'
        // dp[i] += dp[i - 2] * 1 if  10 <= int(s[i - 1..i]) <= 26
        int[] dp = new int[len];

        char[] charArray = s.toCharArray();
        if (charArray[0] == '0') {
            return 0;
        }
        dp[0] = 1;

        for (int i = 1; i < len; i++) {
            if (charArray[i] != '0') {
                dp[i] = dp[i - 1];
            }

            int num = 10 * (charArray[i - 1] - '0') + (charArray[i] - '0');
            if (num >= 10 && num <= 26) {
                if (i == 1) {
                    dp[i]++;
                } else {
                    dp[i] += dp[i - 2];
                }
            }
        }
        return dp[len - 1];
    }
}
