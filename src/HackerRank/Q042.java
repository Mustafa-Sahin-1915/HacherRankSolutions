package HackerRank;

import java.util.BitSet;
import java.util.Scanner;

/*
Java>Data Structures>Java BitSet
Java's BitSet class implements a vector of bit values (i.e.: false (0) or true (1))
that grows as needed, allowing us to easily manipulate bits while optimizing space
(when compared to other collections). Any element having a bit value of 1 is called a set bit.

Given 2 BitSets, B_1 and B_2, of size N where all bits in both
BitSets are initialized to 0, perform a series of M operations.
After each operation, print the number of set bits in the respective BitSets
as two space-separated integers on a new line.

Input Format

The first line contains 2 space-separated integers,
N (the length of both BitSets B_1 and B_2) and
M (the number of operations to perform), respectively.
The M subsequent lines each contain an operation in one of the following forms:
AND <set><set>
OR <set><set>
XOR <set><set>
FLIP <set><index>
SET <set><index>

In the list above, <set> is the integer 1 or 2, where 1 denotes B_1  and 2 denotes B_2.

<index> is an integer denoting a bit's index in the BitSet corresponding to <set>.

For the binary operations AND, OR, and XOR, operands are read
from left to right and the BitSet resulting from the operation
replaces the contents of the first operand.
For example:
AND 2 1

B_2 is the left operand, and B_1 is the right operand.
This operation should assign the result of B_2 AND B_1 to B2.

Output Format

After each operation, print the respective number of set bits in
BitSet B_1 and BitSet B_2 as 2 space-separated integers on a new line.

Sample Input

5 4
AND 1 2
SET 1 4
FLIP 2 2
OR 2 1

Sample Output
0 0
1 0
1 1
1 2


 */
public class Q042 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();//number of elements in B_1 and B_2
        int m = scan.nextInt();//number of operations

        BitSet[] b = new BitSet[]{new BitSet(n), new BitSet(n)};

        String operation;
        int op1,op2;
        for (int i = 0; i < m; i++) {
            operation = scan.next();
            op1 = scan.nextInt();op1--;
            op2 = scan.nextInt();op2--;
            switch (operation){
                case "AND":
                    b[op1].and(b[op2]);
                    break;
                case "OR":
                    b[op1].or(b[op2]);
                    break;
                case "XOR":
                    b[op1].xor(b[op2]);
                    break;
                case "SET":
                    b[op1].set(op2+1);
                    break;
                case "FLIP":
                    b[op1].flip(op2+1);
                    break;
            }
            System.out.println(b[0].cardinality()+" "+b[1].cardinality());
        }
        scan.close();
    }

}
