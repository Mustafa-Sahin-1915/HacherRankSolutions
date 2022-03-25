package HackerRank.Regex;
/*
Regex>Character Class>Matching Character Ranges
In the context of a regular expression (RegEx),
a character class is a set of characters enclosed within square brackets
that allows you to match one character in the set.

A hyphen (-) inside a character class specifies a range of characters
where the left and right operands are the respective
lower and upper bounds of the range. For example:
-[a-z] same as [abcdefghiklmnopqrstuvwyz]
-[A-Z]
-[0-9] same as [0123456789]

Regex:[x-z][4-8][A-K]  string:x5F  =>true

Task

Write a RegEx that will match a string satisfying the following conditions:

-The string's length is >=5.
-The first character must be a lowercase English alphabetic character.
-The second character must be a positive digit.
Note that we consider zero to be neither positive nor negative.
-The third character must not be a lowercase English alphabetic character.
-The fourth character must not be an uppercase English alphabetic character.
-The fifth character must be an uppercase English alphabetic character.
 */
public class Q012 {
    public static void main(String[] args) {
        String regexSolutionPattern = "^[a-z][1-9][^a-z][^A-Z][A-Z].*";

        RegexTestClass.checker(regexSolutionPattern);
    }
}
