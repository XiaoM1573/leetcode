package code;

import java.util.*;

public class Solution475 {


    public int findRadius(int[] houses, int[] heaters) {
        int n1 = houses.length;
        int n2 = heaters.length;
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int d1 = Math.abs(houses[n1 - 1] - heaters[0]);
        int d2 = Math.abs(houses[n1 - 1] - houses[0]);
        int d3 = Math.abs(heaters[n2 - 1] - houses[0]);
        int max = Math.max(Math.max(d1, d2), d3);
        int left = 0;
        int right = max;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (possible(houses, heaters, mid)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }


    public boolean possible(int[] houses, int[] heaters, int r) {

        int j = 0;
        for (int i = 0; i < houses.length; i++) {
            // 不需要重头开始找
            //int j = 0;
            // 判断house[i]是否在heaters的区间内
            while (j < heaters.length && (houses[i] > heaters[j] + r || houses[i] < heaters[j] - r)) {
                j++;
            }
            if (j == heaters.length) return false;
        }
        return true;
    }

}
