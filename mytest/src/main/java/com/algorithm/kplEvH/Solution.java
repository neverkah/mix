package com.algorithm.kplEvH;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution {
    Set<Integer> set;
    int n, m;
    int[][] move = new int[][]{
            {0, 1},
            {1, 0},
            {-1, 0},
            {0, -1},
    };
    int[][][] speed;
    int nx, ny;
    public int[][] bicycleYard(int[] pos, int[][] ter, int[][] obs) {
        this.set = new HashSet<>();
        this.n = ter.length;
        this.m = ter[0].length;
        this.speed = new int[n][m][110];
        this.nx = pos[0];
        this.ny = pos[1];
        dfs(pos[0], pos[1], 1, ter, obs);
        // 把set里面的数据提取出来
        int[][] ans = new int[set.size()][2];
        int id = 0;
        for (int ni : set) {
            ans[id][0] = ni / m;
            ans[id][1] = ni % m;
            id++;
        }
        // 按照题目规则进行排序
        Arrays.sort(ans, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            }
            return o1[0] - o2[0];
        });
        return ans;
    }

    public void dfs(int x, int y, int sp, int[][] ter, int[][] obs) {
        // 剪枝
        if ( sp <= 0 || speed[x][y][sp] == 1) return;
        // set去重
        if (sp == 1){
            if (!(x == nx && y == ny)) {
                set.add(x * m + y);
            }
        }
        // 表示这个位置的这个速度已经到达过了
        speed[x][y][sp] = 1;
        // 模版形式的深搜
        for (int[] ns : move) {
            int dx = x + ns[0];
            int dy = y + ns[1];
            if (isOk(dx, dy)) continue;
            dfs(dx, dy, sp + (ter[x][y] - ter[dx][dy] - obs[dx][dy]), ter, obs);
        }

    }

    public boolean isOk(int x, int y) {
        return x < 0 || x >= n || y < 0 || y >= m;
    }
}

