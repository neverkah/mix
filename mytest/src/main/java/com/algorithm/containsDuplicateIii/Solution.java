package com.algorithm.containsDuplicateIii;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        int left = 0, right = 0;
        Map<Integer, Integer> map = new HashMap<>();
        Deque<Integer> maxDeq = new LinkedList<>();
        Deque<Integer> minDeq = new LinkedList<>();
        int N = nums.length;
        while (right < N) {
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);
            while (!maxDeq.isEmpty() && nums[maxDeq.peekLast()] < nums[right]) {
                maxDeq.pollLast();
            }
            maxDeq.offerLast(right);
            while (!minDeq.isEmpty() && nums[minDeq.peekLast()] > nums[right]) {
                minDeq.pollLast();
            }
            minDeq.offerLast(right);
            while (left <= right - 1 && (right - left == k || (nums[maxDeq.peekFirst()] - nums[minDeq.peekFirst()] <= t && !maxDeq.peekFirst().equals(minDeq.peekFirst())) || map.get(nums[right]) >= 2)) {
                if ((nums[maxDeq.peekFirst()] - nums[minDeq.peekFirst()] <= t && !maxDeq.peekFirst().equals(minDeq.peekFirst())) || map.get(nums[right]) >= 2) {
                    return true;
                }
                map.put(nums[left], map.get(nums[left]) - 1);
                if (maxDeq.peekFirst() == left) {
                    maxDeq.pollFirst();
                }
                left++;
            }
            right++;
        }
        return false;
    }
}