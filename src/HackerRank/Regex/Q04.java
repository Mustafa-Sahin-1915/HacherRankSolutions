package HackerRank.Regex;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
Regex>Introduction>Matching Whitespace & Non-Whitespace Character
\s matches any whitespace character [ \r\n\t\f ].
\S matches any non-white space character.
Task

You have a test string S. Your task is to match the pattern
XXxXXxXX
Here, x denotes whitespace characters, and X denotes non-white space characters.

sample
12 11 15

output
true

 */
public class Q04 {
    public static void main(String[] args) {

        Regex_Test5 tester = new Regex_Test5();
        tester.checker("(\\S{2}\\s){2}\\S{2}"); // Use \\ instead of using \

    }
}
class Regex_Test5 {

    public void checker(String Regex_Pattern){

        Scanner Input = new Scanner(System.in);
        String Test_String = Input.nextLine();
        Pattern p = Pattern.compile(Regex_Pattern);
        Matcher m = p.matcher(Test_String);
        System.out.println(m.find());
    }

}