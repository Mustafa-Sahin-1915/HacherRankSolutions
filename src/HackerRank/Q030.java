package HackerRank;

import java.math.BigInteger;
import java.util.Scanner;

/*
Java>BigNumber>Java BigInteger
In this problem, you have to add and multiply huge numbers!
These numbers are so big that you can't contain
them in any ordinary data types like a long integer.

Use the power of Java's BigInteger class and solve this problem.
Input Format

There will be two lines containing two numbers, a and b.

Constraints

a and b are non-negative integers and can have maximum 300 digits.
Output Format

Output two lines.
The first line should contain a+b, and the second line should contain
a*b. Don't print any leading zeros.

Sample Input

1234
20
Sample Output

1254
24680
*/
public class Q030 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        BigInteger a= scan.nextBigInteger();
        BigInteger b = scan.nextBigInteger();
        System.out.println(a.add(b));
        System.out.println(a.multiply(b));
    }
}
