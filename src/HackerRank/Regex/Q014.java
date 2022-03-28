package HackerRank.Regex;
/*
Regex>Grouping and Capturing> Capturing & Non-Capturing Groups

Parenthesis ( ) around a regular expression can group that part of regex together.
This allows us to apply different quantifiers to that group.

These parenthesis also create a numbered capturing.
It stores the part of string matched by the part of regex inside parentheses.

These numbered capturing can be used for backreferences. ( We shall learn about it later )

regex: it is (not)? your fault   string: it is not your fault =>true
                                         it is your fault     =>true

(?: ) can be used to create a non-capturing group.
It is useful if we do not need the group to capture its match.

Task

You have a test String S.
Your task is to write a regex which will match S with the following condition:

-S should have 3 or more consecutive repetitions of ok.

Sample Input
okokok! cya
Sample Output
true

*/
public class Q014 {
    public static void main(String[] args) {
        String regexSolutionPattern = ".*(ok){3}.*";

        RegexTestClass.checker(regexSolutionPattern);
    }
}
