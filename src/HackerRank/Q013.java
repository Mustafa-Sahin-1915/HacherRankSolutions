package HackerRank;

import java.util.Scanner;
/*
* "A string is traditionally a sequence of characters, either as a literal constant or as some kind of variable."
*
* The elements of a String are called characters. The number of characters in a String is called the length, and it can be retrieved with the String.length() method.

Given two strings of lowercase English letters, A and B, perform the following operations:

Sum the lengths of A and B.
Determine if A is lexicographically larger than B (i.e.: does  come before  in the dictionary?).
Capitalize the first letter in A and B and print them on a single line, separated by a space.
*
* Input Format

The first line contains a string A. The second line contains another string B.
* The strings are comprised of only lowercase English letters.

Output Format

There are three lines of output:
For the first line, sum the lengths of A and B.
For the second line, write Yes if A is lexicographically greater than B otherwise print No instead.
For the third line, capitalize the first letter in both A and B and
* print them on a single line, separated by a space.
*
* Sample Input 0

hello
java

* Sample Output 0

9
No
Hello Java
 * */

public class Q013 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String A=sc.next();
        String B=sc.next();
        System.out.println(A.length()+B.length());
        if (A.compareTo(B)>0){
            System.out.println("Yes");
        }else{
            System.out.println("No");
        }
        A = (""+A.charAt(0)).toUpperCase() + A.substring(1);
        B = (""+B.charAt(0)).toUpperCase() + B.substring(1);
        System.out.println(A+" "+B);
    }
}
