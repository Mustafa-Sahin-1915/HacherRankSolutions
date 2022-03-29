package HackerRank.Regex;

/*
Regex>Backreferences>Matching Same Text Again & Again
\group_number
This tool (\1 references the first capturing group) matches the same text
as previously matched by the capturing group.

regex:        (\\w)(\\w)(\\w)(\\w)y\\4\\3\\2\\1
test string:  malayalam

(\d)\1: It can match 00, 11, 22, 33, 44, 55, 66, 77, 88 or 99.
Task

You have a test string .
Your task is to write a regex that will match  with the following conditions:

S must be of length: 20
1. character: lowercase letter.
2. character: word character.
3. character: whitespace character.
4. character: non word character.
5. character: digit.
6. character: non digit.
7. character: uppercase letter.
8. character: letter (either lowercase or uppercase).
9. character: vowel (a, e, i , o , u, A, E, I, O or U).
10. character: non whitespace character.
11. character: should be same as 1st character.
12. character: should be same as 2nd character.
13. character: should be same as 3rd character.
14. character: should be same as 4th character.
15. character: should be same as 5th character.
16. character: should be same as 6th character.
17. character: should be same as 7th character.
18. character: should be same as 8th character.
19. character: should be same as 9th character.
20. character: should be same as 10th character.
 */
public class Q021 {
    public static void main(String[] args) {
        String regexSolutionPattern = "([a-z])(\\w)(\\s)(\\W)(\\d)(\\D)([A-Z])([a-zA-Z])([aeiouAEIOU])(\\S)" +
                "\\1\\2\\3\\4\\5\\6\\7\\8\\9\\10";

        RegexTestClass.checker(regexSolutionPattern);

    }
}
