package HackerRank.Regex;
/*
Regex>Repetitions>Matching {x} Repetitions
The tool {x} will match exactly  repetitions of character/character class/groups.

regex:\\w{4}   string: 4 a-zA-Z_0-9  sample:H_ck

Task

You have a test string S.
Your task is to write a regex that will match S using the following conditions:

-S must be of length equal to 45.
-The first 40 characters should consist of letters(both lowercase and uppercase),
or of even digits.
The last 5 characters should consist of odd digits or whitespace characters.

 */
public class Q015 {
    public static void main(String[] args) {
       // String regexSolutionPattern = "^[(a-z|A-Z)|(0|2|4|6|8)]{40}[(1|3|5|7|9)|\\s]{5}$";
        String regexSolutionPattern = "^[a-zA-Z02468)]{40}[13579\\s]{5}$";

        RegexTestClass.checker(regexSolutionPattern);
    }
}
