package HackerRank.Regex;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
You will be provided with N lines of what are possibly IP addresses.
You need to detect if the text contained in each of the
lines represents an (a)IPv4 address (b)IPv6 address or (c)None of these.

IPv4 was the first publicly used Internet Protocol
which used 4 byte addresses which permitted for 232 addresses.
The typical format of an IPv4 address is A.B.C.D where
A, B, C and D are Integers lying between 0 and 255 (both inclusive).

IPv6, with 128 bits was developed to permit the expansion of the address space.
To quote from the linked article: The 128 bits of an IPv6 address are represented
in 8 groups of 16 bits each. Each group is written as 4 hexadecimal digits
and the groups are separated by colons (:).
The address 2001:0db8:0000:0000:0000:ff00:0042:8329 is an example of this representation.
Consecutive sections of zeros will be left as they are.
An IPv6 value such as "...:0:..." or "...:5:..." is address-wise identical
to "...:0000:..." or "...:0005:....". Leading zeros may be omitted in writing the address.

Input Format
An integer N such that N <= 50.
This is followed by N lines such that each the text in each line is either
an IPv4 address or an IPv6 address, or a chunk of text which does not equal either of these.
There will be no extra text or whitespace leading or trailing the IP address in a line
(if it is an IP address). The number of characters in each line will not exceed 500.

Output Format
N lines.
The ith output line should equal (a)IPv4 or (b)IPv6 or (c)Neither depending on
what you detected the ith input line to be.

Sample Input

3
This line has junk text.
121.18.19.20
2001:0db8:0000:0000:0000:ff00:0042:8329
Sample Output

Neither
IPv4
IPv6

Sample Input
35
1050:0:0:0:5:600:300c:326b
1050:0:0:0:5:600:300c:326a
1050:0:0:0:5:600:300c:326c
1051:0:0:0:5:600:300c:326b
22.231.113.64
22.231.113.164
255.231.111.64
253.231.111.64
1050:10:0:0:5:600:300c:326b
1050:10:0:0:5:600:300c:326a
1050:10:0:0:5:600:300c:326c
1051:10:0:0:5:600:300c:326b
22.21.113.61
22.21.113.162
255.21.111.63
253.21.111.69
1050:10:0:0:15:600:300c:326b
1050:10:0:10:5:600:300c:326a
1050:10:10:0:5:600:300c:326c
1051:110:0:0:5:600:300c:326b
22.211.113.64
22.212.113.164
255.213.111.64
253.214.111.64
1050:10:0:0:15:600:300c:326k
1050:10:0:0:15:600:300c:326g
1050:10:0:0:15:600:300c:326h
1050:10:0:0:15:600:300c:326i
22.211.113.364
22.212.113.3164
255.213.111.464
253.214.111.564
not an ip address
not an ipv4 Address
Not an IPv5 Address

Sample Output
IPv6
IPv6
IPv6
IPv6
IPv4
IPv4
IPv4
IPv4
IPv6
IPv6
IPv6
IPv6
IPv4
IPv4
IPv4
IPv4
IPv6
IPv6
IPv6
IPv6
IPv4
IPv4
IPv4
IPv4
Neither
Neither
Neither
Neither
Neither
Neither
Neither
Neither
Neither
Neither
Neither
 */
public class Q09 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n =scanner.nextInt();
        String ipstr = null;
        for (int i = 0; i < n; i++) {
            ipstr = scanner.next();
            if (isIPV4(ipstr)){
                System.out.println("IPv4");
            }else if(isIPV6(ipstr)){
                System.out.println("IPv6");
            }else{
                System.out.println("Neither");
            }
        }
        scanner.close();
    }
    public static boolean isIPV4(String str){
        String zeroTo255
                = "(\\d{1,2}|(0|1)\\"
                + "d{2}|2[0-4]\\d|25[0-5])";
        String ipv4Regex = zeroTo255 + "\\." + zeroTo255 + "\\."+ zeroTo255 + "\\."+ zeroTo255;
        Pattern p = Pattern.compile(ipv4Regex);
        Matcher m = p.matcher(str);
        return m.find();
    }
    public static boolean isIPV6(String str){
        String chunkIPv6 = "([0-9a-fA-F]{1,4})";

        Pattern  p =Pattern.compile("^(" + chunkIPv6 + "\\:){7}" + chunkIPv6 + "$");
        Matcher m = p.matcher(str);
        return m.find();
    }
}
