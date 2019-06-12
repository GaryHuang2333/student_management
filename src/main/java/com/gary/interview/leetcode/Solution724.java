/*
 * Copyright (c) 2019. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.gary.interview.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 724. 寻找数组的中心索引
 */
public class Solution724 {

    public static void test() {
        int[] sums = {1,7,3,6,5,6};
        int result = new Solution3().pivotIndex(sums);
        System.out.println("result = " + result);
    }
}


class Solution3 {
    public int pivotIndex(int[] nums) {
        int leftSum = 0;
        int rightSum = 0;

        for (int i = 0; i <= nums.length - 1; i++) {
            rightSum += nums[i];
        }

        System.out.println("leftSum="+leftSum+"\trightSum="+rightSum);
        for (int i = 0; i <= nums.length - 1; i++) {
            int tmp1;
            if(i==0) {
                tmp1 = 0;
            }else{
                tmp1 = nums[i - 1];
            }
            int tmp2 = nums[i];

            rightSum -= tmp2;
            leftSum += tmp1;
            System.out.println("leftSum="+leftSum+"\trightSum="+rightSum+"\tnums="+nums[i]);

            if (leftSum == rightSum) {
                return i;
            }
        }
        return -1;
    }
}

// [-1,-1,-1,0,1,1]
class Solution2 {
    public int pivotIndex(int[] nums) {
        int length = nums.length;

        for (int i = 0; i < nums.length; i++) {
            int[] leftNums = split(nums, i, true);
            int[] rightNums = split(nums, i, false);

            int leftSum = sum(leftNums);
            int rightSum = sum(rightNums);

            if (leftSum == rightSum) {
                return i;
            }
        }

        return -1;
    }

    private int[] split(int[] nums, int ind, boolean isLeft) {
        int leftInd = 0;
        int rightInd = 0;
        if (isLeft) {
            leftInd = 0;
            rightInd = ind - 1;
        } else {
            leftInd = ind + 1;
            rightInd = nums.length - 1;
        }

        int length = rightInd - leftInd + 1;

        int[] result = new int[length];
        int j = 0;

        for (int i = leftInd; i <= rightInd; i++, j++) {
            result[j] = nums[i];
        }

        return result;
    }

    private int sum(int[] nums) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            result += nums[i];
        }
        return result;
    }

}

class Solution1 {
    public int pivotIndex(int[] nums) {
        List<Integer> numsList = Arrays.stream(nums).boxed().collect(Collectors.toList());
        int result = -1;

        for (int i = 0; i < numsList.size(); i++) {
            List<Integer> leftList = split(numsList, i, true);
            List<Integer> rightList = split(numsList, i, false);
            int leftSum = sum(leftList);
            int rightSum = sum(rightList);
            if (leftSum == rightSum) {
                result = i;
                break;
            }
        }

        return result;

    }

    private List<Integer> split(List<Integer> list, int ind, boolean isLeft) {
        int leftInd = 0;
        int rightInd = 0;
        if (isLeft) {
            leftInd = 0;
            rightInd = ind - 1;
        } else {
            leftInd = ind + 1;
            rightInd = list.size() - 1;
        }

        List<Integer> resultList = new ArrayList<>();
        for (int i = leftInd; i <= rightInd; i++) {
            resultList.add(list.get(i));
        }

        return resultList;
    }

    private int sum(List<Integer> list) {
        Integer sum = list.stream().collect(Collectors.summingInt(i -> i.intValue()));
        return sum.intValue();
    }

}