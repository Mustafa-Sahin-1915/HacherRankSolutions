package HackerRank.Regex;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
Regex>Introduction>Matching Whitespace & Non-Whitespace Character
\s matches any whitespace character [ \r\n\t\f ].
\S matches any non-white space character.
Task

You have a test string S. Your task is to match the pattern
XXxXXxXX
Here, x denotes whitespace characters, and X denotes non-white space characters.

sample
12 11 15

output
true

 */
public class Q04 {
    public static void main(String[] args) {
        String regexSolutionPattern = "(\\S{2}\\s){2}\\S{2}";

        RegexTestClass.checker(regexSolutionPattern);


    }
}
