package HackerRank.Java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/*

Java > Data Structures > 2D Array

You are given a 6*6 2D array. An hourglass in an array is a portion shaped like this:

a b c
  d
e f g
For example, if we create an hourglass using
the number 1 within an array full of zeros,
it may look like this:

1 1 1 0 0 0
0 1 0 0 0 0
1 1 1 0 0 0
0 0 0 0 0 0
0 0 0 0 0 0
0 0 0 0 0 0

Actually, there are many hourglasses in the array above.
The three leftmost hourglasses are the following:
1 1 1     1 1 0     1 0 0
  1         0         0
1 1 1     1 1 0     1 0 0
The sum of an hourglass is the sum of all the numbers within it.
The sum for the hourglasses above are 7, 4, and 2, respectively.

In this problem you have to print the largest sum among all the hourglasses in the array.

Input Format

There will be exactly 6 lines,
each containing 6 integers seperated by spaces.
Each integer will be between -9 and 9 inclusive.

Output Format

Print the answer to this problem on a single line.

Sample Input

1 1 1 0 0 0
0 1 0 0 0 0
1 1 1 0 0 0
0 0 2 4 4 0
0 0 0 2 0 0
0 0 1 2 4 0

Sample Output
19

Explanation
The hourglass which has the largest sum is:

2 4 4
  2
1 2 4

 */
public class Q037 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        List<List<Integer>> arr = new ArrayList<>();

        for (int i = 0; i < 6; i++) {
            String[] arrRowTempItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

            List<Integer> arrRowItems = new ArrayList<>();

            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowTempItems[j]);
                arrRowItems.add(arrItem);
            }

            arr.add(arrRowItems);
        }
        bufferedReader.close();
        int a,b,c,d,e,f,g,o1,o2;
        int sum=0;
        int maxsum=Integer.MIN_VALUE;
        for (int i = 0; i < arr.size()-2; i++) {
            for (int j = 0; j < arr.get(i).size()-2; j++) {
                sum = 0;
                a=arr.get(i).get(j);
                b=arr.get(i).get(j+1);
                c=arr.get(i).get(j+2);
                o1 =arr.get(i+1).get(j);
                d=arr.get(i+1).get(j+1);
                o2=arr.get(i+1).get(j+2);
                e=arr.get(i+2).get(j);
                f=arr.get(i+2).get(j+1);
                g=arr.get(i+2).get(j+2);
                sum = a+b+c+d+e+f+g;
                maxsum = (sum>maxsum)?sum:maxsum;
            }
        }
        System.out.println(maxsum);
    }
}
