package HackerRank.Regex;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
Regex>Applications>Split the Phone Numbers
There is a list of phone numbers which needs the attention of a text processing expert.
As an expert in regular expressions, you are being roped in for the task.
A phone number directory can reveal a lot such as country codes and local area codes.
The only constraint is that one should know how to process it correctly.

A Phone number is of the following format

[Country code]-[Local Area Code]-[Number]

There might either be a '-' ( ascii value 45), or a ' ' ( space, ascii value 32) between the segments
Where the country and local area codes can have 1-3 numerals each and
the number section can have 4-10 numerals each.

And so, if we tried to apply the a regular expression with groups on this phone number: 1-425-9854706

We'd get:
Group 1 = 1
Group 2 = 425
Group 3 = 9854706

You will be provided a list of N phone numbers
which conform to the pattern described above.
Your task is to split it into the country code, local area code and the number.

Input Format

N, where N is the number of tests.
This will be followed by N lines containing N phone numbers in the format specified above.

Output Format

Your output will contain N lines.
CountryCode=[Country Code],LocalAreaCode=[Local Area Code],Number=[Number]

Recommended Technique

This problem can be solved in many ways, however,
try to solve it using regular expressions and
groups in order to gain a hands on practice of the concepts involved.

Sample Input

2
1 877 2638277
91-011-23413627
Sample Output

CountryCode=1,LocalAreaCode=877,Number=2638277
CountryCode=91,LocalAreaCode=011,Number=23413627

Test
6
148-809-2561957985
188-547-5864327428
891-454-9195497623
648-42-380306686
824-417-6460145493
489-16-9839392781

Test Output
CountryCode=148,LocalAreaCode=809,Number=2561957985
CountryCode=188,LocalAreaCode=547,Number=5864327428
CountryCode=891,LocalAreaCode=454,Number=9195497623
CountryCode=648,LocalAreaCode=42,Number=380306686
CountryCode=824,LocalAreaCode=417,Number=6460145493
CountryCode=489,LocalAreaCode=16,Number=9839392781
 */
public class Q039 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String phoneRegEx ="^(\\d+)([-|\\s])(\\d+)\\2(\\d+)$";
        Matcher mPhone = Pattern.compile(phoneRegEx).matcher("");
        int n = in.nextInt();
        in.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        for (int i = 0; i < n; i++) {
            String line = in.nextLine().trim();
            mPhone.reset(line);
            if (mPhone.find()) {
                String countryCode = mPhone.group(1).trim();
                String localAreaCode= mPhone.group(3).trim();
                String number = mPhone.group(4);
                System.out.println("CountryCode="+countryCode+",LocalAreaCode="+localAreaCode+",Number="+number);
            }
        }
    }
}
