package HackerRank.Java;
/*
* We use the integers a,b ,n and  to create the following series:

(a+2^0*b), (a+2^0*b+2^1*b),...,(a+2^0*b+2^1*b+2^2*b+...2^(n-1)*b)

You are given q queries in the form of a,b ,n and .
* For each query, print the series corresponding to the given a,b ,n
* and  values as a single line of n space-separated integers.

Input Format

The first line contains an integer, q , denoting the number of queries.
Each line i of the q subsequent lines contains three space-separated integers describing
* the respective a_i,b_i , and n_i values for that query.
*
* Constraints
* 0<=q<=500
* 0<=a,b<=50
* 1<=n<=15
*
* Output Format

For each query, print the corresponding series on a new line.
* Each series must be printed in order as a single line of n space-separated integers.
*
* Sample Input
2
0 2 10
5 3 5
*
Sample Output

2 6 14 30 62 126 254 510 1022 2046
8 14 26 50 98
* */

import java.util.Scanner;

public class Q06 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        //q number of queries
        int q = in.nextInt();
        for (int i = 0; i < q; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            int n = in.nextInt();
            String out = "";

            int bspart = 1*b;
            int s0 = a+bspart;
            out = String.valueOf(s0);
            int s1 = 0;
            for (int j = 1; j < n; j++) {
                bspart = 2*bspart;
                s1 = s0 + bspart;
                out = out +" "+s1;
                s0=s1;
            }
            System.out.println(out);
        }
        in.close();
    }
}
