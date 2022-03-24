package HackerRank.Regex;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
Regex>Introduction>Matching Digits & Non-Digit Characters
\\d : matches any digit [0-9]

Regex:\\d\\d\\d   test string:Hack101  matches:101

\\D :matches any character that is not digit

Regex:\\D\\D\\D   test string:Hack101  matches:Hack

Task

You have a test string S. Your task is to match the pattern
xxXxxXxxxx
Here x denotes a digit character, and X denotes a non-digit character.

 */
public class Q03 {
    public static void main(String[] args) {
        String regexSolutionPattern = "(\\d\\d\\D){2}(\\d){4}";

        RegexTestClass.checker(regexSolutionPattern);


    }
}
