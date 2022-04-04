package HackerRank.Regex;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
Regex>Assertions>Positive Lookahead
regex_1(?=regex_2)

The positive lookahead (?=) asserts regex_1 to be immediately
followed by regex_2. The lookahead is excluded from the match.
It does not return matches of regex_2.
The lookahead only asserts whether a match is possible or not.
ex: c(?=o)
test:  chocolate
          c              is matched

Task

You have a test string S.
Write a regex that can match all occurrences of o followed
immediately by oo in S.

output:Number of matches : num
 */
public class Q027 {
    public static void main(String[] args) {
        String regexSolutionPattern = "o(?=oo)";
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
