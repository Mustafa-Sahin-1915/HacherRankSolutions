package HackerRank;

import java.util.Arrays;
import java.util.Scanner;

/*
Maximum Sum Subarray Problem (Kadane’s Algorithm)
Given an integer array, find a contiguous subarray within it that has the largest sum.

Those who cannot remember the past are condemned to repeat it. — Dynamic Programming

Ex:
[-2, 1, -3, 4,-1, 2, 1, -5, 4]

Maximum sum sub array is [4,-1,2,1]


* */
public class Q039 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int a[] = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scan.nextInt();
        }
        scan.close();
        System.out.println(maxSubArray(a));
    }
    public static int maxSubArray(int a[]){
        // stores the maximum sum subarray found so far
        int maxSoFar = 0;

        // stores the maximum sum of subarray ending at the current position
        int maxEndingHere = 0;

        // traverse the given array
        for (int i: a)
        {
            // update the maximum sum of subarray "ending" at index `i` (by adding the
            // current element to maximum sum ending at previous index `i-1`)
            maxEndingHere = maxEndingHere + i;

            // if the maximum sum is negative, set it to 0 (which represents
            // an empty subarray)
            maxEndingHere = Integer.max(maxEndingHere, 0);

            // update the result if the current subarray sum is found to be greater
            maxSoFar = Integer.max(maxSoFar, maxEndingHere);
        }

        return maxSoFar;
    }
    // if elements are negative
    public static int maxSubArray2(int a[]){
        // find the maximum element present in a given array
        int max = Arrays.stream(a).max().getAsInt();

        // if the array contains all negative values, return the maximum element
        if (max < 0) {
            return max;
        }

        // stores the maximum sum subarray found so far
        int maxSoFar = 0;

        // stores the maximum sum of subarray ending at the current position
        int maxEndingHere = 0;

        // do for each element of the given array
        for (int i: a)
        {
            // update the maximum sum of subarray "ending" at index `i` (by adding the
            // current element to maximum sum ending at previous index `i-1`)
            maxEndingHere = maxEndingHere + i;

            // if the maximum sum is negative, set it to 0 (which represents
            // an empty subarray)
            maxEndingHere = Integer.max(maxEndingHere, 0);

            // update the result if the current subarray sum is found to be greater
            maxSoFar = Integer.max(maxSoFar, maxEndingHere);
        }

        return maxSoFar;
    }
    // Function to find the maximum sum of a contiguous subarray
    // in a given integer array (handles negative numbers as well)
    public static int maxSubArray3(int a[]){
        // stores the maximum sum subarray found so far
        int maxSoFar = Integer.MIN_VALUE;

        // stores the maximum sum of subarray ending at the current position
        int maxEndingHere = 0;

        // traverse the given array
        for (int i: a)
        {
            // update the maximum sum of subarray "ending" at index `i` (by adding the
            // current element to maximum sum ending at previous index)
            maxEndingHere = maxEndingHere + i;

            // maximum sum should be more than the current element
            maxEndingHere = Integer.max(maxEndingHere, i);

            // update the result if the current subarray sum is found to be greater
            maxSoFar = Integer.max(maxSoFar, maxEndingHere);
        }

        return maxSoFar;
    }
}
