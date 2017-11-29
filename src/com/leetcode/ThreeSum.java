package com.leetcode;

import java.util.*;

public class ThreeSum {
    public static void main(String[] args){
        List<List<Integer>> res = new ThreeSum().threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        for(List<Integer> l : res){
            for(Integer i : l){
                System.out.print(i + ",");
            }
            System.out.println();
        }
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Map<Integer, Integer> m = new HashMap<>();
        if(null == nums || nums.length <= 0) return res;
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++){
            List<Integer> l = findSum(nums, i, 0 - nums[i]);
            if(null != l) {
                l.add(nums[i]);
                Collections.sort(l);
                if(!m.containsKey(l.get(0))
                        || m.get(l.get(0)) != l.get(1)){
                    m.put(l.get(0), l.get(1));
                    res.add(l);
                }
            }
        }
        return res;
    }



    private List<Integer> findSum(int[] n, int exclusive, int t){
        int p1 = 0;
        if(p1 == exclusive) p1 ++;
        int p2 = n.length - 1;
        if(p2 == exclusive) p2 --;
        while(p1 < p2){
            int sum = n[p1] + n[p2];
            if(sum == t) {
                List<Integer> l = new ArrayList(3);
                l.add(n[p1]);
                l.add(n[p2]);
                return l;
            }else if(sum < t){
                p1 ++;
                if(p1 == exclusive) p1 ++;
            }else {
                p2 --;
                if(p2 == exclusive) p2 --;
            }
        }
        return null;
    }
}
