package HackerRank.Regex;
/*
Regex>Grouping and Capturing>Matching Word Boundaries
\b assert position at a word boundary.

Three different positions qualify for word boundaries :
► Before the first character in the string, if the first character is a word character.
► Between two characters in the string, where one is a word character and the other is not a word character.
► After the last character in the string, if the last character is a word character.

regex:\bcat\b  string:Acat =>false A cat =>true

Since digits are considered to be word characters,
\b4\b can be used to match a 4 that is not part of a larger number.
This regex does not match "44 sheets of a4".
So saying “\b matches before and after an alphanumeric sequence” is more exact
than saying “before and after a word”.

regex: \bis\b  string: This island is beautiful.
                                   is               matched one

Task

You have a test String S.
Your task is to write a regex which will
match word starting with vowel (a,e,i,o, u, A, E, I , O or U).
The matched word can be of any length.
The matched word should consist of letters (lowercase and uppercase both) only.
The matched word must start and end with a word boundary.
 */
public class Q013 {
    public static void main(String[] args) {
        String regexSolutionPattern = "\\b[a|e|i|o|u|A|E|I|O|U][a-zA-Z]*\\b";

        RegexTestClass.checker(regexSolutionPattern);
    }
}
