package HackerRank.Regex;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
Regex>Introduction>Matching Anything But a Newline

testcase
123.456.abc.def

 */
public class Q02 {
    public static void main(String[] args) {

        String regexSolutionPattern = "^(.{3}\\.){3}.{3}$";

        RegexTestClass.checker(regexSolutionPattern);

    }
}
