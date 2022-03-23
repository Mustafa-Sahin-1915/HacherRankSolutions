package HackerRank.Java;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
Java>Data Structures>Java Arraylist
Sometimes it's better to use dynamic size arrays.
Java's Arraylist can provide you this feature.
Try to solve this problem using Arraylist.

You are given n lines. In each line there are zero or more integers.
You need to answer a few queries where you need to tell the number
located in y. position of x. line.

Take your input from System.in.

Input Format
The first line has an integer n.
In each of the next n lines there will be an integer d
denoting number of integers on that line and
then there will be d space-separated integers.
In the next line there will be an integer q denoting number of queries.
Each query will consist of two integers x and y.
Output Format
In each line, output the number located in y. position of x. line.
If there is no such position, just print "ERROR!"

Sample Input

5
5 41 77 74 22 44
1 12
4 37 34 36 52
0
3 20 22 33
5
1 3
3 4
3 1
4 3
5 5

Sample Output

74
52
37
ERROR!
ERROR!

 */
public class Q040 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n= scan.nextInt();
        List<List<Integer>> lines = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            lines.add(new ArrayList<Integer>());
        }
        int d=0;
        int input;
        for (int i = 0; i < n; i++) {
            d = scan.nextInt();
            for (int j=0;j<d;j++){
                input = scan.nextInt();
                lines.get(i).add(input);
            }
        }
        int q =0;
        q = scan.nextInt();
        int x[]= new int[q];
        int y[]= new int[q];
        int el =0;
        for (int i = 0; i < q; i++) {
            x[i]= scan.nextInt();
            y[i] = scan.nextInt();
        }
        for (int i = 0; i < q; i++) {
            if (x[i]<=lines.size()){
                if (y[i]<=lines.get(x[i]-1).size()){
                    el = lines.get(x[i]-1).get(y[i]-1);
                    System.out.println(el);
                }else{
                    System.out.println("ERROR!");
                }
            }else{
                System.out.println("ERROR!");
            }
        }
        scan.close();
    }
}
