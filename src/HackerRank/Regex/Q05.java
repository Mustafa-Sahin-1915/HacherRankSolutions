package HackerRank.Regex;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
Regex>Introduction>Matching Word & Non-Word Character

The expression \\w will match any word character.
Word characters include alphanumeric characters (a-z, A-Z and 0-9) and underscores (_).

\\W matches any non-word character.

Task

You have a test string S. Your task is to match the pattern
xxxXxxxxxxxxxxXxxx
Here x denotes any word character and X denotes any non-word character.

Sample
www.hackerrank.com
Output
true
 */
public class Q05 {
    public static void main(String[] args) {

        String regexSolutionPattern = "\\w{3}\\W\\w{10}\\W\\w{3}";

        RegexTestClass.checker(regexSolutionPattern);


    }
}
