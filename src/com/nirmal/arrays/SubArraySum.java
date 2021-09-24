package com.nirmal.arrays;

public class SubArraySum {
    //https://leetcode.com/problems/subarray-sum-equals-k/
    public int subarraySum(int[] nums, int k) {
        int subArrayCtr = 0;
        int currentSum = nums[0];
        for (int i = 1; i <= nums.length; i++) {

            int start = 0 ;
            while (currentSum > k && start < i - 1) {
                currentSum = currentSum - nums[start];
                start++;
            }
            if (currentSum == k) {
                subArrayCtr++;
            }
            if (i < nums.length) {
                currentSum = currentSum + nums[i];
            }
        }
        return subArrayCtr;
    }

    public static void main(String[] args) {
        SubArraySum sas = new SubArraySum();
        int arr[] = {1,4,1};
        System.out.println(sas.subarraySum(arr,2));
    }
}
