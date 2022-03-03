package HackerRank;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Scanner;

/*
Java MD5
MD5 (Message-Digest algorithm 5) is a widely-used cryptographic hash function with a 128-bit hash value.
Here are some common uses for MD5:

-To store a one-way hash of a password.
-To provide some assurance that a transferred file has arrived intact.

MD5 is one in a series of message digest algorithms designed by Professor Ronald Rivest of MIT
(Rivest, ); however, the security of MD5 has been severely compromised,
most infamously by the Flame malware in .
The CMU Software Engineering Institute essentially considers
MD5 to be "cryptographically broken and unsuitable for further use".

Given an alphanumeric string, s, denoting a password, compute and print its MD5 encryption value.

Input Format

A single alphanumeric string denoting s.

Constraints
* 6<=length(s)<=20
* String  consists of English alphabetic letters
(i.e.,[a-zA-Z]  and/or decimal digits (i.e., 0 through 9) only.

Output Format

Print the MD5 encryption value of s on a new line.

Sample Input 0
HelloWorld

Sample Output 0

68e109f0f40ca72a15e05cc22786f8e6
 */
public class Q024 {
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT.
        Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        String input = scan.next();
        scan.close();
        if (input.length()>=6 && input.length()<=20) {
            try {
                MessageDigest md = MessageDigest.getInstance("MD5");
                md.reset();
                md.update(input.getBytes());
                byte[] result = md.digest();
                for (byte b : result) {
                    System.out.printf("%02x", b);
                }
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
        }
    }
}
