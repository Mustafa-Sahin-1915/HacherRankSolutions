package HackerRank;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
*Write a class called MyRegex which will contain a string pattern.
* You need to write a regular expression and assign it
* to the pattern such that it can be used to validate an IP address.
* Use the following definition of an IP address:
*
* IP address is a string in the form "A.B.C.D",
* where the value of A, B, C, and D may range from 0 to 255.
* Leading zeros are allowed.
* The length of A, B, C, or D can't be greater than 3.

* Some valid IP address:

000.12.12.034
121.234.12.12
23.45.12.56
*
* Some invalid IP address:

000.12.234.23.23
666.666.23.23
.213.123.23.32
23.45.22.32.
I.Am.not.an.ip
*
* In this problem you will be provided strings containing any combination of ASCII characters.
* You have to write a regular expression to find the valid IPs.

Just write the MyRegex class which contains a String .
* The string should contain the correct regular expression.

(MyRegex class MUST NOT be public)
*Sample Input

000.12.12.034
121.234.12.12
23.45.12.56
00.12.123.123123.123
122.23
Hello.IP
Sample Output

true
true
true
false
false
false
 * */
public class Q020 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            String IP = in.next();
            System.out.println(IP.matches(new MyRegex().pattern));
        }
    }
}

class MyRegex{
    public String pattern="null";
    String zeroTo255
            = "(\\d{1,2}|(0|1)\\"
            + "d{2}|2[0-4]\\d|25[0-5])";

    public MyRegex(){
        //pattern ="^([0-9]{1,3})\\.([0-9]{1,3})\\.([0-9]{1,3})\\.([0-9]{1,3})$";
       // pattern ="^([0-9]{1,3})\\.([0-9]{1,3})\\.([0-9]{1,3})\\.([0-9]{1,3})$\n";
       // pattern ="^(?:[0-9]{1,3}\.){3}[0-9]{1,3}$";
      //  pattern ="\\b([0-9]{1,3})\\.([0-9]{1,3})\\.([0-9]{1,3})\\.([0-9]{1,3})\\b";
      //  pattern ="\\b(((2[0-5][0-5])|(1[0-9][0-9])|(\\b[1-9][0-9]\\b)|(\\b\\d\\b))\\.){3}((2[0-5][0-5])|(1[0-9][0-9])|(\\b[1-9][0-9]\b)|(\\b\\d\\b))\\b";
        //pattern_IPV6="([a-f0-9]{1,4}:){7}\b[0-9a-f]{1,4}\b";
        pattern
                = zeroTo255 + "\\."
                + zeroTo255 + "\\."
                + zeroTo255 + "\\."
                + zeroTo255;
    }
}
