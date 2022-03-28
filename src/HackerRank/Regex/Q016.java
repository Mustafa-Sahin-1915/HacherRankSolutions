package HackerRank.Regex;
/*
Regex>Repetitions>Matching {x, y} Repetitions
 The {x,y} tool will match between x and y (both inclusive)
 repetitions of character/character class/group.

 regex:\\w{1,4}\\d{4,}   test string:Hk123123123123  | Hack1021

 For Example:

w{3,5} : It will match the character w 3,4  or 5  times.
[xyz]{5,} : It will match the character x, y or z  or 5 more times.
\d{1, 4} : It will match any digits 1,2 ,3 , or 4 times.

Task

You have a test string S.
Your task is to write a regex that will match  using the following conditions:

- S should begin with 1 or 2 digits.
After that, S should have 3 or more letters (both lowercase and uppercase).
Then S should end with up to 3 . symbol(s).
You can end with 0 to 3 . symbol(s), inclusively.
 */
public class Q016 {
    public static void main(String[] args) {
        String regexSolutionPattern = "^\\d{1,2}[a-zA-Z]{3,}\\.{0,3}$";

        RegexTestClass.checker(regexSolutionPattern);
    }
}
