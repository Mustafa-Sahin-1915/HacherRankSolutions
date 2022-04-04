package HackerRank.Regex;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
Regex>Applications>Saying Hi
Given a sentence, s, write a RegEx to match the following criteria:

1. The first character must be the letter H or h .
2. The second character must be the letter I or i .
3. The third character must be a single space (i.e.: \\s).
4. The fourth character must not be the letter D or d.
Given n lines of sentences as input,
print each sentence matching your RegEx on a new line.
Input Format

The first line contains an integer, n , denoting the number of lines of sentences.
Each of the n subsequent lines contains some sentence  you must match.
Output Format

Find each sentence,s , satisfying the RegEx criteria mentioned above,
and print it on a new line.
 */
public class Q032 {
    public static void main(String[] args) {
        String regexSolutionPattern = "^[Hh][Ii]\\s[^Dd].*$";

        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        input.nextLine();
        String line;
        for (int i = 0; i < n; i++) {
            line =input.nextLine();
            if (line.matches(regexSolutionPattern)){
                System.out.println(line);
            }
        }
        input.close();
    }
}
