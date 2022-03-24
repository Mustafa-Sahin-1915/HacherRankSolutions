package HackerRank.Regex;
/*
Regex>Grouping and Capturing>Alternative Matching

Alternations, denoted by the | character,
match a single item out of several possible items
separated by the vertical bar. When used inside a character class,
it will match characters; when used inside a group,
it will match entire expressions
(i.e., everything to the left or everything to the
right of the vertical bar). We must use parentheses
to limit the use of alternations.

Regex: (and|AND|And)  String:And the award to A and D Company
                     matches:And                and

For example:

(Bob|Kevin|Stuart) will match either Bob or Kevin or Stuart.
([a-f]|[A-F]) will match any of the following characters: a, b, c, d, e, f, A, B, C, D, E, or F.

Task

Given a test string,s , write a RegEx that matches s under the following conditions:

-s must start with Mr., Mrs., Ms., Dr. or Er..
-The rest of the string must contain only one
or more English alphabetic letters (upper and lowercase).

Sample Input
Mr.DOSHI
Sample Output
true

Sample Input
Mr.VKDoshi.
Sample Output
 */
public class Q07 {
    public static void main(String[] args) {

        String regexSolutionPattern = "^(Mr|Mrs|Ms|Dr|Er)\\.[a-zA-Z]+$";
        //String regexSolutionPattern = "^(Mr\\.|Mrs\\.|Ms\\.|Dr\\.|Er\\.)[a-zA-Z]+$";
        RegexTestClass.checker(regexSolutionPattern);
    }
}
