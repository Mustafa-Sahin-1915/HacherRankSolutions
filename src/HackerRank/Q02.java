package HackerRank;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Q02 {
    private static final Scanner scanner = new Scanner(System.in);

    // \u2028 line seperator
    // \u2029 paragraph seperator
    // \u0085 next line
    // \n newline
    // \r carriage return
    /*
    Given an integer, , perform the following conditional actions:

If  is odd, print Weird
If  is even and in the inclusive range of  to , print Not Weird
If  is even and in the inclusive range of  to , print Weird
If  is even and greater than , print Not Weird
Complete the stub code provided in your editor to print whether or not  is weird.
A single line containing a positive integer, .

Constraints
  1<=N<=100
  *
  */
    public static void main(String[] args) {
        int N = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        if (N >= 1 && N <= 100) {
            if (N % 2 == 0) {
                if (N >= 2 && N <= 5) {
                    System.out.println("Not Weird");
                } else if (N >= 6 && N <= 20) {
                    System.out.println("Weird");
                } else if (N > 20) {
                    System.out.println("Not Weird");
                }
            } else {
                System.out.println("Weird");
            }
        }
        scanner.close();
    }

}
