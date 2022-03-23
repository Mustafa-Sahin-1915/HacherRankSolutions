package HackerRank.Java;

import java.util.Arrays;
import java.util.Scanner;

/*
Maximum Sum Subarray Problem (Kadane’s Algorithm)
Given an integer array, find a contiguous subarray within it that has the largest sum.

Those who cannot remember the past are condemned to repeat it. — Dynamic Programming

Ex:
a = [-2, 1, -3, 4,-1, 2, 1, -5, 4]  [-2 1 -3 4 -1 2 1 -5 4]

Maximum sum sub array is [4,-1,2,1]

[-2, 1, -3, 4, -1,                      2, 1, -5, 4]
                                       [2] = 2
              [-1] =-1              [-1,2] = 1
            [4,-1] = 3            [4,-1,2] = 5  *********************
          [-3,4,1] = 0         [-3,4,-1,2] = 2
       [1,-3,4,-1] = 1       [1,-3,4,-1,2] = 3
    [-2,1,-3,4,-1] =-1    [-2,1,-3,4,-1,2] = 1

  local_maximum[index=4] = 3    local_maximum[index=5] = 5

    local_maximum[i] = max(a[i],a[i]+local_maximum[i-1])***

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
        System.out.println(maxSubArray5(a));
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
    //Print continuous subarray with maximum sum
    public static int[] maxSubArray4(int a[]){
        // base case
        if (a.length <= 1) {
            return a;
        }

        // stores the maximum sum subarray found so far
        int maxSoFar = Integer.MIN_VALUE;

        // stores the maximum sum of subarray ending at the current position
        int maxEndingHere = 0;

        // stores endpoints of maximum sum subarray found so far
        int start = 0, end = 0;

        // stores starting index of a positive-sum sequence
        int beg = 0;

        // traverse the given array
        for (int i = 0; i < a.length; i++)
        {
            // update the maximum sum of subarray "ending" at index `i`
            maxEndingHere = maxEndingHere + a[i];

            // if the maximum sum becomes less than the current element,
            // start from the current element
            if (maxEndingHere < a[i])
            {
                maxEndingHere = a[i];
                beg = i;
            }

            // update result if the current subarray sum is found to be greater
            if (maxSoFar < maxEndingHere)
            {
                maxSoFar = maxEndingHere;
                start = beg;
                end = i;
            }
        }

        return Arrays.copyOfRange(a, start, end + 1);
    }

    public static int maxSubArray5(int a[]){
        int local_max = 0;
        int global_max =Integer.MIN_VALUE;
        for (int i = 0; i < a.length; i++) {
            local_max = Math.max(a[i],a[i]+local_max);
            if (local_max>global_max){
                global_max = local_max;
            }
        }
        return global_max;
    }
    //bruteforce
    public static int maxSubArray6(int a[]){
        int maxSum= Integer.MIN_VALUE;
        int localSum=0;
        for (int i = 0; i < a.length; i++) {
            localSum = 0;
            for (int j = i; j < a.length; j++) {
                localSum+=a[j];
                if (localSum>maxSum){
                    maxSum = localSum;
                }
            }
        }
        return maxSum;
    }
}
