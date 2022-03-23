package HackerRank.Java;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
Java>Data Structures>Java Subarray

We define the following:

A subarray of an n-element array is an array composed from a contiguous block of the
original array's elements.
For example, if array=[1,2,3], then the subarrays are [1],[2] ,[3] ,[1,2] ,[2,3] ,and [1,2,3].
Something like [1,3] would not be a subarray as it's not a contiguous subsection of the original array.

The sum of an array is the total sum of its elements.
    -An array's sum is negative if the total sum of its elements is negative.
    -An array's sum is positive if the total sum of its elements is positive.
Given an array of n integers, find and print its number of negative subarrays on a new line.

Input Format

The first line contains a single integer, n,
denoting the length of array [a_0,a_1,a_2,...,a_n].
The second line contains n space-separated integers describing each respective element,a[i] , in array A.

Output Format

Print the number of subarrays of  having negative sums.

Sample Input
5
1 -2 4 -5 1
Sample Output

9

 */
public class Q038 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int a[] = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scan.nextInt();
        }
        scan.close();
        int l=1;
        int sum=0;
        int count = 0;
        while(l<n+1){
            for(int i=0;i<n-l+1;i++){
                sum =0;
                for (int j=i;j<i+l;j++){
                    sum+=a[j];
                }
                if (sum<0){
                    count++;
                }
            }
            l++;
        }
        System.out.println(count);
    }
    public static void solution2(){

    }
}
