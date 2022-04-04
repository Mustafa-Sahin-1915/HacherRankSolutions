package HackerRank.Regex;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
Regex>Applications>Find HackerRank
At HackerRank, we always want to find out how popular we are getting every day
and have scraped conversations from popular sites. Each conversation fits
in 1 line and there are N such conversations.
Each conversation has at most 1 word that says hackerrank (all in lowercase).
We would like you to help us figure out whether a conversation:

1. Starts with hackerrank
2. Ends with hackerrank
3. Start and ends with hackerrank

Input Format

First line of the input contains an integer, N. Then N lines follow.
From the second line onwards, each line contains a set of W words separated by a single space
Output Format

For every line,

1. Print 1 if the conversation starts with hackerrank
2. Print 2 if the conversation ends with hackerrank
3. Print 0 if the conversation starts and ends with hackerrank
4. Print -1 if none of the above.

Sample Input

4
i love hackerrank
hackerrank is an awesome place for programmers
hackerrank
i think hackerrank is a great place to hangout
Sample Output

2
1
0
-1

 */
public class Q031 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int n = input.nextInt();
        input.nextLine();
        String line="";
        for (int i = 0; i < n; i++) {
            line = input.nextLine();
            System.out.println(valOfRegex(line));
        }

    }
    public static int valOfRegex(String s){
        String startWithHackerrank = "^hackerrank.+";
        String endWithHackerrank = ".+hackerrank$";
        String startendWithHackerrank1 = "^hackerrank$";
        String startendWithHackerrank2 = "^(hackerrank).*\\1$";
        Pattern p1 = Pattern.compile(startWithHackerrank);
        Pattern p2 = Pattern.compile(endWithHackerrank);
        Pattern p3 = Pattern.compile(startendWithHackerrank1);
        Pattern p4 = Pattern.compile(startendWithHackerrank2);
        Matcher m = null;
        m= p3.matcher(s);//start and end with
        if (m.matches()){
            return 0;
        }
        m= p4.matcher(s);//start and end with
        if (m.matches()){
            return 0;
        }
        m = p1.matcher(s);//startwith
        if (m.matches()){
            return 1;
        }
        m= p2.matcher(s);//end with
        if (m.matches()){
           return 2;
        }

        return -1;
    }
}
