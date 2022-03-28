package HackerRank.Regex;
/*
Regex>Repetitions>Matching One Or More Repetitions

The + tool will match one or more repetitions of character/character class/group.

Regex:Ab+s       test string: Abs | Abbbbs

For Example:

w+ : It will match the character w 1 or more times.
[xyz]+ : It will match the character x, y or z 1 or more times.
\d+ : It will match any digit 1 or more times.

Task

You have a test string S.
Your task is to write a regex that will match  using the following conditions:

S should begin with 1 or more digits.
After that, S should have 1 or more uppercase letters.
S should end with 1 or more lowercase letters.
 */
public class Q018 {
    public static void main(String[] args) {
        String regexSolutionPattern = "^\\d+[A-Z]+[a-z]+$";

        RegexTestClass.checker(regexSolutionPattern);
    }
}
