package HackerRank;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
Java>Data Structures>Java List
For this problem, we have  types of queries you can perform on a List:
Insert y at index x:
    Insert
    x y

Delete the element at index x:
    Delete
    x

Given a list, L, of N integers, perform  queries on the list.
Once all queries are completed, print the modified list as a single line of space-separated integers.

Input Format

The first line contains an integer, N (the initial number of elements in L).
The second line contains N space-separated integers describing L.
The third line contains an integer, Q (the number of queries).
The 2*Q subsequent lines describe the queries,
and each query is described over two lines:

->If the first line of a query contains the String Insert,
then the second line contains two space separated integers x y,
and the value y must be inserted into L at index x.

If the first line of a query contains the String Delete,
then the second line contains index x, whose element must be deleted from L.

Sample Input
5
12 0 1 78 12
2
Insert
5 23
Delete
0

Sample Output
0 1 78 12 23
 */
public class Q032 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> l = new ArrayList<>();
        int n = scan.nextInt();
        for (int i=0;i<n;i++){
            l.add(scan.nextInt());
        }
        int q = scan.nextInt();
        String op =null;
        int x,y;
        for (int i = 0; i < q; i++) {
            op = scan.next();
            if (op.equals("Insert")){
                x = scan.nextInt();
                y = scan.nextInt();
                if (x>=0 && x<l.size()){
                    l.add(Integer.valueOf(x),y);
                }else if (x>=l.size()){
                    l.add(y);
                }
            }else if (op.equals("Delete")){
                x = scan.nextInt();
                if (x>=0 && x<l.size()) {
                    l.remove(x);
                }
            }
        }
        for (int w:l) {
            System.out.print(w+" ");
        }
        scan.close();

    }
}
