package HackerRank.Regex;
/*
Regex>Repetitions>Matching Ending Items
The $ boundary matcher matches an occurrence of a
character/character class/group at the end of a line.

Regex:\w*s$  test string:challenges hints

Task

Write a RegEx to match a test string,S , under the following conditions:

S should consist of only lowercase and uppercase letters (no numbers or symbols).
S should end in s.

 */
public class Q019 {
    public static void main(String[] args) {
        String regexSolutionPattern = "^[a-zA-Z]*s$";

        RegexTestClass.checker(regexSolutionPattern);
    }
}
