package HackerRank.Regex;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* Regex>Assertions>Negative Lookahead
regex_1(?!regex_2)
The negative lookahead (?!) asserts regex_1 not to be immediately followed by regex_2.
Lookahead is excluded from the match (do not consume matches of regex_2),
but only assert whether a match is possible or not.

regex: c(?!o)
test: chocolate
      c          is matched

Task

You have a test String S.
Write a regex which can match all characters
which are not immediately followed by that same character.

Example

If S = goooo, then regex should match goooo.
                                      g   o
Because the first g is not followed by g and the last o is not followed by o.

 */
public class Q028 {
    public static void main(String[] args) {
        String regexSolutionPattern = "(.)(?!\\1)";
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
