package HackerRank.Regex;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTestClass {

    /*
    scans input string from user and checks its validity according to regex pattern
     */
    public static void checker(String Regex_Pattern){

        Scanner input = new Scanner(System.in);
        String Test_String = input.nextLine();
        Pattern p = Pattern.compile(Regex_Pattern);
        Matcher m = p.matcher(Test_String);
        System.out.println(m.find());
    }
}
