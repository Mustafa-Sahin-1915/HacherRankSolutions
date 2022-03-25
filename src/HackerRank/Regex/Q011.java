package HackerRank.Regex;
/*
Regex>Character Class>Excluding Specific Characters
The negated character class [^] matches any character that is not in the square brackets.

regex:[^aeiou]  string: k is not a vowel (all characters except vowels)
Task

You have a test string S.
Your task is to write a regex that will match S with the following conditions:

-S must be of length 6.
-First character should not be a digit ( 1,2,3,4,5,6,7,8,9 or0  ).
-Second character should not be a lowercase vowel ( a,e,i,o or u ).
-Third character should not be b, c, D or F.
-Fourth character should not be a whitespace character ( \r, \n, \t, \f or <space> ).
-Fifth character should not be a uppercase vowel ( A,E,I,O or U  ).
-Sixth character should not be a . or , symbol.

 Sample Input

 Sample Output

 */
public class Q011 {
    public static void main(String[] args) {
        String regexSolutionPattern = "^[^\\d][^a|e|i|o|u][^b|c|D|F][^\\s][^A|E|I|O|U][^.|,]$";

        RegexTestClass.checker(regexSolutionPattern);
    }
}
