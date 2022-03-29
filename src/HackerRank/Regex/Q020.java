package HackerRank.Regex;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
Regex>Applications>Saying Hi

Given a sentence, s, write a RegEx to match the following criteria:

The first character must be the letter H or h.
The second character must be the letter I or i.
The third character must be a single space (i.e.:\\s ).
The fourth character must not be the letter D or d.

Given n lines of sentences as input,
 print each sentence matching your RegEx on a new line.

Input Format

The first line contains an integer, n , denoting the number of lines of sentences.
Each of the n subsequent lines contains some sentence s you must match.

Sample Input

5
Hi Alex how are you doing
hI dave how are you doing
Good by Alex
hidden agenda
Alex greeted Martha by saying Hi Martha
Sample Output

Hi Alex how are you doing

 private static final String IP6_PATTERN = "([a-f0-9]{1,4}:){7}\\b[0-9a-f]{1,4}\\b";
 */
public class Q020 {
    public static void main(String[] args) {
        String Regex_Pattern= "^[hH][iI]\\s[^dD].*";
        Scanner scan = new Scanner(System.in);
        int n =scan.nextInt();
        String str;
        Pattern p = Pattern.compile(Regex_Pattern);
        for (int i = 0; i < n; i++) {
            str = scan.nextLine();
            Matcher m = p.matcher(str);
            if (m.find()){
                System.out.println(m.group());
            }
        }
        scan.close();

    }
}
