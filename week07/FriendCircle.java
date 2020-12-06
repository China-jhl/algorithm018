package com.most.av.videoapp.algorithm;

import java.util.LinkedList;
import java.util.Queue;

public class FriendCircle {


    //BFS
    // [[1,1,0],
    // [1,1,0],
    // [0,0,1]]

    //     *
    //  *     *
    //*   * *    *
    public int findCircleNum(int[][] M) {
        if (M == null || M.length == 0) return 0;
        int count = 0;
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[M.length];
        for (int i = 0; i < M.length; i++) {
            if (!visited[i]) {
                queue.add(i);
                while (queue.size() > 0) {
                    int index = queue.poll();
                    visited[index] = true;
                    for (int j = 0; j < M[0].length; j++) {
                        if (M[index][j] == 1 && !visited[j]) {
                            queue.add(j);
                        }
                    }
                }
                count++;
            }
        }
        return count;
    }


    //union set

    // [[1,1,0],
    // [1,1,0],
    // [0,0,1]]
    public int findCircleNum2(int[][] M) {
        if (M == null || M.length == 0) return 0;
        Union union = new Union(M.length);
        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M[0].length; j++) {
                if (M[i][j] == 1 && i != j) {
                    union.unionSet(i, j);
                }
            }
        }
        return union.count;
    }

    static class Union {
        private int count;
        private int[] parent;

        public Union(int n) {
            parent = new int[n];
            count = n;
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public int find(int q) {
            while (parent[q] != q) {
                parent[q] = parent[parent[q]];
                q = parent[q];
            }
            return q;
        }

        public void unionSet(int p, int q) {
            int rp = find(p);
            int rq = find(q);
            if (rp == rq) return;
            parent[rp] = rq;
            count--;
        }

        public int getCount() {
            return count;
        }
    }
}
