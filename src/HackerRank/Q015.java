package HackerRank;

import java.util.Scanner;
/*
* We define the following terms:

Lexicographical Order, also known as alphabetic or dictionary order, orders characters as follows:
A<B<C...<Y<Z<a<b...<y<z
*
* A substring of a string is a contiguous block of characters in the string.
* For example, the substrings of abc are a, b, c, ab, bc, and abc.
* Given a string, s, and an integer,k ,
* complete the function so that it finds
* the lexicographically smallest and largest substrings of length k
*
* Function Description

Complete the getSmallestAndLargest function in the editor below.

getSmallestAndLargest has the following parameters:

string s: a string
int k: the length of the substrings to find
Returns

string: the string ' + "\n" + ' where and are the two substrings
*
* Input Format

The first line contains a string denoting .
The second line contains an integer denoting .
*
* Sample Input 0

welcometojava
3
Sample Output 0

ava
wel
*
* String s="welcometojava" has the following lexicographically-ordered substrings of length k=3 :

["ava,com,elc,eto,jav,lco,met"]
We then return the first (lexicographically smallest) substring and the last
* (lexicographically largest) substring as two newline-separated values (i.e., ava\nwel).

The stub code in the editor then prints ava
* as our first line of output and wel as our second line of output.
* */
public class Q015 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.next();
        int k = scan.nextInt();
        scan.close();

        System.out.println(getSmallestAndLargest(s, k));
    }
    public static String getSmallestAndLargest(String s, int k) {
        String smallest = "";
        String largest = "";
        String el;
        smallest = s.substring(0,k);
        largest = s.substring(0,k);
        for (int i = 0; i < (s.length()-k)+1; i++) {
            el = s.substring(i,k+i);
            if (el.compareTo(smallest)<0){
                smallest = el;
            }
            if (el.compareTo(largest)>0){
                largest =el;
            }
        }
        // Complete the function
        // 'smallest' must be the lexicographically smallest substring of length 'k'
        // 'largest' must be the lexicographically largest substring of length 'k'

        return smallest + "\n" + largest;
    }
}
