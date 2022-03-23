package HackerRank.Regex;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
Regex>Introduction>Matching Word & Non-Word Character

The expression \\w will match any word character.
Word characters include alphanumeric characters (a-z, A-Z and 0-9) and underscores (_).

\\W matches any non-word character.

Task

You have a test string S. Your task is to match the pattern
xxxXxxxxxxxxxxXxxx
Here x denotes any word character and X denotes any non-word character.

Sample
www.hackerrank.com
Output
true
 */
public class Q05 {
    public static void main(String[] args) {

        Regex_Test tester = new Regex_Test();
        tester.checker("\\w{3}\\W\\w{10}\\W\\w{3}"); // Use \\ instead of using \

    }
}
class Regex_Test6 {

    public void checker(String Regex_Pattern){

        Scanner Input = new Scanner(System.in);
        String Test_String = Input.nextLine();
        Pattern p = Pattern.compile(Regex_Pattern);
        Matcher m = p.matcher(Test_String);
        System.out.println(m.find());
    }

}