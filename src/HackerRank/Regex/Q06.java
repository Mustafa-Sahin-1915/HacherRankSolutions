package HackerRank.Regex;
/*
Regex>Introduction>Matching Start & End
The ^ symbol matches the position at the start of a string.
Regex:^123   Test Sring:12345678 -> matches:123

The $ symbol matches the position at the end of a string.
Regex:123$   Test Sring:1245678123 -> matches:123 (at the end of string)

Task

You have a test string S. Your task is to match the pattern Xxxxx.
Here, x denotes a word character, and X denotes a digit.
S must start with a digit X and end with . symbol.
S should be 6 characters long only.

Sample Input
0qwer.
Sample Output
true

 */
public class Q06 {
    public static void main(String[] args) {

        String regexSolutionPattern = "^\\d(\\w){4,4}.$";

        RegexTestClass.checker(regexSolutionPattern);
    }
}
