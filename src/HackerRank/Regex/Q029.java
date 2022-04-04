package HackerRank.Regex;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
Regex>Assertions>Positive Lookbehind
(?<=regex_2)regex_1
The positive lookbehind (?<=) asserts regex_1 to be immediately preceded by regex_2.
Lookbehind is excluded from the match (do not consume matches of regex_2),
but only assert whether a match is possible or not.

regex:(?<=[a-z])[aeiou]
test:   he10
         e    is matched.

Task

You have a test String S.
Write a regex which can match all the occurences of digit
which are immediately preceded by odd digit.

 */
public class Q029 {
    public static void main(String[] args) {
        String regexSolutionPattern = "(?<=[13579])[0-9]";
        Scanner input = new Scanner(System.in);
        String Test_String = input.nextLine();
        Pattern p = Pattern.compile(regexSolutionPattern);
        Matcher m = p.matcher(Test_String);
        int count =0;
        while (m.find()){
            count++;
        }
        System.out.println("Number of matches : "+count);
    }
}
