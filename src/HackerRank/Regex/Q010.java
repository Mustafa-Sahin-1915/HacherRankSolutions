package HackerRank.Regex;
/*
Regex>Character Class>Matching Specific Characters
The character class [ ] corner brackets matches only one out of
several characters placed inside the square brackets.

regex:[aeiou] String:o is a vowel (every wovel)

Task

You have a test string S.
Your task is to write a regex that will match S with following conditions:

-S must be of length: 6
-First character: 1, 2 or 3
-Second character: 1, 2 or 0
-Third character: x, s or 0
-Fourth character: 3, 0 , A or a
-Fifth character: x, s or u
-Sixth character: . or ,

sample input
1203x.
sample output
true

 */


public class Q010 {
    public static void main(String[] args) {
        String regexSolutionPattern = "^[1|2|3][1|2|0][x|s|0][3|0|A][x|s|u][.|,]$";

        RegexTestClass.checker(regexSolutionPattern);
    }
}
